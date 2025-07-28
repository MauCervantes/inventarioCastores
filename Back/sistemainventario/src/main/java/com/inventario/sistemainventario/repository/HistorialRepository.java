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
import com.inventario.sistemainventario.model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer> {
    /*Agrega automáticamente los métodos
     *   save()
     *   findById()
     *   findAll()
     *   deleteById()
     *   count()
     * */
}
