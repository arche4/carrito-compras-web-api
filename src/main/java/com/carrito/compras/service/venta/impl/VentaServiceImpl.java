package com.carrito.compras.service.venta.impl;

import com.carrito.compras.entity.DetalleVenta;
import com.carrito.compras.entity.Producto;
import com.carrito.compras.entity.Venta;
import com.carrito.compras.repository.ClienteRepository;
import com.carrito.compras.repository.DetalleVentaRepository;
import com.carrito.compras.repository.VentaRepository;
import com.carrito.compras.service.venta.VentaService;
import com.carrito.compras.util.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    private final Logger logger = Logger.getLogger(this.getClass());

    private VentaRepository ventaRepository;
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public Venta getVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Venta> listAllListVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Response crearVenta(Producto producto, Venta venta) {
        try {
            ventaRepository.save(venta);
            DetalleVenta detalle = new DetalleVenta();
            detalle.setProducto(producto);
            detalle.setVenta(venta);
            detalleVentaRepository.save(detalle);
            logger.info("Venta creada Exitosamente: " + venta);
            return new Response(200, "Venta creada Exitosamente", venta);
        } catch (Exception e) {
            logger.error("Se presento un error en crearVenta: " + e.getMessage());
            return new Response(500, "Se presento un error creando la venta: " + e.getMessage());
        }
    }
}
