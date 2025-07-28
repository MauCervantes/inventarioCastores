package com.inventario.sistemainventario.repository;

/*
 *   Interfaz: UsuariosRepository
 *
 *   Descripción:
 *       Repositorio UsuariosRepository, extiende de JpaRepository para adquirir todos los métodos de un CRUD
 *       Nos ahorra la creación de cada uno de los métodos.
 *
 */
import com.inventario.sistemainventario.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository //Componente de acceso de datos
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
    /*Agrega automáticamente los métodos
     *   save()
     *   findById()
     *   findAll()
     *   deleteById()
     *   count()
     * */

    /*Buscar Usuario por correo*/
    Optional<Usuarios> findByCorreo(String correo);
}
