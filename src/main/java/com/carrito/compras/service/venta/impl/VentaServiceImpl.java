package com.carrito.compras.service.venta.impl;

import com.carrito.compras.entity.Venta;
import com.carrito.compras.repository.VentaRepository;
import com.carrito.compras.service.venta.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta getVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta crearVenta(Venta venta) {
        return ventaRepository.save(venta);
    }
}
