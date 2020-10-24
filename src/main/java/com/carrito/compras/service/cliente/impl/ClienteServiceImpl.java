package com.carrito.compras.service.cliente.impl;

import com.carrito.compras.entity.Cliente;
import com.carrito.compras.repository.ClienteRepository;
import com.carrito.compras.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {


    private ClienteRepository clienteRepository;
    
    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteid(Long id) {
        return clienteRepository.findById(id).orElse(new Cliente());
    }


}
