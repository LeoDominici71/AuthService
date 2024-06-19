package com.server.auth.entities;

import java.util.Collection;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String login;
    private String senha;
    private String role;
	private String nome;
	@CPF
	private String cpf;
	private Integer idade;
	private String cep;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;
	
	public Usuario(UserDTO user) {
		setLogin(user.getEmail());
		setNome(user.getNome());
		setCpf(user.getCpf());
		setIdade(user.getIdade());
		setCep(user.getCep());
		setCidade(user.getCidade());
		setBairro(user.getBairro());
		setRua(user.getRua());
		setRole(user.getRoles());
		setNumero(user.getNumero());
		setComplemento(user.getComplemento());
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	if(this.role.equals("ADMIN")) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
