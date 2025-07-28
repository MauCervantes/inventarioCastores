package com.inventario.sistemainventario.controller;

/*
* Clase: UsuariosController
*
* Descripción:
*       Clase Controlados UsuariosController, en esta se especifican los endpoints
*       para las acciones de nuestro modelo Usuario Estas serán consumidas por nuestro front
*
* */

/*Importaciones para el controller y endpoints*/
import com.inventario.sistemainventario.dto.UsuarioDTO;
import com.inventario.sistemainventario.model.Usuarios;
import com.inventario.sistemainventario.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    //Instancia del servicio
    private final UsuarioService usuarioService;

    //Constructor
    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuarios crearUsuarios(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.crearUsuarios(
                usuarioDTO.getNombre(),
                usuarioDTO.getCorreo(),
                usuarioDTO.getContrasena(),
                usuarioDTO.getIdRol()
        );
    }
}
