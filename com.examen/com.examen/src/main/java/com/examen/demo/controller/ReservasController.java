/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.controller;

import com.examen.demo.service.ReservasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/reserva")
public class ReservasController {
    
    @Autowired
    private ReservasService reservaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var reservas = reservaService.getReservas(false);
        model.addAttribute("reservas", reservas);
        model.addAttribute("totalreservas", reservas.size());
        return "/categoria/listado";
    }
}