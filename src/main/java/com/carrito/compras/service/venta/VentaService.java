package com.carrito.compras.service.venta;


import com.carrito.compras.entity.Producto;
import com.carrito.compras.entity.Venta;
import com.carrito.compras.util.Response;

import java.util.List;

public interface VentaService {

    public Venta getVenta(Long id);
    public List<Venta> listAllListVentas();
    public Response crearVenta (Producto producto, Venta venta);
}
