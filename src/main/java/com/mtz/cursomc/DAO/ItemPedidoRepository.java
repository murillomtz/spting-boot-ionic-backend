package com.mtz.cursomc.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.cursomc.domain.ItemPedido;

@Repository // Extenção inplementa os comando como
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
