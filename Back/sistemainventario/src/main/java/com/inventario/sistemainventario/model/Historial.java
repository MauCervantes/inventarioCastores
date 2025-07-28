package com.inventario.sistemainventario.model;

/*
 *   Entidad: Historial
 *
 *   Descripción:
 *       Clase que representa la entidad Historial que seria la tabla correspondiente de MySQL
 *       Usamos importaciones de jakarta.persistence para todas las descripciones (creaciones)
 *       de campos de la tabla correspondiente
 *
 */

/*Importaciones para entidades (modelos)*/
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;


@Data
@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorial")
    private Integer idHistorial;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Productos producto;

    @Column(name = "movimiento", length = 20, nullable = false)
    private String movimiento;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
}
