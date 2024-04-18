/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.demo.service;

import org.springframework.security.core.userdetails.*;

public interface UsuariosDetailsService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;   
}
