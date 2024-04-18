/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.controller;

import com.examen.demo.service.HotelesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/hoteles")
public class HotelesController {
    
    @Autowired
    private HotelesService categoriaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var Hoteles = categoriaService.getHoteles(false);
        model.addAttribute("categorias", Hoteles);
        model.addAttribute("totalCategorias", Hoteles.size());
        return "/hoteles/listado";
    }
}