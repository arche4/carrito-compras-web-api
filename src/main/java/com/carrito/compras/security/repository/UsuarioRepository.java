package com.carrito.compras.security.repository;

import com.carrito.compras.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface  UsuarioRepository extends JpaRepository<Usuario,Long> {
    public List<Usuario> findByUsuario(String usuario);
}
