package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.DadosPagamento;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private CarrinhoCompras carrinho;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping(value="/finalizar", method=RequestMethod.POST)
    public Callable<ModelAndView> finalizar(RedirectAttributes attributes) {
	return () -> {
	    try {
		    String uri = "http://book-payment.herokuapp.com/payment";
		    String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
		    System.out.println(response);
		    attributes.addFlashAttribute("sucesso", response);
		} catch (HttpClientErrorException ex) {
		    attributes.addFlashAttribute("falha", "Pagamento não autorizado");
		}
		return new ModelAndView("redirect:/produtos");
	};
    }
    
}
