package com.mtz.ped.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtz.ped.DAO.ClienteRepository;
import com.mtz.ped.DAO.EnderecoRepository;
import com.mtz.ped.domain.Cidade;
import com.mtz.ped.domain.Cliente;
import com.mtz.ped.domain.Endereco;
import com.mtz.ped.domain.enums.Perfil;
import com.mtz.ped.domain.enums.TipoCliente;
import com.mtz.ped.dto.ClienteDTO;
import com.mtz.ped.dto.ClienteNewDTO;
import com.mtz.ped.security.UserSS;
import com.mtz.ped.services.exceptions.AuthorizationException;
import com.mtz.ped.services.exceptions.DataIntegrityException;
import com.mtz.ped.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired // Automaticamente Instaciada pleo Spring
	private ClienteRepository repo;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Cliente find(Integer id) {

		UserSS user = UserService.authenticated();

		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Cliente> obj = repo.findById(id);
		return obj
				.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);

		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEndereco());
		return obj;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);

		try {
			repo.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir porque há pedidos relacionadas");
		}
	}

	public List<Cliente> findAll() {

		return repo.findAll();
	}

	// Emcapsula informaçoes e operações sobre a operação
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null);
	}

	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				TipoCliente.toEnum(objDto.getTipo()), bCryptPasswordEncoder.encode(objDto.getSenha()));
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLongradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEndereco().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}

	private void updateData(Cliente newObj, Cliente obj) {

		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
