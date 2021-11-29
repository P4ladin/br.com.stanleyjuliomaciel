package stanleyjuliomaciel.service;

import java.util.List;

import stanleyjuliomaciel.domain.Cargo;
import stanleyjuliomaciel.domain.Departamento;


public interface CargoService {
	
	void salvar (Cargo cargo); 
	
	void editar (Cargo cargo); 
	
	void excluir (Long id); 
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();

	boolean cargoTemFuncionario(Long id);

}
