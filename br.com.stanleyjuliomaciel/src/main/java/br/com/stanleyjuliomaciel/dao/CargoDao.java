package br.com.stanleyjuliomaciel.dao;

import br.com.stanleyjuliomaciel.domain.Cargo;
import br.com.stanleyjuliomaciel.domain.Departamento;

public interface CargoDao {

		void save(Cargo cargo);
		
		void update(Cargo cargo);
		
		void delete(long id);
		
		Departamento findById(long id);
		
		
		java.util.List<Cargo> findAll();
	}



