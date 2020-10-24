package com.carrito.compras.security.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UsuarioRequest {
    @NotNull(message = "El usuario es requerido")
    private String usuario;

    @NotNull(message = "La clave es requerida")
    private String pwd;

    private String token;



}
