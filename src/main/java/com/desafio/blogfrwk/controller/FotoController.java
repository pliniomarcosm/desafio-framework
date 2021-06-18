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
import com.desafio.blogfrwk.bean.Foto;
import com.desafio.blogfrwk.bean.dto.AlbumDTO;
import com.desafio.blogfrwk.dao.AlbumDAO;
import com.desafio.blogfrwk.dao.FotoDAO;

@Controller
public class FotoController {
	@Autowired
	private AlbumDAO albumDAO;
	@Autowired
	private FotoDAO fotoDAO;
	
	@GetMapping("/entradaFoto/{albumId}")
	public String entradaComentario(@PathVariable("albumId") long albumId, Model model) {
	    Album album = albumDAO.findById(albumId).get();
	    AlbumDTO albumDTO = new AlbumDTO();
	    albumDTO.setAlbum(album);
	    model.addAttribute("albumDTO", albumDTO);
	    return "entradaFoto";
	}
	
	@PostMapping("/submitAlbumDTO")
	  public String submitFoto(@Validated AlbumDTO albumDTO, BindingResult result, Model model){
		  Album album = albumDAO.findById(albumDTO.getAlbum().getId()).get();
		  albumDTO.setAlbum(album);
		  Foto f;
		  
		  //criação ou edição de comentario
		  if (albumDTO.getFoto().getId() == null) f = new Foto();
		  else {
			  f = fotoDAO.findById(albumDTO.getFoto().getId()).get();
			  albumDTO.getFoto().setId(null);
		  }
		  
		  f.setAlbum(album);
		  f.setDescricao(albumDTO.getFoto().getDescricao());
		  f.setHorario(new Date());
		  fotoDAO.save(f);
		  albumDTO.getFoto().setDescricao(null);
		  model.addAttribute("albumDTO", albumDTO);
		  
		  return "entradaFoto";
	  }
	
	@GetMapping("/editFoto/{fotoId}")
	public String editFoto(@PathVariable("fotoId") long fotoId, Model model) {
		  Foto foto = fotoDAO.findById(fotoId).get();
		  AlbumDTO albumDTO = new AlbumDTO();
		  albumDTO.setFoto(foto);
		  albumDTO.setAlbum(foto.getAlbum());
		  model.addAttribute("albumDTO", albumDTO);
		  
		  return "entradaFoto";
	}
	
	@GetMapping("/deleteFoto/{id}")
	public String deleteFoto(@PathVariable("id") long id, Model model) {
	    Foto f = fotoDAO.findById(id).get();
	    AlbumDTO albumDTO = new AlbumDTO();
	    albumDTO.setAlbum(f.getAlbum());
	    fotoDAO.delete(f);
		model.addAttribute("albumDTO", albumDTO);
	    return "entradaFoto";
	}
}
