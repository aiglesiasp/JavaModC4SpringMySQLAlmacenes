/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.almacenes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Producto;


/**
 * @author aitor
 *
 */
public interface IProductoDAO extends JpaRepository<Producto, Integer> {

}
