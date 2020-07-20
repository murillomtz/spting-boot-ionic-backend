package com.mtz.ped.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mtz.ped.domain.Categoria;
import com.mtz.ped.dto.CategoriaDTO;
import com.mtz.ped.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired // Para instaciar altomaticamente
	private CategoriaService service;

	/* METODO PARA EFETUAR A OPERALÇAO DE GET, PASSANDO ID E RECEBER CATEGARIA */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// @PathVariable significa q o id passado pelo requeste mappin vai ser u sado no
	// metodo, como se fosse um "this."
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {

		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	/* METODO PARA RECEBER UMA CATEGORIA E INSETIR NO DB */
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ADMIN')") // Apenas adm pode inserir
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto) {

		Categoria obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto, @PathVariable Integer id) {
		Categoria obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {

		List<Categoria> list = service.findAll();

		// Percorre a list<categoria> fazendo um map e atribuindo o obj na
		// list<categoriaDTO> usando o collectos para transformar novamente em uma lista
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	/**/

}
