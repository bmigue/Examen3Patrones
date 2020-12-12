package com.cenfotec.examen3graphql.query;

import com.cenfotec.examen3graphql.entities.Cliente;
import com.cenfotec.examen3graphql.service.ClienteServicio;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteQuery implements GraphQLQueryResolver {

    @Autowired
    private ClienteServicio clienteServicio;

    public List<Cliente> getClientes(int count){
        return this.clienteServicio.getAllClientes(count);
    }

    public Optional<Cliente> getCliente(int count){
        return this.clienteServicio.getCliente(count);
    }
}
