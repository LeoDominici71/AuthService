package com.server.auth.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.auth.Factory.Factory;
import com.server.auth.entities.UserDTO;
import com.server.auth.entities.UsuarioRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private UsuarioRepository repository;
	
	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveRegistrarUmUsuario() throws Exception {
		// Arrange
		UserDTO request = Factory.createUserDTO();
		String jsonBody = objectMapper.writeValueAsString(request);

		// Act
		ResultActions response = mockMvc
				.perform(post("/register").content(jsonBody).contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isCreated());
	}
	
	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveBuscarUsuarioPorId() throws Exception {

		// Arrange
		repository.save(Factory.createUsuario());

		// Act
		ResultActions response = mockMvc.perform(
				get("/retrieve/{id}", 1L).accept(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isOk());

	}

}
