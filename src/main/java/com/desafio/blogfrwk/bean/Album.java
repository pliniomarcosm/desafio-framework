package com.desafio.blogfrwk.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
 
@Entity
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	private Date horario;
	
	@OneToMany(mappedBy = "album")
	private List<Foto> fotos;
	
	@Transient
	private String horarioFormatado;
	@Transient
	private Integer numeroFotos;
	
	public Album() {}
	
	public Album(Long id, List<Foto> fotos, String nome, String descricao) {
		this.id = id;
		this.fotos = fotos;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	public Integer getNumeroComentarios() {
		return this.getFotos().size();
	}
	
}
