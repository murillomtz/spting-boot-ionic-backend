package com.mtz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtz.cursomc.DAO.ClienteRepository;
import com.mtz.cursomc.domain.Cliente;
import com.mtz.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired // Automaticamente Instaciada pleo Spring
	private ClienteRepository repo;

	public Optional<Cliente> buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())));
	}

}
