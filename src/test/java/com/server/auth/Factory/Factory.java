package com.server.auth.Factory;

import com.server.auth.entities.UserDTO;
import com.server.auth.entities.Usuario;

public class Factory {
	
	public static UserDTO createUserDTO() {
		UserDTO dto = new UserDTO();
		dto.setId(1L);
		dto.setNome("John Doe");
		dto.setCpf("48374255854");
		dto.setEmail("john.doe@example.com");
		dto.setSenha("password123");
		dto.setIdade(30);
		dto.setCep("12345-678");
		dto.setCidade("São Paulo");
		dto.setBairro("Centro");
		dto.setRua("Rua Exemplo");
		dto.setNumero("123");
		dto.setComplemento("Apto 456");
		dto.setRoles("ROLE_USER");
		
		return dto;
	}
	
	public static Usuario createUsuario() {
		Usuario user = new Usuario();
		user.setNome("John Doe");
		user.setCpf("48374255854");
		user.setLogin("john.doe@example.com");
		user.setIdade(30);
		user.setCep("12345-678");
		user.setCidade("São Paulo");
		user.setBairro("Centro");
		user.setRua("Rua Exemplo");
		user.setNumero("123");
		user.setComplemento("Apto 456");
		user.setRole("ROLE_USER");
		user.setSenha("password123");
		
		return user;
	}

}
