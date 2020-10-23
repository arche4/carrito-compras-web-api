package com.carrito.compras.repository;

import com.carrito.compras.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {
}
