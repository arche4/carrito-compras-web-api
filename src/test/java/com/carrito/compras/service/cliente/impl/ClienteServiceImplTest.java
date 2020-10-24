package com.carrito.compras.service.cliente.impl;


import com.carrito.compras.entity.Cliente;
import com.carrito.compras.repository.ClienteRepository;
import com.carrito.compras.service.cliente.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class ClienteServiceImplTest {

    private ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);

    private ClienteService clienteService;

    @Test
    void crearCliente() {
        //Arrange
        Cliente clienteEsperado = new Cliente();
        clienteEsperado.setIdCliente(30L);
        clienteEsperado.setNombre("Manuela");
        clienteEsperado.setApellido("Jimenez");
        clienteEsperado.setDni("1035438786");
        clienteEsperado.setEmail("lymapre@gmail.com");
        clienteEsperado.setTelefono("3002110309");
        clienteService = new ClienteServiceImpl(clienteRepository);

        //Actions
        given(clienteRepository.save(clienteEsperado)).willReturn(clienteEsperado);
        Cliente clienteResultado = clienteService.crearCliente(clienteEsperado);

        //Assert
        assertNotNull(clienteResultado);

    }
}