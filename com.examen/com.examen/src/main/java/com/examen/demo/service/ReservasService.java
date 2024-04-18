/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.demo.service;

import com.examen.demo.domain.Usuarios;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface ReservasService {

    public Model activar(Model model, String usuario, String clave);

    public Model crearUsuario(Model model, Usuarios usuario) throws MessagingException;
    
    public void activar(Usuarios usuario, MultipartFile imagenFile);
    
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException;
}

