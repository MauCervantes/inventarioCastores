package com.inventario.sistemainventario.model;

/*
 *   Entidad: Rol
 *
 *   Descripción:
 *       Clase que representa la entidad Rol que seria la tabla correspondiente de MySQL
 *       Usamos importaciones de jakarta.persistence para todas las descripciones (creaciones)
 *       de campos de la tabla correspondiente
 *
 */

/*Importaciones para Entidades (modelos)*/
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private int idRol;

    @Column(name = "rol", length = 50, nullable = false)
    private String rol;
}
