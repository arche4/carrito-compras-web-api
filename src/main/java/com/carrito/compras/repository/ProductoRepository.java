package com.carrito.compras.repository;

import com.carrito.compras.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
    public List<Producto> findByNombre(String nombre);
}
