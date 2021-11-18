package br.com.stanleyjuliomaciel.dao;

import br.com.stanleyjuliomaciel.domain.Funcionario;

public interface FuncionarioDao {

	

	void save(Funcionario funcionario);
		
	void update(Funcionario funcionario);
		
	void delete(Long id);
		
	Funcionario findById(Long id);
		
		
	java.util.List<Funcionario> findAll();
	}


