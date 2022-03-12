package com.generation.learnpoint.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo é obrigatório!")
	@Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
	private String nomeu;
	
	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O atributo é obrigatório!")
	@Email( message = "O login deve ser um E-mail.")
	private String usuario;
	
	@NotBlank(message = "O atributo é obrigatório!")
	@Size(min = 8, message = "A senha deve conter minimo de 8 caracteres")
	private String senha;
	
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeu() {
		return nomeu;
	}

	public void setNomeu(String nomeu) {
		this.nomeu = nomeu;
	}

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setToken(String gerarBasicToken) {
		// TODO Auto-generated method stub
		
	}
}
