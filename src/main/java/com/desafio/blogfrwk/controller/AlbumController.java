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

import com.desafio.blogfrwk.bean.Album;
import com.desafio.blogfrwk.dao.AlbumDAO;

@Controller
public class AlbumController {
	
	@Autowired
	private AlbumDAO albumDAO;
	
	@GetMapping("/albums")
	public String showAlbumsList(Model model) {
	    model.addAttribute("albums", albumDAO.findAll());
	    return "albums";
	}
	
	@GetMapping("/createAlbum")
	public String createAlbum(Album album) {
		return "entradaAlbum";
	}
	
	@PostMapping("/submitAlbum")
    public String submitAlbum(@Validated Album album, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "entradaAlbum";
        }
        album.setHorario(new Date()); 
        albumDAO.save(album);
        return "redirect:/albums";
    }
	
	@GetMapping("/editAlbum/{id}")
	public String editAlbum(@PathVariable("id") long id, Model model) {
	    Album album = albumDAO.findById(id).get();
	    model.addAttribute("album", album);
	    return "entradaAlbum";
	}
	
	@GetMapping("/deleteAlbum/{id}")
	public String deleteAlbum(@PathVariable("id") long id, Model model) {
	    Album album = albumDAO.findById(id).get();
	    albumDAO.delete(album);
	    return "redirect:/albums";
	}
}
