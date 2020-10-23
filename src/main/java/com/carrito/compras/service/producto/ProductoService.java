package com.carrito.compras.service.producto;

import com.carrito.compras.entity.Producto;

public interface ProductoService {

    public Producto getProduct(Long id);
    public Producto crearProducto (Producto producto);
    public Producto actualizarProducto (Producto producto);
    public Producto eliminarProducto(Long id);

}
