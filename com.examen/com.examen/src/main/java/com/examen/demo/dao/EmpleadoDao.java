/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.demo.dao;

import com.examen.demo.domain.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoDao extends JpaRepository<Empleados, Long> {

    Empleados findByUsername(String id);

    Empleados findByUsernameAndPassword(String id, String name);

}
