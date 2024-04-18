/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.service.impl;

import com.examen.demo.domain.Usuarios;
import com.examen.demo.service.CorreoService;
import com.examen.demo.service.RegistroService;
import com.examen.demo.service.UsuariosService;
import jakarta.mail.MessagingException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private CorreoService correoService;
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private MessageSource messageSource;  //creado en semana 4...
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @Override
    public Model activar(Model model, String username, String clave) {
        Usuarios usuario
                = usuariosService.getUsuarioPorUsernameYPassword(username,
                        clave);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        } else {
            model.addAttribute(
                    "titulo",
                    messageSource.getMessage(
                            "registro.activar",
                            null, Locale.getDefault()));
            model.addAttribute(
                    "mensaje",
                    messageSource.getMessage(
                            "registro.activar.error",
                            null, Locale.getDefault()));
        }
        return model;
    }

    @Override
    public void activar(Usuarios usuario, MultipartFile imagenFile) {
        var codigo = new BCryptPasswordEncoder();
        usuario.setPassword(codigo.encode(usuarios.getPassword()));

        if (!imagenFile.isEmpty()) {
            usuariosService.save(usuario, false);
            
    }

       
    }
    
    @Override
    public Model crearUsuario(Model model, Usuarios usuario)
            throws MessagingException {
        String mensaje;
        if (!usuariosService.
                existeUsuarioPorUsername(
                        usuario.getUsername())) {
            String clave = demeClave();
            usuario.setPassword(clave);
            usuario.setActivo(false);
            usuariosService.save(usuario, true);
            enviaCorreoActivar(usuario, clave);
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.activacion.ok",
                            null,
                            Locale.getDefault()),
                    usuario.);
        } else {
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.usuario.o.correo",
                            null,
                            Locale.getDefault()),
                    usuario.getUsername(), usuario.getCorreo());
        }
        model.addAttribute(
                "titulo",
                messageSource.getMessage(
                        "registro.activar",
                        null,
                        Locale.getDefault()));
        model.addAttribute(
                "mensaje",
                mensaje);
        return model;
    }

    @Override
    public Model recordarUsuario(Model model, Usuarios usuario)
            throws MessagingException {
        String mensaje;
        Usuarios usuario2 = usuariosService.getUsuarioPorUsernameOCorreo(
                usuario.getUsername(),
                usuario.getCorreo());
        if (usuario2 != null) {
            String clave = demeClave();
            usuario2.setPassword(clave);
            usuario2.setActivo(false);
            usuariosService.save(usuario2, false);
            enviaCorreoRecordar(usuario2, clave);
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.recordar.ok",
                            null,
                            Locale.getDefault()),
                    usuario.getCorreo());
        } else {
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.usuario.o.correo",
                            null,
                            Locale.getDefault()),
                    usuario.getUsername(), usuario.getCorreo());
        }
        model.addAttribute(
                "titulo",
                messageSource.getMessage(
                        "registro.activar",
                        null,
                        Locale.getDefault()));
        model.addAttribute(
                "mensaje",
                mensaje);
        return model;
    }

    private String demeClave() {
        String tira = "ABCDEFGHIJKLMNOPQRSTUXYZabcdefghijklmnopqrstuvwxyz0123456789_*+-";
        String clave = "";
        for (int i = 0; i < 40; i++) {
            clave += tira.charAt((int) (Math.random() * tira.length()));
        }
        return clave;
    }

}

    