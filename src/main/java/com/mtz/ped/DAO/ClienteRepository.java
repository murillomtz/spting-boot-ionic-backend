package com.mtz.ped.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.ped.domain.Cliente;

@Repository // Extenção inplementa os comando como
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
