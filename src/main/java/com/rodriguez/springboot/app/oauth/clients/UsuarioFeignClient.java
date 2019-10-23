package com.rodriguez.springboot.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodriguez.springboot.app.commons.models.entity.Usuario;


@FeignClient(name="servicio-usuarios")
public interface UsuarioFeignClient {
	
	
	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
	
	//Para la validacion de login intentos
	@PutMapping("/usuarios/{id}")
	public Usuario update(@RequestBody Usuario usuarios, @PathVariable Long id);

	
}
