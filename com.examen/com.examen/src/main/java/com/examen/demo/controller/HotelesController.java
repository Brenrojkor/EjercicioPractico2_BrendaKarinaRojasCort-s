/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.examen.demo.service.HotelesService;

@Controller
@Slf4j
@RequestMapping("/hoteles")
public class HotelesController {
    
    @Autowired
    private HotelesService hotelesService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var hotel = hotelesService.getHoteles(false);
        model.addAttribute("hoteles", hotel);
        model.addAttribute("totalhoteles", hotel.size());
        return "/hoteles/listado";
    }
}