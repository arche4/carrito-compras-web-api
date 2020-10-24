package com.carrito.compras.security.controller;

import com.carrito.compras.security.dto.UsuarioRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class usuarioController {

    @PostMapping("user")
    public UsuarioRequest login(@RequestParam("usuario") String usuarioname, @RequestParam("password") String pwd) {

        return null;
    }





}
