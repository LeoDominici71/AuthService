package com.server.auth.entities;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
	
	
    private Long id;
	@NotNull
	private String nome;
	@CPF
	private String cpf;
	private String email;
	@NotNull
	private String senha;
	private Integer idade;
	@NotNull
	private String cep;
	private String cidade;
	private String bairro;
	private String rua;
	@NotNull
	private String numero;
	private String complemento;
	private String roles;
	
	
	public UserDTO(Usuario user) {
		setId(user.getId());
		setEmail(user.getLogin());
		setSenha(user.getPassword());
		setNome(user.getNome());
		setCpf(user.getCpf());
		setIdade(user.getIdade());
		setCep(user.getCep());
		setCidade(user.getCidade());
		setBairro(user.getBairro());
		setRua(user.getRua());
		setRoles(user.getRole());
		setNumero(user.getNumero());
		setComplemento(user.getComplemento());
	}


}
