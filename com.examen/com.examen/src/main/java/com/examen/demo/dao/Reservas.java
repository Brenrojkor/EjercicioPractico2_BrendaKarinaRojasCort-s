/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.demo.dao;

import com.examen.demo.domain.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Reservas extends JpaRepository <Empleados,Long> {
     
}
