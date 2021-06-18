package com.desafio.blogfrwk.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.desafio.blogfrwk.bean.Comentario;
import com.desafio.blogfrwk.bean.Post;
import com.desafio.blogfrwk.bean.dto.PostDTO;
import com.desafio.blogfrwk.dao.ComentarioDAO;
import com.desafio.blogfrwk.dao.PostDAO;

@Controller
public class ComentarioController {
	
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private ComentarioDAO comentarioDAO;
	
	@GetMapping("/entradaComentario/{postId}")
	public String entradaComentario(@PathVariable("postId") long postId, Model model) {
	    Post post = postDAO.findById(postId).get();
	    PostDTO postDTO = new PostDTO();
	    postDTO.setPost(post);
	    model.addAttribute("postDTO", postDTO);
	    return "entradaComentario";
	}
	
	
	  @PostMapping("/submitComentarioDTO")
	  public String submitComentario(@Validated PostDTO postDTO, BindingResult result, Model model){
		  Post post = postDAO.findById(postDTO.getPost().getId()).get();
		  postDTO.setPost(post);
		  Comentario c;
		  
		  //criação ou edição de comentario
		  if (postDTO.getComentario().getId() == null) c = new Comentario();
		  else {
			  c = comentarioDAO.findById(postDTO.getComentario().getId()).get();
			  postDTO.getComentario().setId(null);
		  }
		  
		  c.setPost(post);
		  c.setConteudo(postDTO.getComentario().getConteudo());
		  c.setHorario(new Date());
		  comentarioDAO.save(c);
		  postDTO.getComentario().setConteudo(null);
		  model.addAttribute("postDTO", postDTO);
		  return "entradaComentario";
	  }
	 
	  @GetMapping("/editComentario/{comentarioId}")
	  public String editComentario(@PathVariable("comentarioId") long comentarioId, Model model) {
		  Comentario comentario = comentarioDAO.findById(comentarioId).get();
		  
		  PostDTO postDTO = new PostDTO();
		  postDTO.setComentario(comentario);
		  postDTO.setPost(comentario.getPost());
		  
		  model.addAttribute("postDTO", postDTO);
		  
		  return "entradaComentario";
	  }
	  
	  @GetMapping("/deleteComentario/{id}")
		public String deleteComentario(@PathVariable("id") long id, Model model) {
		    Comentario c = comentarioDAO.findById(id).get();
		    PostDTO postDTO = new PostDTO();
			postDTO.setPost(c.getPost());
		    comentarioDAO.delete(c);
			model.addAttribute("postDTO", postDTO);
		    return "entradaComentario";
	  }
}
