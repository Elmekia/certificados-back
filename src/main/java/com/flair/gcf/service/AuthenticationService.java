package com.flair.gcf.service;

import model.Usuario;

public interface AuthenticationService {

	public Usuario authenticate(String user, String pass);
}
