package com.sorrisoperfeito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sorrisoperfeito.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

}
