package com.inventario.sistemainventario.dto;

import lombok.Data;

/*
 *   Clase: LoginDTO
 *
 *   Descripción:
 *       Maneja los datos de Usuario Rol sin representar nuestro modelo Usuarios por seguridad
 *       Esto para el manejo del login
 * */
@Data
public class Login {
    private String correo;
    private String contrasena;
}
