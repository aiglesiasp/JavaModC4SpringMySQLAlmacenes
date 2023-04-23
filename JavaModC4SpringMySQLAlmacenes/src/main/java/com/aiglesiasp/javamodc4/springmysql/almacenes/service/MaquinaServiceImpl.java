/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.almacenes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiglesiasp.javamodc4.springmysql.almacenes.dao.IMaquinaDAO;
import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Maquina;

/**
 * @author aitor
 *
 */
@Service
public class MaquinaServiceImpl implements IMaquinaService {

	@Autowired
	IMaquinaDAO iMaquinaDAO;

	@Override
	public List<Maquina> listarMaquina() {
		return iMaquinaDAO.findAll();
	}

	@Override
	public Maquina guardarMaquina(Maquina maquina) {
		return iMaquinaDAO.save(maquina);
	}

	@Override
	public Maquina maquinaById(int id) {
		return iMaquinaDAO.findById(id).get();
	}

	@Override
	public Maquina actualizarMaquina(Maquina maquina) {
		return iMaquinaDAO.save(maquina);
	}

	@Override
	public void eliminarMaquina(int id) {
		iMaquinaDAO.deleteById(id);

	}

}
