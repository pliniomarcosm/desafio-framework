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

import com.desafio.blogfrwk.bean.Post;
import com.desafio.blogfrwk.dao.PostDAO;

@Controller
public class PostController {
	@Autowired
	private PostDAO postDAO;
	
	@GetMapping("/")
	public String showPostList(Model model) {
	    model.addAttribute("posts", postDAO.findAll());
	    return "posts";
	}
	
	@GetMapping("/createPost")
	public String createPost(Post post) {
		return "entradaPost";
	}
	
	@PostMapping("/submitPost")
    public String submitPost(@Validated Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "entradaPost";
        }
        post.setHorario(new Date());
        postDAO.save(post);
        return "redirect:/";
    }
	
	@GetMapping("/editPost/{id}")
	public String editPost(@PathVariable("id") long id, Model model) {
	    Post post = postDAO.findById(id).get();
	    model.addAttribute("post", post);
	    return "entradaPost";
	}
	
	@GetMapping("/deletePost/{id}")
	public String deletePost(@PathVariable("id") long id, Model model) {
	    Post post = postDAO.findById(id).get();
	    postDAO.delete(post);
	    return "redirect:/";
	}
}
