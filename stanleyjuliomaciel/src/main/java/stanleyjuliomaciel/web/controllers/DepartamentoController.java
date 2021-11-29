package stanleyjuliomaciel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import stanleyjuliomaciel.domain.Empresa;
import stanleyjuliomaciel.service.EmpresaService;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	private EmpresaService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar( ) {
		return "/departamento/cadastrar";
	}
		
		
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("Empresa", service.buscarTodos());
		return "/departamento/listar";
	}
	
	@PostMapping("/salvar")
	public String Salvar(Empresa empresa, RedirectAttributes attr) {
		service.salvar(empresa);
		attr.addFlashAttribute("success", "Empresa salvo com sucesso.");
		return "redirect:/departamento/cadastrar";
	 }
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id, ModelMap model) {
		
		model.addAttribute("departamento", service.buscarPorId(id));
		return "redirect:/departamento/cadastrar";
		
	}
	
	public String editar(Empresa empresa, RedirectAttributes attr) {
		service.editar(empresa);
		attr.addFlashAttribute("success", "Empresa alterado com sucesso.");
		return "redirect:/departamento/cadastrar";
	}
	
	@GetMapping
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if(service.departamentoTemCargos(id)) {
			model.addAttribute("fail", "Empresa não removido. ainda há casrgos vinculados a ele.");
		}else {
			service.excluir(id);
			model.addAttribute("success", "departamento excluído com sucesso.");
			
		}
		return listar(model);
	}
}
		
	


