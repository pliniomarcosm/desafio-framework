package com.desafio.blogfrwk.controller.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.blogfrwk.bean.Post;
import com.desafio.blogfrwk.dao.PostDAO;

@RestController
public class PostRestController {
	
	@Autowired
	private PostDAO postDAO;
	
	@GetMapping("/posts")
	public List<Post> getPosts() {
		//carrega os mais novos primeiro
		return postDAO.findAll(Sort.by(Sort.Direction.DESC, "horario"));
	}
	
	@RequestMapping(value = "/submitPost", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                         MediaType.APPLICATION_XML_VALUE })
	public void submitPost(@RequestBody Post p) {
		p.setHorario(new Date());
		postDAO.save(p);
	}
	
	@GetMapping("/getPostById")
	public Post getPostById(@RequestParam("idPost") Long idPost) {
		return postDAO.findById(idPost).get();
	}
	
	@GetMapping("/deletePost")
	public void deletePost(@RequestParam("idPost") Long idPost) {
		postDAO.delete(postDAO.findById(idPost).get());
	}
	
	/*
	 * @GetMapping("/getPostByID") public ComentarioDTO
	 * getComentarioDTO(@RequestParam("idPost") Long idPost) { ComentarioDTO
	 * comentarioDTO = new ComentarioDTO(); Post p = postDAO.findById(idPost).get();
	 * comentarioDTO.setPost(p); return comentarioDTO; }
	 */
	
	
	
}
