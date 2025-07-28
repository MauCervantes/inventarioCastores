package com.inventario.sistemainventario.repository;

/*
 *   Interfaz: RolRepository
 *
 *   Descripción:
 *       Repositorio RolRepository, extiende de JpaRepository para adquirir todos los métodos de un CRUD
 *       Nos ahorra la creación de cada uno de los métodos.
 *
 */

/*Importaciones para la interfaz*/
import com.inventario.sistemainventario.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Componente de acceso de datos
public interface RolRepository extends JpaRepository<Rol, Integer>{
    /*Agrega automáticamente los métodos
    *   save()
    *   findById()
    *   findAll()
    *   deleteById()
    *   count()
    * */
}
