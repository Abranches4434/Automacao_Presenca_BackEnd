package com.automacao.backend.domain.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "professores")
public class ProfessorEntity extends UsuarioEntity {

	@Column(nullable = false, unique = true, length = 20)
	private String registro;

	@Column(length = 100)
	private String departamento;

	public ProfessorEntity() {
	}

	public ProfessorEntity(String nome, String email, String registro, String departamento) {
		super(nome, email);
		this.registro = registro;
		this.departamento = departamento;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
