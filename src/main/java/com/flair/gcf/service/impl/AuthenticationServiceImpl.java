package com.flair.gcf.service.impl;

import org.springframework.stereotype.Service;

import com.flair.gcf.service.AuthenticationService;

import model.Usuario;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public Usuario authenticate(String user, String pass) {
		Usuario asd = new Usuario(null, "Lucho", "Mendez", "Luchito@mendez", "11456789", pass, 3, null);
		return asd;
	}
	

}
