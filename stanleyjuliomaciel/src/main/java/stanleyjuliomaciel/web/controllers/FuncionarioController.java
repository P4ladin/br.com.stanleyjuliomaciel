package stanleyjuliomaciel.web.controllers;

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

import stanleyjuliomaciel.domain.Profissao;
import stanleyjuliomaciel.domain.Empresa;
import stanleyjuliomaciel.domain.Cliente;
import stanleyjuliomaciel.domain.UF;
import stanleyjuliomaciel.service.CargoService;
import stanleyjuliomaciel.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private CargoService cargoService;
	private FuncionarioService funcionarioService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "/funcionarios/cadastrar";
	}
		
		
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.buscarTodos());
		return "/funcionario/listar";
	}
	
	@PostMapping("/salvar")
	public String Salvar(Cliente cliente, RedirectAttributes attr) {
		funcionarioService.salvar(cliente);
		attr.addFlashAttribute("success", "Funcionário cadastrado com sucesso.");
		return "redirect:/funcionario/cadastrar";
	 }
	
	@ModelAttribute("cargos")
	public List<Profissao> getCargos(){
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs(){
		return UF.values();
	}
	

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id, ModelMap model) {
		
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "redirect:/funcionario/cadastrar";
		
	}
	
	public String editar(Cliente cliente, RedirectAttributes attr) {
		funcionarioService.editar(cliente);
		attr.addFlashAttribute("success", "Funcionário alterado com sucesso.");
		return "redirect:/funcionario/cadastrar";
	}
	
	@GetMapping
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
	
			funcionarioService.excluir(id);
			attr.addFlashAttribute("success", "Funcionário excluído com sucesso.");
			
		
			return "redirect:/funcionario/listar";
	}

}
