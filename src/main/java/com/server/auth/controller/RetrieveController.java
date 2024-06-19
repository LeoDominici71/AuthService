package com.server.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.auth.entities.AutenticacaoService;
import com.server.auth.entities.UserDTO;

@RestController
@RequestMapping("/retrieve")
public class RetrieveController {

	@Autowired
	private AutenticacaoService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.getUserById(id));
	}

	
}
