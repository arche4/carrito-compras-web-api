package com.carrito.compras.service.venta;


import com.carrito.compras.entity.Cliente;
import com.carrito.compras.entity.Producto;
import com.carrito.compras.entity.Venta;
import com.carrito.compras.repository.VentaRepository;
import com.carrito.compras.service.producto.impl.ProductoServiceImpl;
import com.carrito.compras.service.venta.impl.VentaServiceImpl;
import com.carrito.compras.util.Response;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;


public class VentaServiceImplTest {

    private VentaRepository ventaRepository = Mockito.mock(VentaRepository.class);

    private VentaService ventaService;

    @Test
    public void getVentaError() {
        //Arrange
        Cliente cliente = new Cliente();
        cliente.setIdCliente(30L);
        cliente.setNombre("Manuela");
        cliente.setApellido("Jimenez");
        cliente.setDni("1035438786");
        cliente.setEmail("lymapre@gmail.com");
        cliente.setTelefono("3002110309");
        Venta ventaEnvia = new Venta(1L, cliente, null, null);
        Response ventaEsperada = new
                Response(500, "Se presento un error creando la venta: null", null);
        ventaService = new VentaServiceImpl(ventaRepository);


        //Actions
        given(ventaRepository.save(ventaEnvia)).willReturn(new Venta(1L, cliente, null, null));
        Response ventaResultado = ventaService.crearVenta(new Producto(1L, null, null, null), ventaEnvia);

         //Assert
        assertEquals(ventaEsperada, ventaResultado);
    }

}