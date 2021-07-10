package com.flair.gcf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoggedDTO {

	private String userName;
	private String token;
	
}
