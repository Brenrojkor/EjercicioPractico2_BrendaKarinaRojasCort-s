/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.demo.dao;

import com.examen.demo.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository<Usuarios, Long> {

    Usuarios findByUsername(String username);

    Usuarios findByUsernameAndPassword(String username, String Password);

    boolean existsByUsernameOrCorreo(String username, String correo);
}
