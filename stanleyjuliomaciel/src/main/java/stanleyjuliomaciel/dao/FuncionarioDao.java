package stanleyjuliomaciel.dao;

import stanleyjuliomaciel.domain.Cliente;

public interface FuncionarioDao {

	

	void save(Cliente cliente);
		
	void update(Cliente cliente);
		
	void delete(Long id);
		
	Cliente findById(Long id);
		
		
	java.util.List<Cliente> findAll();
	}


