package com.example.exame.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.exame.model.UsuarioCliente;
import com.example.exame.repository.UsuarioClienteRepository;


@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioClienteRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioCliente usuario = repositorio.findByUsuario(username);
		UserBuilder user = null;
		if(usuario == null)
			throw new UsernameNotFoundException("Usuario no existe");
		else {
			user = User.withUsername(username);
			user.password(new BCryptPasswordEncoder().encode(usuario.getPassword()));
			user.roles(usuario.getRol());
		}
		return user.build();
	}

}
