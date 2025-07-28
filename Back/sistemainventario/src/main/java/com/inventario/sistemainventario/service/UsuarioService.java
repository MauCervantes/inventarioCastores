package com.inventario.sistemainventario.service;

/*
*   Clase: UsuarioService
*
*   Descripción:
*       Clase UsuarioService que se encuentran las reglas y lógica de aplicación
*       del modelo Usuarios. De aqui saldrán las rutas dentro de nuestro proyecto
*
*/

/*Importaciones para los servicios, estos funcionan con la capa de acceso de datos (repositorios)*/
import com.inventario.sistemainventario.model.Rol;
import com.inventario.sistemainventario.model.Usuarios;
import com.inventario.sistemainventario.repository.RolRepository;
import com.inventario.sistemainventario.repository.UsuariosRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    // Inyecciones de dependencias
    private final UsuariosRepository usuariosRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor
    public UsuarioService(UsuariosRepository usuariosRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Metodo crearUsuario (crea un nuevo usuario)
    public Usuarios crearUsuarios(String nombre, String correo, String contrasena, Integer idRol) {

        //Verificamos que el correo no exista
        Optional<Usuarios> usuarioExistente = usuariosRepository.findByCorreo(correo);
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("El usuario ya está registrado.");
        }

        //Verificamos que el rol es correcto
        Rol rol = rolRepository.findById(idRol).orElseThrow(
                () -> new RuntimeException("El rol no es correcto.")
        );

        //Encriptar la contraseña
        String contraEncriptada = passwordEncoder.encode(contrasena);

        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setContrasena(contraEncriptada);
        nuevoUsuario.setRol(rol);

        return usuariosRepository.save(nuevoUsuario);
    }
}
