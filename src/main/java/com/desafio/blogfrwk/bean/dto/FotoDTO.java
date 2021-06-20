package com.desafio.blogfrwk.bean.dto;

import com.desafio.blogfrwk.bean.Album;

//Transiente
public class FotoDTO {
	
	private String fotoDescricao;
	private Album album;
	
	public String getFotoDescricao() {
		return fotoDescricao;
	}
	public void setFotoDescricao(String fotoDescricao) {
		this.fotoDescricao = fotoDescricao;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}
