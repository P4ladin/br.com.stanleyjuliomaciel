package stanleyjuliomaciel.dao;

import antlr.collections.List;
import stanleyjuliomaciel.domain.Empresa;

public interface DepartamantoDao {

	void save(Empresa empresa);
	
	void update(Empresa deaprtamento);
	
	void delete(Long id);
	
	Empresa findById(Long id);
	
	
	java.util.List<Empresa> findAll();
}
