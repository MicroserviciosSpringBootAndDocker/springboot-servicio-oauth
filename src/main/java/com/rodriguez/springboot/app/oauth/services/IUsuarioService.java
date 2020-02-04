package com.rodriguez.springboot.app.oauth.services;


import com.rodriguez.springboot.app.commons.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario finByUsername(String username);
	
	//usuario feign
	public Usuario update( Usuario usuarios,  Long id);

}
