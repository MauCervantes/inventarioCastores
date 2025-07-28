package com.inventario.sistemainventario.service;

/*
 *   Clase: HistorialService
 *
 *   Descripción:
 *       Clase HistorialService que se encuentran las reglas y lógica de aplicación
 *       del modelo Historial. De aqui saldrán las rutas dentro de nuestro proyecto
 *
 */

/*Importaciones para los servicios, estos funcionan con la capa de acceso de datos (repositorios)*/
import com.inventario.sistemainventario.model.Historial;
import com.inventario.sistemainventario.model.Productos;
import com.inventario.sistemainventario.model.Usuarios;
import com.inventario.sistemainventario.repository.HistorialRepository;
import com.inventario.sistemainventario.repository.ProductosRepository;
import com.inventario.sistemainventario.repository.UsuariosRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistorialService {

    //Inyecciones de dependencias
    private final HistorialRepository historialRepository;
    private final ProductosRepository productosRepository;
    private final UsuariosRepository usuariosRepository;

    //Constructor
    public HistorialService(HistorialRepository historialRepository, ProductosRepository productosRepository, UsuariosRepository usuariosRepository) {
        this.historialRepository = historialRepository;
        this.productosRepository = productosRepository;
        this.usuariosRepository = usuariosRepository;
    }

    /*
     *   Metodo crearHistorial (crea un nuevo historia)
     *
     *   @Params: Recibe los campos necesarios para crear un historial { Usuario, Producto, Movimiento, Cantidad, Fecha }
     *            Este metodo tambien modificara al modelo producto.
     *   @Return: Retorna el Historial creado
     * */
    @Transactional
    public Historial crearHistorial(Integer idUsuario, Integer idProducto, String movimiento, Integer cantidad){

        //Verifica que el usuario Exista
        Usuarios usuarioExistente = usuariosRepository.findById(idUsuario).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado")
        );

        //Verifica que el producto si exista
        Productos productoExistente = productosRepository.findById(idProducto).orElseThrow(
                () -> new  RuntimeException("Producto no encontrado")
        );

        //Actualizamos stock en producto
        if (movimiento.equalsIgnoreCase("Salida")){
            int stockNuevo = productoExistente.getStock() - cantidad;
            if(stockNuevo < 0){
                throw new RuntimeException("Stock no puede ser menor a 0");
            }else{
                productoExistente.setStock(stockNuevo);
            }
        }else{
            int stockNuevo = productoExistente.getStock() + cantidad;
            productoExistente.setStock(stockNuevo);
        }

        //Guardamos el producto
        productosRepository.save(productoExistente);

        //Creamos el historial
        Historial historial = new Historial();
        historial.setUsuario(usuarioExistente);
        historial.setProducto(productoExistente);
        historial.setMovimiento(movimiento);
        historial.setCantidad(cantidad);
        historial.setFecha(LocalDateTime.now());

        return historialRepository.save(historial);
    }


    /*
     *   Metodo obtenerHistorial (ver todos los movimientos)
     *
     *   @Params: NO recibe parametros
     *   @Return: Retorna Lista de Historiales
     * */
    public List<Historial> obtenerHistorial(){
        return historialRepository.findAll();
    }
}
