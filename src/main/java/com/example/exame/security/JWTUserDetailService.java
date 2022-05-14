package com.example.exame.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.exame.model.UsuarioCliente;
import com.example.exame.repository.UsuarioClienteRepository;



@Service
public class JWTUserDetailService  implements UserDetailsService{

	@Autowired
	private UsuarioClienteRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UsuarioCliente usuario = repository.findByUsuario(username);
		
		if(usuario != null) {
			
			List<GrantedAuthority> grande = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol());
			grande.add(authority);
			return new User(usuario.getUsuario(),new BCryptPasswordEncoder().encode(usuario.getPassword()) , grande);
			
		}else {
			throw new UsernameNotFoundException("El usuario no existe");
		}	
	}

}
