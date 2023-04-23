/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.almacenes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Maquina;

/**
 * @author aitor
 *
 */
public interface IMaquinaDAO extends JpaRepository<Maquina, Integer> {

}
