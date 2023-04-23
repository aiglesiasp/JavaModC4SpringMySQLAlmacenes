/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.almacenes.service;

import java.util.List;

import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Venta;


/**
 * @author aitor
 *
 */
public interface IVentaService {
	// Metodos del CRUD
	public List<Venta> listarVenta(); // Listar All

	public Venta guardarVenta(Venta venta); // Guarda un suministra CREATE

	public Venta ventaById(int id); // Leer datos de un suministra READ

	public Venta actualizarVenta(Venta venta); // Actualiza datos del suministra UPDATE

	public void eliminarVenta(int id);// Elimina el suministra DELETE

}
