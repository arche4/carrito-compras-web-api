package com.carrito.compras.service.venta;


import com.carrito.compras.entity.Venta;

public interface VentaService {

    public Venta getVenta(Long id);
    public Venta crearVenta (Venta venta);
}
