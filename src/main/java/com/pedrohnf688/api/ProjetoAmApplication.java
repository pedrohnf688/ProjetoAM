package com.pedrohnf688.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrohnf688.api.repositorio.PessoaRepositorio;

@SpringBootApplication
public class ProjetoAmApplication {

	@Autowired
	private PessoaRepositorio pessoaRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAmApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//
//			Pessoa p = new Pessoa();
//			p.setNome("teste");
//			p.setSenha("teste");
//			p.setEmail("teste@live.com");

//			this.pessoaRepositorio.save(p);
//						
//		};
//	}

}
