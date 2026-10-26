package com.automacao.backend.domain.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudantes")
public class EstudanteEntity extends UsuarioEntity {

	@Column(nullable = false, unique = true, length = 20)
	private String matricula;

	@Column(length = 100)
	private String curso;

	public EstudanteEntity() {
	}

	public EstudanteEntity(String nome, String email, String cpf, String matricula, String curso) {
		super(nome, email, cpf);
		this.matricula = matricula;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
