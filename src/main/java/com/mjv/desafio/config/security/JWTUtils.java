package com.mjv.desafio.config.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtils {
	public static String creteToken(String username, Date dataCriacao, Date dataExperiacao) {
		String role = "ROLE_USER";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
		
		String token = JWTConstants.PREFIX +  Jwts.builder().setSubject(username)
				.claim("authorities",grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(dataCriacao)
				.setExpiration(dataExperiacao)
				.signWith(SignatureAlgorithm.HS512, JWTConstants.KEY.getBytes()).compact();
		
		System.out.println(token);
		return token;
		
	}
	
}
