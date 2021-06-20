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
public class Foto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private Date horario;
	
	@Transient
	private String horarioFormatado;
	
	@ManyToOne
	@JoinColumn(name = "album")
	@JsonBackReference
	private Album album;
	
	public Foto() {}
	
	public Foto(Long id, String descricao, Album album) {
		this.id = id;
		this.descricao = descricao;
		this.album = album;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	public String getHorarioFormatado() {
		DateFormat formato = new SimpleDateFormat(("dd/MM/yyyy (HH:mm)"));
		return formato.format(this.horario);
	}
}
