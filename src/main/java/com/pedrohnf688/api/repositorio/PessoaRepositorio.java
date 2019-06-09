package com.pedrohnf688.api.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrohnf688.api.modelo.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer>{
	
	Optional<Pessoa> findByEmailAndSenha(String email, String senha);
	
}
