package com.desafio.blogfrwk.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.desafio.blogfrwk.bean.dto.ComentarioDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String assunto;
	private String conteudo;
	private Date horario;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Comentario> comentarios;
	
	@Transient
	private String horarioFormatado;
	@Transient
	private Integer numeroComentarios;
	@Transient
	private ComentarioDTO comentarioDTO;
	
	public Post() {}
	
	public Post(Long id, String assunto, String conteudo, Date horario, List<Comentario> comentarios) {
		this.id = id;
		this.assunto = assunto;
		this.conteudo = conteudo;
		this.comentarios = comentarios;
		this.horario = horario;
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
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
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
		if (this.getComentarios().size() == 0) return 0;
		else return this.getComentarios().size();
	}
	
	public ComentarioDTO getComentarioDTO() {
		return comentarioDTO;
	}
	public void setComentarioDTO(ComentarioDTO comentarioDTO) {
		this.comentarioDTO = comentarioDTO;
	}
}
