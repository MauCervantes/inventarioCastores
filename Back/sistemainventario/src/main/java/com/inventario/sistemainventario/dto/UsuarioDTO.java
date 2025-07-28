package com.inventario.sistemainventario.dto;

/*Importación de Data*/
import lombok.Data;

/*
*   Clase: UsuarioDTO
*
*   Descripción:
*       Maneja los datos de usuario sin representar nuestro modelo Usuarios por seguridad
* */

@Data
public class UsuarioDTO {
    private String nombre;
    private String correo;
    private String contrasena;
    private Integer idRol;
}
