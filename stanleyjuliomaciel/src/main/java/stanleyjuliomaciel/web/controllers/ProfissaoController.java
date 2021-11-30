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
import stanleyjuliomaciel.service.EmpresaService;

@Controller
@RequestMapping("/profissao")
		 
public class ProfissaoController {
	
	@Autowired
	private ProfissaoService profissaoService;
	private EmpresaService empresaService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Profissao profissao) {
		return "/profissao/cadastrar";
	 }
			
			
	@GetMapping("/listar")
	public String listar(ModelMap model ) {
		model.addAttribute("cargos", profissaoService.buscarTodos());
		return "/profissao/listar";
	}
	
	@PostMapping("/salvar")
	public String Salvar(Profissao profissao, RedirectAttributes attr) {
		profissaoService.salvar(profissao);
		attr.addFlashAttribute("success", "Profissao inserida com sucesso.");
		return "redirect:/profissao/cadastrar";
	 }
	
	@ModelAttribute("empresa")
	public List<Empresa> listaDeEmpresas(){
	
		return empresaService.buscarTodos();
	}
	

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id, ModelMap model) {
		
		model.addAttribute("profissao", profissaoService.buscarPorId(id));
		return "redirect:/profissao/cadastrar";
		
	}
	
	public String editar(Profissao profissao, RedirectAttributes attr) {
		profissaoService.editar(profissao);
		attr.addFlashAttribute("success", "Profissão alterada com sucesso.");
		return "redirect:/profissao/cadastrar";
	}
	
	@GetMapping
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if(profissaoService.profissaoTemCliente(id)) {
			model.addAttribute("fail", "Profissao não removido. ainda há clientes vinculados a ele.");
		}else {
			profissaoService.excluir(id);
			model.addAttribute("success", "Profissao excluída com sucesso.");
			
		}
		return listar(model);
	}
	

}
