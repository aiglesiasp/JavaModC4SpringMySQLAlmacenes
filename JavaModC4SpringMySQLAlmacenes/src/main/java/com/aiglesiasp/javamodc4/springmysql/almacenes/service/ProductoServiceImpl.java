/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.almacenes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiglesiasp.javamodc4.springmysql.almacenes.dao.IProductoDAO;
import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Producto;

/**
 * @author aitor
 *
 */
@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	IProductoDAO iProductoDAO;

	@Override
	public List<Producto> listarProducto() {
		return iProductoDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public Producto productoaById(int codigo) {
		return iProductoDAO.findById(codigo).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public void eliminarProducto(int codigo) {
		iProductoDAO.deleteById(codigo);

	}

}
