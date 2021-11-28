package br.com.stanleyjuliomaciel.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.stanleyjuliomaciel.domain.Cargo;
import br.com.stanleyjuliomaciel.domain.Departamento;
import br.com.stanleyjuliomaciel.service.CargoService;
import br.com.stanleyjuliomaciel.service.DepartamentoService;

@Controller
@RequestMapping("/cargo")
		 
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	private DepartamentoService departamentoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastrar";
	 }
			
			
	@GetMapping("/listar")
	public String listar(ModelMap model ) {
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "/cargo/listar";
	}
	
	@PostMapping("/salvar")
	public String Salvar(Cargo cargo, RedirectAttributes attr) {
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/cargo/cadastrar";
	 }
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDeaprtamentos(){
	
		return departamentoService.buscarTodos();
	}
	

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id, ModelMap model) {
		
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "redirect:/cargo/cadastrar";
		
	}
	
	public String editar(Cargo cargo, RedirectAttributes attr) {
		cargoService.editar(cargo);
		attr.addFlashAttribute("success", "Cargo alterado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if(cargoService.cargoTemFuncionario(id)) {
			model.addAttribute("fail", "Cargo não removido. ainda há funcionários vinculados a ele.");
		}else {
			cargoService.excluir(id);
			model.addAttribute("success", "Cargo excluído com sucesso.");
			
		}
		return listar(model);
	}
	

}
