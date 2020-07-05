package com.mtz.cursomc.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.cursomc.domain.Categoria;

@Repository  //Extenção inplementa os comando como
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
