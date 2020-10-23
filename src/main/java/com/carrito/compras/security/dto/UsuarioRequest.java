package com.carrito.compras.security.dto;

import javax.validation.constraints.NotNull;

public class UsuarioRequest {
    @NotNull(message = "El usuario es requerido")
    private String usuario;
    @NotNull(message = "La clave es requerida")
    private String pwd;
    private String token;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
