package model;

import java.util.Date;

import lombok.Data;

@Data
public class Token {

	private String token;
	private Date expiration;
	private Usuario usuario;
}
