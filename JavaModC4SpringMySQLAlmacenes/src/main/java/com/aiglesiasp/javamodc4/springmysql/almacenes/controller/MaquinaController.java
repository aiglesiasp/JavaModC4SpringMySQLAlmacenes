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

import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Maquina;
import com.aiglesiasp.javamodc4.springmysql.almacenes.service.MaquinaServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class MaquinaController {

	@Autowired
	MaquinaServiceImpl maquinaServiceImpl;

	@GetMapping("/maquinas")
	public List<Maquina> listarMaquina() {
		return maquinaServiceImpl.listarMaquina();
	}

	@PostMapping("/maquinas")
	public Maquina guardarMaquina(@RequestBody Maquina maquina) {
		return maquinaServiceImpl.guardarMaquina(maquina);
	}

	@GetMapping("/maquinas/{codigo}")
	public Maquina maquinaById(@PathVariable(name = "codigo") int codigo) {
		Maquina proveedor = new Maquina();
		proveedor = maquinaServiceImpl.maquinaById(codigo);
		return proveedor;
	}

	@PutMapping("/maquinas/{codigo}")
	public Maquina actualizarMaquina(@PathVariable(name = "codigo") int codigo, @RequestBody Maquina maquina) {

		Maquina maquina_seleccionado = new Maquina();
		Maquina maquina_actualizado = new Maquina();
		maquina_seleccionado = maquinaServiceImpl.maquinaById(codigo);

		maquina_seleccionado.setCodigo(codigo);
		maquina_seleccionado.setPiso(maquina.getPiso());
		maquina_seleccionado.setVenta(maquina.getVenta());

		maquina_actualizado = maquinaServiceImpl.actualizarMaquina(maquina_seleccionado);
		return maquina_actualizado;
	}

	@DeleteMapping("/maquinas/{codigo}")
	public void eliminarMaquina(@PathVariable(name = "codigo") int codigo) {
		maquinaServiceImpl.eliminarMaquina(codigo);
	}

}
