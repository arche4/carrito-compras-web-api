package com.carrito.compras.security.service;

import com.carrito.compras.security.entity.Usuario;

import java.util.List;

public interface UsuarioService {
     List<Usuario> findByUsuario(String nombre);
}
