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

import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Venta;
import com.aiglesiasp.javamodc4.springmysql.almacenes.service.VentaServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaServiceImpl ventaServiceImpl;;

	@GetMapping("/ventas")
	public List<Venta> listarVenta() {
		return ventaServiceImpl.listarVenta();
	}

	@PostMapping("/ventas")
	public Venta guardarVenta(@RequestBody Venta venta) {
		return ventaServiceImpl.guardarVenta(venta);
	}

	@GetMapping("/ventas/{id}")
	public Venta ventaById(@PathVariable(name = "id") int id) {
		Venta venta = new Venta();
		venta = ventaServiceImpl.ventaById(id);
		return venta;
	}

	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name = "id") int id, @RequestBody Venta venta) {

		Venta venta_seleccionado = new Venta();
		Venta venta_actualizado = new Venta();
		venta_seleccionado = ventaServiceImpl.ventaById(id);
		venta_seleccionado.setId(id);
		venta_seleccionado.setMaquina(venta.getMaquina());
		venta_seleccionado.setCajero(venta.getCajero());
		venta_seleccionado.setProducto(venta.getProducto());

		venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionado);
		return venta_actualizado;
	}

	@DeleteMapping("/ventas/{id}")
	public void eliminarVenta(@PathVariable(name = "id") int id) {
		ventaServiceImpl.eliminarVenta(id);
	}

}
