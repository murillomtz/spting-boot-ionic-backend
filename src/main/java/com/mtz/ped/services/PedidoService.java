package com.mtz.ped.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtz.ped.DAO.PedidoRepository;
import com.mtz.ped.domain.Cliente;
import com.mtz.ped.domain.Pedido;
import com.mtz.ped.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired // Automaticamente Instaciada pleo Spring
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
