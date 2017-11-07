package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {

    @Bean
<<<<<<< HEAD
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
=======
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties aditionalProperties) {
>>>>>>> Initial Commit
	LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
	
	//vendorAdapter é para saber qual implementação da JPA está sendo utilizada
	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	factoryBean.setJpaVendorAdapter(vendorAdapter);
	factoryBean.setPackagesToScan("br.com.casadocodigo.loja.models");
	
	factoryBean.setDataSource(dataSource);
<<<<<<< HEAD
	factoryBean.setJpaProperties(aditionalProperties());	
=======
	factoryBean.setJpaProperties(aditionalProperties);	
>>>>>>> Initial Commit
	
	return factoryBean;
    }
    
    @Bean
    @Profile("dev")
    public DataSource dataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	
	dataSource.setUsername("root");
	dataSource.setPassword("root");
	dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	
	return dataSource;
    }
    
    @Bean
<<<<<<< HEAD
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
	return new JpaTransactionManager(emf);
    }
    
    private Properties aditionalProperties() {
=======
    @Profile("dev")
    public Properties aditionalProperties() {
>>>>>>> Initial Commit
	Properties props = new Properties();
	props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	props.setProperty("hibernate.show_sql", "true");
	props.setProperty("hibernate.hbm2ddl.auto", "update");
	
	return props;
    }
    
<<<<<<< HEAD
=======
    @Bean
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
	return new JpaTransactionManager(emf);
    }
    
>>>>>>> Initial Commit
}
