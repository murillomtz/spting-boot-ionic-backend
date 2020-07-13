package com.mtz.ped.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtz.ped.domain.Categoria;

@Repository  //Extenção inplementa os comando como
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
