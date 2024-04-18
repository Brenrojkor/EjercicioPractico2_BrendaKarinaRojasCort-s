/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.demo.service;

import com.examen.demo.domain.Empleados;
import java.util.List;

public interface EmpleadosService {
    
    // Se obtiene un listado de usuarios en un List
    public List<Empleados> getEmpleados();
    
    // Se obtiene un Usuario, a partir del id de un usuario
    public Empleados getEmpleados(Empleados empleado);
    
    // Se obtiene un Usuario, a partir del username de un usuario
    public Empleados getUsuarioPorId(String id);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Empleados getUsuarioPorIdYPassword(String id, String password);
      
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(Empleados usuario,boolean crearRolUser);
    
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Empleados empleados);
}