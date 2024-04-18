/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.service.impl;

import com.examen.demo.dao.RolesDao;
import com.examen.demo.dao.EmpleadoDao;
import com.examen.demo.domain.Roles;
import com.examen.demo.domain.Empleados;
import com.examen.demo.service.EmpleadosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {
    @Autowired
    private EmpleadoDao empleadoDao;
    @Autowired
    private RolesDao rolesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleados> getUsuarios() {
        return empleadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empleados getEmpleados(Empleados empleado) {
        return empleadoDao.findById(empleado.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleados getUsuarioPorId(String id) {
        return empleadoDao.findByUsername(id);
    }

   
}

