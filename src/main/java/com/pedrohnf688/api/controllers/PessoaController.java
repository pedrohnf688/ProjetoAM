package com.pedrohnf688.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pedrohnf688.api.modelo.Pessoa;
import com.pedrohnf688.api.repositorio.PessoaRepositorio;
import com.pedrohnf688.api.service.PessoaService;

@Controller
@RequestMapping("/")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private PessoaRepositorio pessoaRepositorio;

	@GetMapping
	public String login() {
		return "login";
	}


    @GetMapping("/listarUsuarios")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView();
		Iterable<Pessoa> pessoas = pessoaService.listarPessoas();
		mv.setViewName("listarUsuarios");
		mv.addObject("pessoas", pessoas);
		return mv;
	}
	
	

	@PostMapping
	public String cadastrar(Pessoa p) {
		pessoaService.salvar(p);
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute(name = "pessoa") Pessoa pessoa, Model model) {
		String email = pessoa.getEmail();
		String senha = pessoa.getSenha();

		Optional<Pessoa> p = pessoaRepositorio.findByEmailAndSenha(email, senha);

		if (p.isPresent()) {
			return "redirect:/listarUsuarios";
		}

		model.addAttribute("Credenciais Invalidas", true);

		return "redirect:/";
	}

}
