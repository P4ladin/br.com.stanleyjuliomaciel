package br.com.stanleyjuliomaciel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.stanleyjuliomaciel.domain.Departamento;
import br.com.stanleyjuliomaciel.service.DepartamentoService;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar( ) {
		return "/departamento/cadastro";
	}
		
		
	@GetMapping("/listar")
	public String listar( ) {
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String Salvar(Departamento departamento) {
		service.salvar(departamento);
		return "redirect:/departamentos/cadastrar";
	}

}
