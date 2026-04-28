package com.calcados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CalcadoRepository extends JpaRepository<Calcados, Long> {

    List<Calcados> findAllByAtivoTrue();

    
    
}
