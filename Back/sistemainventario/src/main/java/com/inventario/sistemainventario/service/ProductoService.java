package com.inventario.sistemainventario.service;

/*
 *   Clase: ProductoService
 *
 *   Descripción:
 *       Clase ProductoService que se encuentran las reglas y lógica de aplicación
 *       del modelo Productos. De aqui saldrán las rutas dentro de nuestro proyecto
 *
 */


/*Importaciones para los servicios, estos funcionan con la capa de acceso de datos (repositorios)*/
import com.inventario.sistemainventario.model.Productos;
import com.inventario.sistemainventario.repository.HistorialRepository;
import com.inventario.sistemainventario.repository.ProductosRepository;
import com.inventario.sistemainventario.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    //Inyecciones de dependencias
    private final ProductosRepository productosRepository;

    //Constructor
    public ProductoService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    /*
    *   Metodo crearProducto (crea un nuevo producto)
    *
    *   @Params: Recibe los campos necesarios para crear un producto { nombre }
    *            El stock y el status ya tienen un valor por defecto
    *   @Return: Retorna el producto creado
    * */
    public Productos crearProducto(String nombre){

        //Verificar que el producto no exista
        Optional<Productos> productoExistente = productosRepository.findByNombre(nombre);
        if (productoExistente.isPresent()){
            throw new RuntimeException("El Producto ya existe");
        }

        //Creamos el producto
        Productos producto = new Productos();
        producto.setNombre(nombre);

        return productosRepository.save(producto);
    }

    /*
     *   Metodo cambiarEstatusProducto (actualiza el estatus del producto)
     *
     *   @Params: Recibe el Id del producto a modificar
     *   @Return: Retorna el producto modificado
     * */
    public Productos cambiarEstatusProducto(Integer idProducto){

        //Verificamos que el producto exista
        Productos productoExistente = productosRepository.findById(idProducto).orElseThrow(
                ()-> new RuntimeException("El producto no existe")
        );

        if (productoExistente.getStatus() == 1) {
            productoExistente.setStatus(0);
        }else{
            productoExistente.setStatus(1);
        }

        return productosRepository.save(productoExistente);
    }

    /*
     *   Metodo obtenerProductos (Obtiene todos los productos existentes)
     *
     *   @Params: No recibe parámetro
     *   @Return: Retorna lista de todos los productos
     * */
    public List<Productos> obtenerProductos(){
        return productosRepository.findAll();
    }

    /*
     *   Metodo obtenerProductosActivos (obtiene los productos activos)
     *
     *   @Params: No recibe parámetro
     *   @Return: Retorna lista de todos los productos Activos
     * */
    public List<Productos> obtenerActivos() {
        return productosRepository.findByStatus(1);
    }

    /*
     *   Metodo obtenerProductoId (obtiene un producto por ID)
     *
     *   @Params: Recibe el id del producto a buscar
     *   @Return: Retorna el producto encontrado
     * */
    public Productos obtenerProductoId(Integer idProducto){
        return productosRepository.findById(idProducto).orElseThrow(
                ()-> new RuntimeException("El producto no se encontró")
        );
    }
}
