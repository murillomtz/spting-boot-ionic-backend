package com.mtz.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtz.cursomc.domain.Cliente;
import com.mtz.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired // Para instaciar altomaticamente
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// @PathVariable significa q o id passado pelo requeste mappin vai ser u sado no
	// metodo, como se fosse um "this."
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Optional<Cliente> obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
