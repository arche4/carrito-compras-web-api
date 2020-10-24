package com.carrito.compras.controller;

import com.carrito.compras.dto.request.VentaRequestDTO;
import com.carrito.compras.entity.Cliente;
import com.carrito.compras.entity.Producto;
import com.carrito.compras.entity.Venta;
import com.carrito.compras.service.cliente.ClienteService;
import com.carrito.compras.service.producto.ProductoService;
import com.carrito.compras.service.venta.VentaService;
import com.carrito.compras.util.Response;
import com.carrito.compras.util.Utils;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/venta")
public class VentaController {

    private VentaService ventaService;
    private ClienteService clienteService;
    private ProductoService productoService;

    private ModelMapper modelMapper;

    @Autowired
    public VentaController(VentaService ventaService, ClienteService clienteService,ProductoService productoService) {
        this.ventaService = ventaService;
        this.clienteService = clienteService;
        this.productoService = productoService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Venta> getListTodo(@PathVariable("id") Long id) {
        Venta venta = ventaService.getVenta(id);
        return ResponseEntity.ok(venta);
    }

    @GetMapping
    public List<Venta> getVentasAlls() {
        return ventaService.listAllListVentas();
    }

    @PostMapping(value = "/crearVenta/{idProducto}")
    public ResponseEntity<Response> crearVenta(@PathVariable("idProducto") Long id, @Valid @RequestBody VentaRequestDTO ventaRequestDTO) {
        Cliente cliente = clienteService.getClienteid(ventaRequestDTO.getIdcliente());
        Producto producto = productoService.getProductid(id);
        if (cliente == null && producto== null) {
            return ResponseEntity.notFound().build();
        } else {
            this.modelMapper = new ModelMapper();
            Venta venta = this.modelMapper.map(ventaRequestDTO, Venta.class);
            venta.setCliente(cliente);
            Response response = ventaService.crearVenta(producto, venta);
            return new ResponseEntity<>(response, Utils.getHttpStatusResponse(response));
        }


    }


}
