package com.sorrisoperfeito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sorrisoperfeito.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
