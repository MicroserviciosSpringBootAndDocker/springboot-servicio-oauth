package com.rodriguez.springboot.app.oauth.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.rodriguez.springboot.app.commons.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario finByUsername(String username);
	
	//usuario feign
	public Usuario update( Usuario usuarios,  Long id);

}
