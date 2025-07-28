package com.inventario.sistemainventario.model;

/*
 *   Entidad: Productos
 *
 *   Descripción:
 *       Clase que representa la entidad Productos que seria la tabla correspondiente de MySQL
 *       Usamos importaciones de jakarta.persistence para todas las descripciones (creaciones)
 *       de campos de la tabla correspondiente
 *
 */

/*Importaciones para entidades (modelos)*/
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "stock", nullable = false)
    private Integer stock = 0;

    @Column(name = "status", nullable = false)
    private Integer status = 1;
}
