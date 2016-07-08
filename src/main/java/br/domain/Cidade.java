package br.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Cidade")
public class Cidade {

	@Id
	private Long codigo;

	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
