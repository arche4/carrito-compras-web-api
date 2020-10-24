package com.carrito.compras.security.service.impl;


import com.carrito.compras.security.entity.Usuario;
import com.carrito.compras.security.repository.UsuarioRepository;
import com.carrito.compras.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findByUsuario(String nombre) {
        return usuarioRepository.findByUsuario(nombre);
    }
}
