package com.mtz.ped.resources;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mtz.ped.domain.Pedido;
import com.mtz.ped.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired // Para instaciar altomaticamente
	private PedidoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// @PathVariable significa q o id passado pelo requeste mappin vai ser u sado no
	// metodo, como se fosse um "this."
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	/* METODO PARA RECEBER UMA CATEGORIA E INSETIR NO DB */
	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

}
