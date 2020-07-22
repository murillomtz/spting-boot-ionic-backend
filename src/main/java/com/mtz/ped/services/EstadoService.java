package com.mtz.ped.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtz.ped.DAO.EstadoRepository;
import com.mtz.ped.domain.Estado;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
}
