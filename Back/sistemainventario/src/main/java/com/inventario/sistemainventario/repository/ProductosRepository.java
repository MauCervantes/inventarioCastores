package com.inventario.sistemainventario.repository;

/*
 *   Interfaz: ProductoRepository
 *
 *   Descripción:
 *       Repositorio ProductoRepository, extiende de JpaRepository para adquirir todos los métodos de un CRUD
 *       Nos ahorra la creación de cada uno de los métodos.
 *
 */

/*Importaciones para la importacion*/
import com.inventario.sistemainventario.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer>{
    /*Agrega automáticamente los métodos
     *   save()
     *   findById()
     *   findAll()
     *   deleteById()
     *   count()
     * */

    /*Buscar producto por su nombre*/
    Optional<Productos> findByNombre(String nombre);

    List<Productos> findByStatus(Integer status);
}
