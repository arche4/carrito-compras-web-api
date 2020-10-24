package com.carrito.compras.controller;

import com.carrito.compras.dto.request.ClienteRquestDTO;
import com.carrito.compras.entity.Cliente;
import com.carrito.compras.service.cliente.ClienteService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import org.apache.log4j.Logger;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    private final Logger logger = Logger.getLogger(this.getClass());

    private ClienteService clienteService;

    private ModelMapper modelMapper;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping()
    public ResponseEntity<?> crearCliente(@Valid ClienteRquestDTO clienteRquestDTO) {

        this.modelMapper = new ModelMapper();
        Cliente cliente = this.modelMapper.map(clienteRquestDTO, Cliente.class);
        Cliente crearCliente = clienteService.crearCliente(cliente);
        if (crearCliente == null) {
            logger.error(new Date() + " Error creando cliente");
            return ResponseEntity.notFound().build();
        } else {
            logger.debug("Prueba de logs: ");
            logger.info(new Date() + " Exitoso, se creo un nuevo cliente");
            return ResponseEntity.status(HttpStatus.CREATED).body(crearCliente);
        }
    }
}
