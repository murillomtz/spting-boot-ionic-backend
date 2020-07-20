package com.mtz.ped.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.mtz.ped.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			//Retorna o usuario ques estiver logado no sistema
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
