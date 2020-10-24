package com.carrito.compras.controller;


import com.carrito.compras.dto.request.ProductoActualizarRequestDTO;
import com.carrito.compras.dto.request.ProductoRequestDTO;
import com.carrito.compras.entity.Producto;
import com.carrito.compras.service.producto.ProductoService;
import com.carrito.compras.util.Response;
import com.carrito.compras.util.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    private ModelMapper modelMapper;


    @GetMapping(value = "/{name}")
    public ResponseEntity<Response> getproducto(@PathVariable("name") String name){
        Response response  = productoService.findByNombre(name);
        return new ResponseEntity<>(response, Utils.getHttpStatusResponse(response));
    }

    @GetMapping
    public ResponseEntity<Response> getAllListProducto(){
        Response response =  productoService.listAllListProducto();
        return new ResponseEntity<>(response, Utils.getHttpStatusResponse(response));
    }

    @PostMapping("")
    public ResponseEntity<Response> crearProducto(@Valid @RequestBody ProductoRequestDTO productoRequestDTO) {
        this.modelMapper = new ModelMapper();
        Producto producto = this.modelMapper.map(productoRequestDTO, Producto.class);
        Response response = productoService.crearProducto(producto);
        return new ResponseEntity<>(response, Utils.getHttpStatusResponse(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizarProducto(@PathVariable Long id, @Valid @RequestBody ProductoActualizarRequestDTO productoActualizarRequestDTO){
        this.modelMapper = new ModelMapper();
        Producto data = this.modelMapper.map(productoActualizarRequestDTO, Producto.class);
        Response response =  productoService.actualizarProducto(id, data);
        return new ResponseEntity<>(response, Utils.getHttpStatusResponse(response));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> eliminarProducto(@PathVariable("id") Long id){
        Response response = productoService.eliminarProducto(id);
        return new ResponseEntity<>(response, Utils.getHttpStatusResponse(response));

    }


}
