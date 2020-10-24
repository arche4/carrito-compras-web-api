package com.carrito.compras.service.producto;

import com.carrito.compras.entity.Producto;
import com.carrito.compras.repository.ProductoRepository;
import com.carrito.compras.service.producto.impl.ProductoServiceImpl;
import org.mockito.Mockito;
import org.junit.Test;
import com.carrito.compras.exceptions.NoDataFoundException;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.junit.Assert.assertEquals;


import java.util.Optional;


public class ProductoServiceImplTest {

    //Otra forma de mockear
    private ProductoRepository productRepository = Mockito.mock(ProductoRepository.class);

    private ProductoService productoService;

    //Corre este test
    @Test(expected=NoDataFoundException.class)
    public void getProductThatNoExist() {
        productoService = new ProductoServiceImpl(productRepository);
        given(productRepository.findById(anyLong())).willReturn(Optional.empty());
        productoService.getProduct(1L);
    }

    @Test
    public void getProductSuccess() {
        Producto productoEsperado = new Producto();
        productoEsperado.setIdProducto(1L);
        productoService = new ProductoServiceImpl(productRepository);
        given(productRepository.findById(anyLong())).willReturn(Optional.of(productoEsperado));
        Producto productoResultado = productoService.getProduct(1L);
        assertEquals(productoEsperado, productoResultado);
        //TODO hacer assert del producto que retorna
    }

}