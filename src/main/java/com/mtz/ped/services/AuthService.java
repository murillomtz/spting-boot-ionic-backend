package com.mtz.ped.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mtz.ped.DAO.ClienteRepository;
import com.mtz.ped.domain.Cliente;
import com.mtz.ped.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BCryptPasswordEncoder pe; //Criptografia de senha

	@Autowired
	private EmailService emailService;

	private Random rand = new Random();

	public void sendNewPassword(String email) {

		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}

		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));

		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	
	//Gerando uma senha aleatoria com 10 catacteres
	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	
	private char randomChar() {// unicode-table.com
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);//Entre 0 e 9
		} else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);//Sao 26 letras possiveis p cod da A em caxa ALTA é 65
		} else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}