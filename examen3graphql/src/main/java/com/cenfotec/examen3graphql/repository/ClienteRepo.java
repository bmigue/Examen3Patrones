package com.cenfotec.examen3graphql.repository;

import com.cenfotec.examen3graphql.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
}
