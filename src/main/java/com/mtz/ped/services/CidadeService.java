package com.mtz.ped.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtz.ped.DAO.CidadeRepository;
import com.mtz.ped.domain.Cidade;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}
