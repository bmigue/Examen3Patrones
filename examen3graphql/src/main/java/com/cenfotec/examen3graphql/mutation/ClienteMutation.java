package com.cenfotec.examen3graphql.mutation;

import com.cenfotec.examen3graphql.entities.Cliente;
import com.cenfotec.examen3graphql.service.ClienteServicio;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ClienteMutation implements GraphQLMutationResolver {
    @Autowired
    private ClienteServicio clienteServicio;

    public Cliente crearCliente(String nombre, String apellidos, String direccion, String dirCobro, int numerotarjeta, int mes, int anio){
        return this.clienteServicio.createCliente(nombre, apellidos, direccion, dirCobro, numerotarjeta, mes, anio);
    }

    public boolean BorrarCliente(int id) {
        clienteServicio.deleteCliente(id);
        return true;
    }

    public Cliente actualizarCliente(String id, String nombre, String apellidos, String direccion, String dirCobro, int numerotarjeta, int mes, int anio) throws NotFoundException {
        return this.clienteServicio.updateCliente(id,nombre, apellidos, direccion, dirCobro, numerotarjeta, mes, anio);
    }
}
