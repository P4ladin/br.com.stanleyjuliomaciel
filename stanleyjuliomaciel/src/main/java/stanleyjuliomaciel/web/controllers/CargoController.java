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
import stanleyjuliomaciel.service.ProfissaoService;
import stanleyjuliomaciel.service.DepartamentoService;

@Controller
@RequestMapping("/cargo")
		 
public class CargoController {
	
	@Autowired
	private ProfissaoService profissaoService;
	private DepartamentoService departamentoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Profissao profissao) {
		return "/cargo/cadastrar";
	 }
			
			
	@GetMapping("/listar")
	public String listar(ModelMap model ) {
		model.addAttribute("cargos", profissaoService.buscarTodos());
		return "/cargo/listar";
	}
	
	@PostMapping("/salvar")
	public String Salvar(Profissao profissao, RedirectAttributes attr) {
		profissaoService.salvar(profissao);
		attr.addFlashAttribute("success", "Profissao inserido com sucesso.");
		return "redirect:/cargo/cadastrar";
	 }
	
	@ModelAttribute("departamentos")
	public List<Empresa> listaDeDeaprtamentos(){
	
		return departamentoService.buscarTodos();
	}
	

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id, ModelMap model) {
		
		model.addAttribute("cargo", profissaoService.buscarPorId(id));
		return "redirect:/cargo/cadastrar";
		
	}
	
	public String editar(Profissao profissao, RedirectAttributes attr) {
		profissaoService.editar(profissao);
		attr.addFlashAttribute("success", "Profissao alterado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if(profissaoService.cargoTemFuncionario(id)) {
			model.addAttribute("fail", "Profissao não removido. ainda há funcionários vinculados a ele.");
		}else {
			profissaoService.excluir(id);
			model.addAttribute("success", "Profissao excluído com sucesso.");
			
		}
		return listar(model);
	}
	

}
