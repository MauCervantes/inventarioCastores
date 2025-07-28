package com.inventario.sistemainventario.controller;

/*
 * Clase: AuthController
 *
 * Descripción:
 *       Clase Controlador AuthController, en esta se especifican los endpoints
 *       para las acciones de nuestro Login Estas serán consumidas por nuestro front
 *
 * */

/*Importaciones para el controller y endpoints*/
import com.inventario.sistemainventario.dto.AuthResponse;
import com.inventario.sistemainventario.dto.ProductoDTO;
import com.inventario.sistemainventario.dto.Login;
import com.inventario.sistemainventario.model.Usuarios;
import com.inventario.sistemainventario.repository.UsuariosRepository;
import com.inventario.sistemainventario.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UsuariosRepository usuariosRepository;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody Login request) {
        //Autenticar el usuario
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getContrasena())
        );

        //Autenticación Exitosa
        Usuarios user = usuariosRepository.findByCorreo(request.getCorreo()).orElseThrow();

        //Generamos token
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new AuthResponse(token, user.getIdUsuario(), user.getRol()));
    }
}
