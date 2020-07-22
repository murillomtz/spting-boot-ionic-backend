package com.mtz.ped.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mtz.ped.domain.Estado;

@Repository // Extenção implementa os comando como SALVAR LOCALIZAR, FINDBYID
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	@Transactional(readOnly = true)
	public List<Estado> findAllByOrderByNome(); // Retornar todos os estado ordenado por nome
}
