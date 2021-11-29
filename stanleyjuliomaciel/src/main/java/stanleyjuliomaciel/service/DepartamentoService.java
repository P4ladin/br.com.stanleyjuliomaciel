package stanleyjuliomaciel.service;

import java.util.List;

import stanleyjuliomaciel.domain.Empresa;

public interface DepartamentoService {

	
	void salvar (Empresa empresa); 
	
	void editar (Empresa empresa); 
	
	void excluir (Long id); 
	
	Empresa buscarPorId(Long id);
	
	List<Empresa> buscarTodos();

	boolean departamentoTemCargos(Long id);

}

