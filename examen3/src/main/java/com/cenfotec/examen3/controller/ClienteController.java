package com.cenfotec.examen3.controller;

import java.util.List;

import com.cenfotec.examen3.domain.Cliente;
import com.cenfotec.examen3.domain.Orden;
import com.cenfotec.examen3.repo.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/clientes" })
public class ClienteController {

    private ClienteRepository repository;

    ClienteController(ClienteRepository clienteRepository){
        this.repository=clienteRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Cliente> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente contact) {
        return repository.save(contact);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") long id, @RequestBody Cliente contact) {
        return repository.findById(id).map(record -> {
            record.setNombre(contact.getNombre());
            record.setApellidos(contact.getApellidos());
            record.setDireccion(contact.getDireccion());
            record.setDircobro(contact.getDircobro());
            record.setNumerotarjeta(contact.getNumerotarjeta());
            record.setAnio(contact.getAnio());
            record.setMes(contact.getMes());
            Cliente updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = { "apellido/{apellidos}" })
    public List findApellidos(@PathVariable String apellidos) {
        List<Cliente>lista=repository.findAll();
        for(int i=0;i<lista.size();i++) {
            if(lista.get(i).getApellidos().contains(apellidos)) {

            }else {
                lista.remove(lista.get(i));
            }
        }
        return lista;
    }

    @GetMapping(path = { "dirco/{id}" })
    public List findDirCo(@PathVariable String id) {
        List<Cliente>lista=repository.findAll();
        for(int i=0;i<lista.size();i++) {
            if(lista.get(i).getDircobro().contains(id)) {

            }else {
                lista.remove(lista.get(i));
            }
        }
        return lista;
    }

}
