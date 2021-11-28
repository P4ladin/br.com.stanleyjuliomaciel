package br.com.stanleyjuliomaciel.dao;

import org.springframework.stereotype.Repository;

import br.com.stanleyjuliomaciel.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
