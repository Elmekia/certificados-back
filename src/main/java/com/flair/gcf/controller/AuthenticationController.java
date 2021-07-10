package com.flair.gcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flair.gcf.dto.LoginDTO;
import com.flair.gcf.dto.UserLoggedDTO;
import com.flair.gcf.response.ControllerResponse;
import com.flair.gcf.service.AuthenticationService;

import model.Usuario;
import utils.TokenUtils;

@RestController
@RequestMapping(value = "/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService service;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<ControllerResponse> login(@RequestBody LoginDTO request) throws Exception {
		Usuario usuario = service.authenticate(request.getUser(), request.getPassword());
		if (usuario == null) {
			return new ResponseEntity<ControllerResponse>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<ControllerResponse>(new ControllerResponse(new UserLoggedDTO(request.getUser(), TokenUtils.generateToken(usuario))), HttpStatus.OK);
	}
	
	@GetMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<ControllerResponse> loginV2(@RequestBody LoginDTO request) throws Exception {
		Usuario usuario = service.authenticate(request.getUser(), request.getPassword());
		if (usuario == null) {
			return new ResponseEntity<ControllerResponse>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<ControllerResponse>(new ControllerResponse(new UserLoggedDTO(request.getUser(), TokenUtils.generateToken(usuario))), HttpStatus.OK);
	}

}
