package com.mtz.ped.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.ped.domain.Estado;

@Repository // Extenção implementa os comando como SALVAR LOCALIZAR, FINDBYID
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
