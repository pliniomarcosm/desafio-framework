package com.desafio.blogfrwk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	@GetMapping("postEntrada")
	public String novoPost(){
		return "postEntrada";
	}
	
	@GetMapping("detalhePost")
	public String detalhePost(){
		return "detalhePost";
	}
}
