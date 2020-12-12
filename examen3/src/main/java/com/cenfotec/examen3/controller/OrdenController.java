package com.cenfotec.examen3.controller;
import com.cenfotec.examen3.domain.Orden;
import com.cenfotec.examen3.repo.OrdenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping({ "/ordenes" })
public class OrdenController {

    private OrdenRepository repository;

    OrdenController(OrdenRepository ordenRepository) {
        this.repository = ordenRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Orden> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = { "/tipo/{tipo}" })
    public List<Orden> listarAutor(@PathVariable String tipo) {
        return repository.findByTipo(tipo);
    }

//    @GetMapping(path = { "/tipo/{tipo}" })
//    public ResponseEntity<Orden> findByTipo(@PathVariable String tipo) {
//        return repository.findByTipo(tipo).map(record -> ResponseEntity.ok().body(record))
//                .orElse(ResponseEntity.notFound().build());
//    }



    @PostMapping
    public Orden create(@RequestBody Orden orden) {
        return repository.save(orden);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Orden> update(@PathVariable("id") long id, @RequestBody Orden orden) {
        return repository.findById(id).map(record -> {
            record.setTipo(orden.getTipo());
            record.setCantidad(orden.getCantidad());
            Orden actualizada = repository.save(record);
            return ResponseEntity.ok().body(actualizada);
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }



}
