package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
public class UsuarioDao implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	return manager.find(Usuario.class, email);
    }

    public void gravar(Usuario usuario) {
	manager.persist(usuario);
    }

}
