package com.mtz.ped.DAO;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.ped.domain.Cliente;

@Repository // Extenção inplementa os comando como
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	// Fazer uma busca por e-mail

	@Transactional(readOnly = true)
	Cliente findByEmail(String email);// O spring entende e completa o metodo que retorno um cliente e recebe um email
}
