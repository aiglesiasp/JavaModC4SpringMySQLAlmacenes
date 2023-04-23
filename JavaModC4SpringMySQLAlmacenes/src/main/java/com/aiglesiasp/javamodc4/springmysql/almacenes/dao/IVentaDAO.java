package com.aiglesiasp.javamodc4.springmysql.almacenes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiglesiasp.javamodc4.springmysql.almacenes.dto.Venta;

public interface IVentaDAO extends JpaRepository<Venta, Integer> {

}
