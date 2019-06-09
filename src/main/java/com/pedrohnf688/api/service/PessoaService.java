package com.pedrohnf688.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pedrohnf688.api.modelo.Pessoa;
import com.pedrohnf688.api.repositorio.PessoaRepositorio;

@Service
@Transactional
public class PessoaService {

	@Autowired
	private PessoaRepositorio pessoaRepositorio;

	public PessoaService(PessoaRepositorio pessoaRepositorio) {
		this.pessoaRepositorio = pessoaRepositorio;
	}

	public void salvar(Pessoa pessoa) {
		this.pessoaRepositorio.save(pessoa);
	}

	public List<Pessoa> listarPessoas() {
		return this.pessoaRepositorio.findAll();
	}

	public void deletarPorId(Integer id) {
		this.pessoaRepositorio.deleteById(id);
	}

	public Optional<Pessoa> atualizarPessoaPorId(Integer id) {
		Optional<Pessoa> p = this.pessoaRepositorio.findById(id);
		return p;
	}

	public Optional<Pessoa> BuscarPorEmailESenha(String email, String senha) {
		return this.pessoaRepositorio.findByEmailAndSenha(email, senha);
	}

}
