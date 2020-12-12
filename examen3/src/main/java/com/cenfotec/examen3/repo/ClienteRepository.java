package com.cenfotec.examen3.repo;

import com.cenfotec.examen3.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
