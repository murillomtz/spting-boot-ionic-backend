package com.mtz.cursomc.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.cursomc.domain.Pagamento;

@Repository // Extenção inplementa os comando como
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
