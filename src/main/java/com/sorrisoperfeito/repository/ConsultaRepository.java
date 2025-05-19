package com.sorrisoperfeito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sorrisoperfeito.model.Consulta;
import com.sorrisoperfeito.model.Paciente;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
	
	public List<Consulta> findByPaciente(Paciente paciente);

}
