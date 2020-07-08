package com.mtz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtz.cursomc.DAO.PedidoRepository;
import com.mtz.cursomc.domain.Cliente;
import com.mtz.cursomc.domain.Pedido;
import com.mtz.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired // Automaticamente Instaciada pleo Spring
	private PedidoRepository repo;

	public Optional<Pedido> buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())));
	}

}
