package com.carrito.compras.controller;



import com.carrito.compras.entity.Producto;
import com.carrito.compras.security.dto.UsuarioRequest;
import com.carrito.compras.security.entity.Usuario;
import com.carrito.compras.security.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import java.util.stream.Collectors;


@RestController
public class usuarioController {

    private UsuarioService usuarioService;
    private ModelMapper modelMapper;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    public usuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("usuario")
    public ResponseEntity<?> validarUsuario(@RequestParam("usuario") String usuarioNombre, @RequestParam("clave") String pwd) {
        List<Usuario> usuarioByName = usuarioService.findByUsuario(usuarioNombre);
        if (usuarioByName.isEmpty()) {
            logger.error(new Date() + "Usuario No existe");
            return ResponseEntity.notFound().build();
        }else{
            String token = getJWTToken(usuarioNombre);
            UsuarioRequest usuario = new UsuarioRequest();
            usuario.setUsuario(usuarioNombre);
            usuario.setToken(token);
            return ResponseEntity.ok(usuario);
        }
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }






}
