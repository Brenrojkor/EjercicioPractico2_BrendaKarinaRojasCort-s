/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.service.impl;

import com.examen.demo.dao.RolesDao;
import com.examen.demo.dao.UsuariosDao;
import com.examen.demo.domain.Roles;
import com.examen.demo.domain.Usuarios;
import com.examen.demo.service.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuariosDao usuariosDao;
    @Autowired
    private RolesDao rolesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> getUsuarios() {
        return usuariosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuario(Usuarios usuario) {
        return usuariosDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorUsername(String username) {
        return usuariosDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorUsernameYPassword(String username, String password) {
        return usuariosDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional
    public void save(Usuarios usuario, boolean crearRolUser) {
        usuario=usuariosDao.save(usuario);
        if (crearRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            Roles rol = new Roles();
            rol.setNombre("ROLE_USER");
            rol.setIdUsuario(usuario.getIdUsuario());
            rolesDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Usuarios usuario) {
        usuariosDao.delete(usuario);
    }
}
