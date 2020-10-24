package com.carrito.compras.dto.request;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class VentaRequestDTO {

    @NotNull(message = "El id del cliente es requierdo")
    private Long idcliente;

    @NotNull(message = "La fecha es requerida")
    private Date fecha;
}
