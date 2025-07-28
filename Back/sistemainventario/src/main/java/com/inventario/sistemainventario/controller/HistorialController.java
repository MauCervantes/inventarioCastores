package com.inventario.sistemainventario.controller;

/*
 * Clase: HistorialController
 *
 * Descripción:
 *       Clase Controlados HistorialController, en esta se especifican los endpoints
 *       para las acciones de nuestro modelo Historial Estas serán consumidas por nuestro front
 *
 * */

/*Importaciones para el controller y endpoints*/
import com.inventario.sistemainventario.dto.HistorialDTO;
import com.inventario.sistemainventario.model.Historial;
import com.inventario.sistemainventario.service.HistorialService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;


@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    //Instancia del servicio
    private final HistorialService historialService;

    //Constructor
    public HistorialController(HistorialService historialService) {
        this.historialService = historialService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('Administrador', 'Almacenista')")
    public Historial crearHistorial(@RequestBody HistorialDTO historialDTO) {
        return historialService.crearHistorial(
                historialDTO.getIdUsuario(),
                historialDTO.getIdProducto(),
                historialDTO.getMovimiento(),
                historialDTO.getCantidad()
        );
    }

    @GetMapping
    @PreAuthorize("hasRole('Administrador')")
    public List<Historial> listarHistorial(){
        return historialService.obtenerHistorial();
    }
}
