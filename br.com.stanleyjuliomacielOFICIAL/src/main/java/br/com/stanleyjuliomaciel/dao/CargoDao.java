package br.com.stanleyjuliomaciel.dao;

import br.com.stanleyjuliomaciel.domain.Cargo;

public interface CargoDao {

		void save(Cargo cargo);
		
		void update(Cargo cargo);
		
		void delete(Long id);
		
		Cargo findById(Long id);
		
		
		java.util.List<Cargo> findAll();
	}



