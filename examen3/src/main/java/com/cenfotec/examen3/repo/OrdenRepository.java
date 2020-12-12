package com.cenfotec.examen3.repo;

import com.cenfotec.examen3.domain.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    public List<Orden> findByTipo(String word);
}
