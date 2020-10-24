package com.carrito.compras.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Venta")
@NoArgsConstructor
@AllArgsConstructor
public class Venta {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Long idVenta;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @Column(name = "fecha")
    private Date fecha;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "venta",
            cascade = CascadeType.ALL
    )
    private List<DetalleVenta> detalleVenta = new ArrayList<>();

}
