package com.cenfotec.examen3graphql.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode
@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "dircobro", nullable = false)
    private String dircobro;

    @Column(name = "numerotarjeta", nullable = false)
    private long numerotarjeta;

    @Column(name = "mes", nullable = false)
    private long mes;

    @Column(name = "anio", nullable = false)
    private long anio;

}
