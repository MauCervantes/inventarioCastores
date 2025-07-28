package com.inventario.sistemainventario.dto;

import com.inventario.sistemainventario.model.Rol;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private Integer idUsuario;
    private Rol idRol;

    public AuthResponse(String token, Integer idUsuario, Rol rol) {
        this.token = token;
        this.idUsuario = idUsuario;
        this.idRol = rol;
    }
}
