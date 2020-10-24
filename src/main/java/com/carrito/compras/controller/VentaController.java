package com.carrito.compras.controller;

import com.carrito.compras.entity.Venta;
import com.carrito.compras.service.cliente.ClienteService;
import com.carrito.compras.service.venta.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequestMapping(value = "/venta")
public class VentaController {

    private VentaService ventaService;

    private ModelMapper modelMapper;

    @Autowired
    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Venta> getListTodo(@PathVariable("id") Long id){
        Venta venta = ventaService.getVenta(id);
        return ResponseEntity.ok(venta);
    }





}
