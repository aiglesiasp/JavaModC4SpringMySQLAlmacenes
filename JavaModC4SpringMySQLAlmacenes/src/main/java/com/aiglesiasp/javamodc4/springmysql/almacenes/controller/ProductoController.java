/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.almacenes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Producto;
import com.aiglesiasp.javamodc4.springmysql.almacenes.service.ProductoServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;

	@GetMapping("/productos")
	public List<Producto> listarProducto() {
		return productoServiceImpl.listarProducto();
	}

	@PostMapping("/productos")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return productoServiceImpl.guardarProducto(producto);
	}

	@GetMapping("/productos/{codigo}")
	public Producto productoaById(@PathVariable(name = "codigo") int codigo) {
		Producto producto = new Producto();
		producto = productoServiceImpl.productoaById(codigo);
		return producto;
	}

	@PutMapping("/productos/{codigo}")
	public Producto actualizarProducto(@PathVariable(name = "codigo") int codigo, @RequestBody Producto producto) {

		Producto producto_seleccionado = new Producto();
		Producto producto_actualizado = new Producto();
		producto_seleccionado = productoServiceImpl.productoaById(codigo);
		producto_seleccionado.setCodigo(codigo);
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		producto_seleccionado.setVenta(producto.getVenta());

		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);

		return producto_actualizado;
	}

	@DeleteMapping("/productos/{codigo}")
	public void eliminarProducto(@PathVariable(name = "codigo") int codigo) {
		productoServiceImpl.eliminarProducto(codigo);
	}

}
