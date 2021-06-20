package com.desafio.blogfrwk.controller.rest;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.blogfrwk.bean.Album;
import com.desafio.blogfrwk.bean.Foto;
import com.desafio.blogfrwk.dao.AlbumDAO;
import com.desafio.blogfrwk.dao.FotoDAO;

@RestController
public class FotoRestController {
	@Autowired
	private AlbumDAO albumDAO;
	@Autowired
	private FotoDAO fotoDAO;
	
	@RequestMapping(value = "/submitFoto", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                         MediaType.APPLICATION_XML_VALUE })
	public void submitFoto(@RequestBody Album a) {
		Foto f = new Foto();
		f.setDescricao(a.getFotoDTO().getFotoDescricao());
		a = albumDAO.findById(a.getId()).get();
		f.setAlbum(a);
		f.setHorario(new Date());
		
		fotoDAO.save(f);
	}
}
