package com.mtz.ped.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.ped.domain.Produto;

@Repository  //Extenção implementa os comando como SALVAR LOCALIZAR, FINDBYID
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
