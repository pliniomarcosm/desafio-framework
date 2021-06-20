package com.desafio.blogfrwk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {
	
	@GetMapping("indexAlbuns")
	public String albuns(){
		return "albuns";
	}
	
	@GetMapping("albumEntrada")
	public String novoAlbum(){
		return "albumEntrada";
	}
	
	@GetMapping("detalheAlbum")
	public String detalheAlbum(){
		return "detalheAlbum";
	}
}
