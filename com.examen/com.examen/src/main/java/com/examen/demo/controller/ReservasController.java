/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.controller;

import com.examen.demo.domain.Usuarios;
import com.examen.demo.service.ReservasService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuarios usuario) {
        return "/reserva/nuevo";
    }

    @GetMapping("/recordar")
    public String recordar(Model model, Usuarios usuario) {
        return "/reservas/recordar";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, Usuarios usuario) 
            throws MessagingException {
        model = reservasService.crearUsuario(model, usuario);
        return "/reservas/salida";
    }

    @GetMapping("/activacion/{usuario}/{id}")
    public String activar(
            Model model, 
            @PathVariable(value = "usuario") String usuario, 
            @PathVariable(value = "id") String id) {
        model = reservasService.activar(model, usuario, id);
        if (model.containsAttribute("usuario")) {
            return "/registro/activa";
        } else {
            return "/registro/salida";
        }
    }

    @PostMapping("/activar")
    public String activar(
            Usuarios usuario, 
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        reservasService.activar(usuario, imagenFile);
        return "redirect:/";
    }

    @PostMapping("/recordarUsuario")
    public String recordarUsuario(Model model, Usuarios usuario) 
            throws MessagingException {
        model = reservasService.recordarUsuario(model, usuario);
        return "/reservas/salida";
    }
}