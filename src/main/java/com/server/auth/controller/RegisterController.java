package com.server.auth.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.server.auth.entities.AutenticacaoService;
import com.server.auth.entities.UserDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private AutenticacaoService service;

	@PostMapping
	public ResponseEntity<UserDTO> registro(@RequestBody @Valid UserDTO user) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(service.saveUser(user));
	}

}
