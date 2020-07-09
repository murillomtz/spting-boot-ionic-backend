package com.mtz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtz.cursomc.DAO.CategoriaRepository;
import com.mtz.cursomc.domain.Categoria;
import com.mtz.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired // Automaticamente Instaciada pleo Spring
	private CategoriaRepository repo;

	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
