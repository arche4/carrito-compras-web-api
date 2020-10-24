package com.carrito.compras.service.producto.impl;

import com.carrito.compras.entity.Producto;
import com.carrito.compras.exceptions.NoDataFoundException;
import com.carrito.compras.repository.ProductoRepository;
import com.carrito.compras.service.producto.ProductoService;
import com.carrito.compras.util.Response;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final Logger logger = Logger.getLogger(this.getClass());

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Response getProduct(Long id) {
        try {
            Producto producto = productoRepository.findById(id).get();
            return new Response(200, "Lista de productos",  producto);
        } catch (Exception e) {
            logger.error("Error listAllListProducto: " + e.getMessage());
            return new Response(500, "Internal Server Error: " + e.getMessage());
        }

    }

    @Override
    public Producto getProductid(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Response crearProducto(Producto producto) {
        try {
            if (!productoRepository.existsById(producto.getIdProducto())) {
                productoRepository.save(producto);
                logger.error("Producto creado correctamente: " + producto);
                return new Response(200, "Producto creado correctamente", producto);
            } else {
                logger.error("El producto ya existe: " + producto);
                return new Response(401, "El producto ya existe");
            }
        } catch (Exception e) {
            logger.info("Exception create: " + e.getMessage());
            return new Response(500, "Internal Server Error");
        }
    }

    @Override
    public Response actualizarProducto(Long id, Producto producto) {
        producto.setIdProducto(id);
        try {
            Optional<Producto> aux = productoRepository.findById(id);
            if ((aux.isPresent()) && (aux.get().getIdProducto().equals(producto.getIdProducto()))) {
                productoRepository.save(producto);
                logger.error("Producto actualizado correctamente: " + producto);
                return new Response(200, "Producto actualizado correctamente", producto);
            } else {
                return new Response(404, "El producto no existe");
            }
        } catch (Exception e) {
            logger.error("Se presento un error actaulziando producto: " + e.getMessage());
            return new Response(500, "Se presento un error actaulziando producto: " + e.getMessage());
        }
    }

    @Override
    public Response eliminarProducto(Long id) {
        try{
            if(productoRepository.existsById(id)){
                productoRepository.deleteById(id);
                return new Response(200, "Producto eliminado exitosamente");
            }else{
                return new Response(200, "Producto eliminado exitosamente");
            }
        }catch (Exception e) {
            logger.info("Error eliminando producto: " + e.getMessage());
            return new Response(500, "Internal server error: " + e.getMessage());
        }
    }

    @Override
    public Response findByNombre(String name) {
        try {
            return new Response(200, "Producto", (List<Producto>) productoRepository.findByNombre(name));
        } catch (Exception e) {
            logger.error("Error listAllListProducto: " + e.getMessage());
            return new Response(500, "Internal Server Error: " + e.getMessage());
        }
    }

    @Override
    public Response listAllListProducto() {
        try {
            return new Response(200, "Lista de productos", (List<Producto>) productoRepository.findAll());
        } catch (Exception e) {
            logger.error("Error listAllListProducto: " + e.getMessage());
            return new Response(500, "Internal Server Error: " + e.getMessage());
        }

    }
}
