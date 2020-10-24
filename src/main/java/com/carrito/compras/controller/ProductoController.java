package com.carrito.compras.controller;


import com.carrito.compras.dto.request.ProductoActualizarRequestDTO;
import com.carrito.compras.dto.request.ProductoRequestDTO;
import com.carrito.compras.entity.Producto;
import com.carrito.compras.service.producto.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    private ModelMapper modelMapper;


    @GetMapping(value = "/{name}")
    public ResponseEntity<List<Producto>> getproducto(@PathVariable("name") String name){
        List<Producto> productoNombre = productoService.findByNombre(name);
        if(productoNombre.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoNombre);
    }

    @GetMapping
    public List<Producto> getAllListProducto(){
        return productoService.listAllListProducto();
    }

    @PostMapping("")
    public ResponseEntity<?> crearProducto(@Valid @RequestBody ProductoRequestDTO productoRequestDTO) {
        this.modelMapper = new ModelMapper();
        Producto producto = this.modelMapper.map(productoRequestDTO, Producto.class);
        Producto productoCrear = productoService.crearProducto(producto);
        if (productoCrear==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(productoCrear);
        }
    }

    @PutMapping()
    public ResponseEntity<Producto> actualizarProducto(@Valid @RequestBody ProductoActualizarRequestDTO productoActualizarRequestDTO){
        this.modelMapper = new ModelMapper();
        Producto data = this.modelMapper.map(productoActualizarRequestDTO, Producto.class);
        Producto actualizarProducto = productoService.actualizarProducto(data);
        if(actualizarProducto==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizarProducto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable("id") Long id){
        Producto productoEliminar = productoService.eliminarProducto(id);
        if (productoEliminar==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoEliminar);
    }


}
