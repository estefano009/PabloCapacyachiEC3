package com.example.exame.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter{

	@Autowired
	private MyUserDetailService userDetailService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String requestToken = request.getHeader("Authorization");
		
		String username = null;
		String jwtToken = null;
		
		if(requestToken != null && requestToken.startsWith("Bearer ")) {
			
			jwtToken = requestToken.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Usuario ilegal");
			}catch (ExpiredJwtException e) {
				System.out.println("Token expirado");
			}
		}else {
			logger.warn("Error en el token que se envio");
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetail = this.userDetailService.loadUserByUsername(username);
			if(jwtTokenUtil.validateToken(jwtToken, userDetail)) {
				UsernamePasswordAuthenticationToken usernameAuthToken = new UsernamePasswordAuthenticationToken(userDetail, null,userDetail.getAuthorities());
				usernameAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernameAuthToken);
			}
		}

		filterChain.doFilter(request, response);
	}
}
