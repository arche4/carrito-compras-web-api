package com.carrito.compras.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductoActualizarRequestDTO {
    @NotNull(message = "El nombre es requerido")
    private String nombre;

    @NotNull(message = "El precio es requerido")
    private String precio;

}
