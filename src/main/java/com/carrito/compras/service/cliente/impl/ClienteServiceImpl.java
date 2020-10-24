package com.carrito.compras.service.cliente.impl;

import com.carrito.compras.entity.Cliente;
import com.carrito.compras.repository.ClienteRepository;
import com.carrito.compras.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
