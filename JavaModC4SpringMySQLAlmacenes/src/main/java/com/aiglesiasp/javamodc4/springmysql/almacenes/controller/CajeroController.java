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

import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Cajero;
import com.aiglesiasp.javamodc4.springmysql.almacenes.service.CajeroServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;

	@GetMapping("/cajeros")
	public List<Cajero> listarCajero() {
		return cajeroServiceImpl.listarCajero();
	}

	@PostMapping("/cajeros")
	public Cajero guardarCajero(@RequestBody Cajero cajero) {
		return cajeroServiceImpl.guardarCajero(cajero);
	}

	@GetMapping("/cajeros/{codigo}")
	public Cajero cajeroById(@PathVariable(name = "codigo") int codigo) {
		Cajero cajero = new Cajero();
		cajero = cajeroServiceImpl.cajeroById(codigo);
		return cajero;
	}

	@PutMapping("/cajeros/{codigo}")
	public Cajero actualizarCajero(@PathVariable(name = "codigo") int codigo, @RequestBody Cajero cajero) {

		Cajero cajero_seleccionado = new Cajero();
		Cajero cajero_actualizado = new Cajero();
		cajero_seleccionado = cajeroServiceImpl.cajeroById(codigo);
		cajero_seleccionado.setCodigo(codigo);
		cajero_seleccionado.setNomApels(cajero.getNomApels());
		cajero_seleccionado.setVenta(cajero.getVenta());

		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);

		return cajero_actualizado;
	}

	@DeleteMapping("/cajeros/{codigo}")
	public void eliminarCajero(@PathVariable(name = "codigo") int codigo) {
		cajeroServiceImpl.eliminarCajero(codigo);
	}

}
