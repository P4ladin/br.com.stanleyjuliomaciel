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
import stanleyjuliomaciel.service.ProfissaoService;
import stanleyjuliomaciel.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ProfissaoService profissaoService;
	private ClienteService clienteService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "/cliente/cadastrar";
	}
		
		
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionario", clienteService.buscarTodos());
		return "/cliente/listar";
	}
	
	@PostMapping("/salvar")
	public String Salvar(Cliente cliente, RedirectAttributes attr) {
		clienteService.salvar(cliente);
		attr.addFlashAttribute("success", "Funcionário cadastrado com sucesso.");
		return "redirect:/cliente/cadastrar";
	 }
	
	@ModelAttribute("cargos")
	public List<Profissao> getCargos(){
		return profissaoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs(){
		return UF.values();
	}
	

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id, ModelMap model) {
		
		model.addAttribute("cliente", clienteService.buscarPorId(id));
		return "redirect:/cliente/cadastrar";
		
	}
	
	public String editar(Cliente cliente, RedirectAttributes attr) {
		clienteService.editar(cliente);
		attr.addFlashAttribute("success", "Cliente alterado com sucesso.");
		return "redirect:/cliente/cadastrar";
	}
	
	@GetMapping
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
	
			clienteService.excluir(id);
			attr.addFlashAttribute("success", "Cliente excluído com sucesso.");
			
		
			return "redirect:/cliente/listar";
	}

}
