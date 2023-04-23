/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.almacenes.service;

import java.util.List;

import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Producto;

/**
 * @author aitor
 *
 */
public interface IProductoService {
	// Metodos del CRUD
	public List<Producto> listarProducto(); // Listar All

	public Producto guardarProducto(Producto producto); // Guarda un departamento CREATE

	public Producto productoaById(int codigo); // Leer datos de un departamento READ

	public Producto actualizarProducto(Producto producto); // Actualiza datos del departamento UPDATE

	public void eliminarProducto(int codigo);// Elimina el departamento DELETE
}
