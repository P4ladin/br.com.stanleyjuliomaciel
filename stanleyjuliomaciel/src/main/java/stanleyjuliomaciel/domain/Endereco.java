package stanleyjuliomaciel.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {
	
	@Column(name = "Logradouro", nullable = false)
	private String logradouro;

	@Column(name = "Bairro", nullable = false)
	private String bairro;
	
	@Column(name = "Cidade", nullable = false)
	private String cidade;
	
	@Column(name = "UF", nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@Column(name = "CEP", nullable = false, length = 9)
	private String cep;
	

	@Column(name = "Número", nullable = false, length = 5)
	private String numero;
	
	private String complemento;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
	
}
