package br.com.stanleyjuliomaciel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long> {
	
	@Column(name = nome, nullable = false, unique = true, length = 60)
	private String nome;

}
