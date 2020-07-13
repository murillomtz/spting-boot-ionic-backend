package com.mtz.ped.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.ped.domain.Pedido;

@Repository // Extenção inplementa os comando como
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
