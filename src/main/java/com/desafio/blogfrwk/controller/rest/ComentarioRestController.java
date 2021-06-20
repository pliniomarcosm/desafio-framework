package com.desafio.blogfrwk.controller.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.blogfrwk.bean.Comentario;
import com.desafio.blogfrwk.bean.Post;
import com.desafio.blogfrwk.dao.ComentarioDAO;
import com.desafio.blogfrwk.dao.PostDAO;

@RestController
public class ComentarioRestController {
	
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private ComentarioDAO comentarioDAO;
	
	
	@RequestMapping(value = "/submitComentario", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                         MediaType.APPLICATION_XML_VALUE })
	public void submitComentario(@RequestBody Post p) {
		Comentario c = new Comentario();
		c.setConteudo(p.getComentarioDTO().getComentarioConteudo());
		p = postDAO.findById(p.getId()).get();
		c.setPost(p);
		c.setHorario(new Date());
		
		comentarioDAO.save(c);
	}
}
