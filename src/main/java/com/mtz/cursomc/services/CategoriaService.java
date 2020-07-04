package com.mtz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtz.cursomc.DAO.CategoriaRepository;
import com.mtz.cursomc.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired // Automaticamente Instaciada pleo Spring
	private CategoriaRepository repo;

	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj;
	}

//	public Categoria find(Integer id) {
//		Optional<Categoria> obj = repo.findById(id);
//		return obj.orElseThrow(() -> new ObjectNotFoundException(
//				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
//	}
}
