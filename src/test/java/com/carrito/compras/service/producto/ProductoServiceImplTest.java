package com.carrito.compras.service.producto;

import com.carrito.compras.entity.Producto;
import com.carrito.compras.repository.ProductoRepository;
import com.carrito.compras.service.producto.impl.ProductoServiceImpl;
import com.carrito.compras.util.Response;
import org.mockito.Mockito;
import org.junit.Test;
import com.carrito.compras.exceptions.NoDataFoundException;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.junit.Assert.assertEquals;


import java.util.Optional;


public class ProductoServiceImplTest {


    private ProductoRepository productRepository = Mockito.mock(ProductoRepository.class);

    private ProductoService productoService;


    @Test()
    public void getProductThatNoExist() {
        //Arrange
        Response productoEsperado = new Response(500, "Internal Server Error: No value present");
        productoService = new ProductoServiceImpl(productRepository);

        //Actions
        given(productRepository.findById(anyLong())).willReturn(Optional.empty());
        Response productoResultado = productoService.getProduct(1L);

        //Assert
        assertEquals(productoEsperado,productoResultado);
    }

    @Test
    public void getProductSuccess() {
        //Arrange
        Response productoEsperado = new Response(200, "Lista de productos", new Producto(1L, null,null,null));
        productoService = new ProductoServiceImpl(productRepository);

        //Actions
        given(productRepository.findById(anyLong())).willReturn(Optional.of(new Producto(1L, null,null,null)));
        Response productoResultado = productoService.getProduct(1L);

        //Assert
        assertEquals(productoEsperado,productoResultado);
        //TODO hacer assert del producto que retorna
    }

}