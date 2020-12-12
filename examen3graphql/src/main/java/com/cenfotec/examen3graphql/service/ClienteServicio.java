package com.cenfotec.examen3graphql.service;

import com.cenfotec.examen3graphql.entities.Cliente;
import com.cenfotec.examen3graphql.repository.ClienteRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServicio {

    @Autowired
    ClienteRepo ClienteRepo;

    public List<Cliente> getAllClientes(int count) {
        return this.ClienteRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Cliente> getCliente(int id) {
        return this.ClienteRepo.findById(id);
    }

    public Cliente createCliente(String nombre, String apellidos, String direccion, String direccionCobro, int numeroTarjeta, int mes, int anio) {

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellidos(apellidos);
        cliente.setDireccion(direccion);
        cliente.setDircobro(direccionCobro);
        cliente.setNumerotarjeta(numeroTarjeta);
        cliente.setAnio(anio);
        cliente.setMes(mes);
        return this.ClienteRepo.save(cliente);
    }

    public Boolean deleteCliente(int id) {
        ClienteRepo.deleteById(id);
        return true;
    }

    public Cliente updateCliente(String id, String nombre, String apellidos, String direccion, String direccionCobro, int numeroTarjeta, int mes, int anio) throws NotFoundException {
        Optional<Cliente> opCliente = ClienteRepo.findById(Integer.parseInt(id));

        if (opCliente.isPresent()) {
            Cliente cx = opCliente.get();

            if (nombre != null)
                cx.setNombre(nombre);
            if (apellidos != null)
                cx.setApellidos(apellidos);
            if (direccion != null)
                cx.setDireccion(direccion);
            if (direccionCobro != null)
                cx.setDircobro(direccionCobro);
            if (numeroTarjeta != 0)
                cx.setNumerotarjeta(numeroTarjeta);
            if (anio != 0)
                cx.setAnio(anio);
            if (mes != 0)
                cx.setMes(mes);
            ClienteRepo.save(cx);
            return cx;
        }
        throw new NotFoundException("Cliente no encontrado");
    }
}
