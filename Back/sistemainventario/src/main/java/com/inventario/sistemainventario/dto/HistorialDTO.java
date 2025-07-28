package com.inventario.sistemainventario.dto;

/*
 *   Clase: HistorialDTO
 *
 *   Descripción:
 *       Maneja los datos de historial sin representar nuestro modelo Historial por seguridad
 * */

/*Importación de Data*/
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class HistorialDTO {
    private Integer idUsuario;
    private Integer idProducto;
    private String movimiento;
    private Integer cantidad;
}
