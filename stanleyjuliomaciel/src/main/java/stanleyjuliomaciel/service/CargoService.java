package stanleyjuliomaciel.service;

import java.util.List;

import stanleyjuliomaciel.domain.Profissao;
import stanleyjuliomaciel.domain.Empresa;


public interface CargoService {
	
	void salvar (Profissao profissao); 
	
	void editar (Profissao profissao); 
	
	void excluir (Long id); 
	
	Profissao buscarPorId(Long id);
	
	List<Profissao> buscarTodos();

	boolean cargoTemFuncionario(Long id);

}
