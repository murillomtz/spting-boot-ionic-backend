package com.mtz.cursomc.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.cursomc.domain.Cliente;

@Repository // Extenção inplementa os comando como
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
