package com.inventario.sistemainventario.model;

/*
*   Entidad: Usuarios
*
*   Descripción:
*       Clase que representa la entidad Usuarios que seria la tabla correspondiente de MySQL
*       Usamos importaciones de jakarta.persistence para todas las descripciones (creaciones)
*       de campos de la tabla correspondiente
*
*   Extiende de la clase UserDetails para cuestiones de manejo de roles en la aplicación web
*
*/

/*Importaciones para entidades (modelos)*/
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data                     //Anotación de Lombok para generar automáticamente getters, setters, etc.
@Entity                   //Le dice a Spring que esta clase representa una tabla de la base de datos.
@Table(name = "usuarios") // Especifica a qué tabla se conecta.
public class Usuarios implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "correo", length = 100, nullable = false, unique = true)
    private String correo;

    @Column(name = "contrasena", length = 255, nullable = false)
    private String contrasena;

    @Column(name = "status", nullable = false)
    private Integer status = 1;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + rol.getRol()));
    }

    @Override
    public String getPassword() {
        return contrasena; // El campo de la contraseña
    }

    @Override
    public String getUsername() {
        return correo; // Usamos el correo como "username"
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Asumimos que las cuentas no expiran
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Asumimos que las cuentas no se bloquean
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Asumimos que las credenciales no expiran
    }

    @Override
    public boolean isEnabled() {
        return this.status == 1; // La cuenta está habilitada si el status es 1
    }
}
