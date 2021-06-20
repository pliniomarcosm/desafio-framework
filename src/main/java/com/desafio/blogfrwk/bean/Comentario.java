package com.desafio.blogfrwk.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comentario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String conteudo;
	private Date horario;
	
	@ManyToOne
	@JoinColumn(name = "post")
	@JsonBackReference
	private Post post;
	
	@Transient
	private String horarioFormatado;
	
	public Comentario() {}
	
	public Comentario(Long id, String conteudo, Date horario, Post post) {
		this.id = id;
		this.conteudo = conteudo;
		this.horario = horario;
		this.post = post;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	public String getHorarioFormatado() {
		DateFormat formato = new SimpleDateFormat(("dd/MM/yyyy (HH:mm)"));
		return formato.format(this.horario);
	}
}
