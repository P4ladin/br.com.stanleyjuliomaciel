package br.com.stanleyjuliomaciel.domain;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.core.sym.Name;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")

public class Funcionario extends AbstractEntity<Long> {
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario;
	
	@Column(name = "data-entrada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@Column(name = "data-saida", columnDefinition = "DATE")
	private LocalDate dataSaida;
	
	@OneToOne
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	
	@ManyToOne
	@JoinColumn(name = "cargo_id_fk")
	private Cargo cargo;
	
	
}
