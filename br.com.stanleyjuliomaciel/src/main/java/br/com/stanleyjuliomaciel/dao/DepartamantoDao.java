package br.com.stanleyjuliomaciel.dao;

import antlr.collections.List;
import br.com.stanleyjuliomaciel.domain.Departamento;

public interface DepartamantoDao {

	void save(Departamento departamento);
	
	void update(Departamento deaprtamento);
	
	void delete(long id);
	
	Departamento findById(long id);
	
	
	java.util.List<Departamento> findAll();
}
