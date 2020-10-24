package com.carrito.compras.service.producto.impl;

import com.carrito.compras.entity.Producto;
import com.carrito.compras.exceptions.NoDataFoundException;
import com.carrito.compras.repository.ProductoRepository;
import com.carrito.compras.service.producto.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public  ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto getProduct(Long id) {
return productoRepository.findById(id).orElseThrow(() -> new NoDataFoundException("product doesn't exist"));
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return null;
    }

    @Override
    public Producto eliminarProducto(Long id) {
        return null;
    }

    @Override
    public List<Producto> findByNombre(String name) {
        return productoRepository.findByNombre(name);
    }

    @Override
    public List<Producto> listAllListProducto() {
        return productoRepository.findAll();
    }
}
