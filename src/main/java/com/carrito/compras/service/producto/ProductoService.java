package com.carrito.compras.service.producto;

import com.carrito.compras.entity.Producto;
import com.carrito.compras.util.Response;

import java.util.List;

public interface ProductoService {

    Response getProduct(Long id);
    Producto getProductid(Long id);
    Response crearProducto (Producto producto);
    Response actualizarProducto (Long id, Producto producto);
    Response eliminarProducto(Long id);
    Response findByNombre(String nombre);
    Response listAllListProducto();

}
