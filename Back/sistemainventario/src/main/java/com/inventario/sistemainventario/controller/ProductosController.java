package com.inventario.sistemainventario.controller;

/*
 * Clase: ProductosController
 *
 * Descripción:
 *       Clase Controlados ProductosController, en esta se especifican los endpoints
 *       para las acciones de nuestro modelo Producto Estas serán consumidas por nuestro front
 *
 * */

/*Importaciones para el controller y endpoints*/

import com.inventario.sistemainventario.dto.ProductoDTO;
import com.inventario.sistemainventario.model.Productos;
import com.inventario.sistemainventario.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    //Instancia del servicio
    private final ProductoService productoService;

    //Constructor
    public ProductosController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    @PreAuthorize("hasRole('Administrador')")
    public Productos crearProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.crearProducto(
                productoDTO.getNombre()
        );
    }

    @GetMapping()
    @PreAuthorize("hasRole('Administrador')")
    public List<Productos> obtenerProductos() {
        return productoService.obtenerProductos();
    }


    @PatchMapping("/status/{idProducto}")
    @PreAuthorize("hasRole('Administrador')")
    public Productos modificarStatus(@PathVariable Integer idProducto) {
        return productoService.cambiarEstatusProducto(
                idProducto
        );
    }

    @GetMapping("/activos")
    @PreAuthorize("hasAnyRole('Administrador', 'Almacenista')")
    public List<Productos> obtenerProductosActivos() {
        return productoService.obtenerActivos();
    }

    @GetMapping("/{idProducto}")
    @PreAuthorize("hasAnyRole('Administrador', 'Almacenista')")
    public Productos obtenerProducto(@PathVariable Integer idProducto) {
        return productoService.obtenerProductoId(
                idProducto
        );
    }
}
