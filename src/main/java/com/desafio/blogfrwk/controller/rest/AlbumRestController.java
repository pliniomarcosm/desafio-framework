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

import com.desafio.blogfrwk.bean.Album;
import com.desafio.blogfrwk.dao.AlbumDAO;

@RestController
public class AlbumRestController {
	
	@Autowired
	private AlbumDAO albumDAO;
	
	@GetMapping("/albuns")
	public List<Album> getAlbuns() {
		//carrega os mais novos primeiro
		return albumDAO.findAll(Sort.by(Sort.Direction.DESC, "horario"));
	}
	
	@RequestMapping(value = "/submitAlbum", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                         MediaType.APPLICATION_XML_VALUE })
	public void submitAlbum(@RequestBody Album a) {
		a.setHorario(new Date());
		albumDAO.save(a);
	}
	
	@GetMapping("/getAlbumById")
	public Album getAlbumById(@RequestParam("idAlbum") Long idAlbum) {
		return albumDAO.findById(idAlbum).get();
	}
	
	@GetMapping("/deleteAlbum")
	public void deleteAlbum(@RequestParam("idAlbum") Long idAlbum) {
		albumDAO.delete(albumDAO.findById(idAlbum).get());
	}
	
	
}
