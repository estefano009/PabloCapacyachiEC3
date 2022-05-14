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

@Component
public class JWTTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil util;
	
	@Autowired
	private JWTUserDetailService jwTUserDetailService;

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
String tokenHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwToken = null;
		
		if(tokenHeader !=null && tokenHeader.startsWith("Bearer ")) {
			jwToken = tokenHeader.substring(7);
			try {
				username = util.getUsernameFromToken(jwToken);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un Error");
			}
		}else {
			logger.warn("JWT no esta iniciando con Bearer");
		}
		if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetail = this.jwTUserDetailService.loadUserByUsername(username);
			if(util.validateToken(jwToken, userDetail)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(jwToken,null ,userDetail.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request) );
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	} 
		
	}
	
	


