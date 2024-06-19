package com.server.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.auth.entities.DadosAutenticacao;
import com.server.auth.entities.Usuario;
import com.server.auth.entities.UsuarioRepository;
import com.server.auth.infra.DadosTokenJWT;
import com.server.auth.infra.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenService tokenService;
	

	@PostMapping
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {

		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getLogin(), dados.getSenha());
		var authentication = manager.authenticate(authenticationToken);

		var tokenJWT = tokenService.generateToken((Usuario) authentication.getPrincipal());

		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}

}
