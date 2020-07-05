package com.mtz.cursomc.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.cursomc.domain.Cidade;

@Repository  //Extenção inplementa os comando como
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
