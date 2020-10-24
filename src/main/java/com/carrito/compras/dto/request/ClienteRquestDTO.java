package com.carrito.compras.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteRquestDTO {

    @NotNull(message = "El dni es requierido")
    private String dni;

    @NotNull(message = "El nombre es requierido")
    private String nombre;

    @NotNull(message = "El apellido es requierido")
    private String apellido;

    @NotNull(message = "El telefono es requierido")
    private String telefono;

    @NotNull(message = "El email es requierido")
    private String email;

}
