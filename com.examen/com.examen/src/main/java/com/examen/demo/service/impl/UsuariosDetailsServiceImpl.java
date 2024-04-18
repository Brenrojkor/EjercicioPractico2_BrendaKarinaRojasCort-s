/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.service.impl;

import com.examen.demo.dao.UsuarioDao;
import com.examen.demo.domain.Usuarios;
import com.examen.demo.domain.Roles;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.examen.demo.service.UsuariosDetailsService;

@Service("userDetailsService")
public class UsuariosDetailsServiceImpl implements UsuariosDetailsService, UserDetailsService {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //Busca al usuario por el username en la tabla
        Usuarios usuarios = usuarioDao.findByUsername(username);
        //si no existe el usuario lanza una excepcion
        if (usuarios == null) {
            throw new UsernameNotFoundException(username);  
        }
        //si está acá, es por que existe el usuario sacamos los roles que tiene
        var roles = new ArrayList<GrantedAuthority>();
        for (Roles rol : usuarios.getRoles()) {//se sacan los roles
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));           
        }
        // se devuelve User (clase de UserDetails)
        return new User(usuarios.getUsername(),usuarios.toString(),roles);
    }
    
}
