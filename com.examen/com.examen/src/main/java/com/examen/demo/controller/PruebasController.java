/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.controller;


import com.examen.demo.domain.Hoteles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.examen.demo.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.examen.demo.service.HotelesService;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService reservasService;
    @Autowired
    private HotelesService hotelesService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var reserva = reservasService.getReservas(false);
        var hotel = hotelesService.getHoteles(false);
        model.addAttribute("reservas", reserva);
        model.addAttribute("totalreservas", reserva.size());
        model.addAttribute("hoteles", hotel);
        return "/pruebas/listado";
    }

    @GetMapping("/listado/{id}")
    public String listado(Model model, Hoteles hoteles) {
        var reserva = reservasService.getHoteles(hoteles).getReservas();
        var hotel = hotelesService.getHoteles(false);
        model.addAttribute("reservas", reserva);
        model.addAttribute("totalreservas", reserva.size());
        model.addAttribute("hoteles", hotel);
        return "/pruebas/listado";
    }

    //Los métodos siguientes son para la prueba de consultas ampliadas
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var reserva = reservasService.getProductos(false);
        model.addAttribute("reservas", reserva);
        return "/pruebas/listado2";
    }

    @PostMapping("/query1")
    public String consultaQuery1(@RequestParam(value = "precioInf") double reservaInf,
            @RequestParam(value = "reservaSup") double reservaSup, Model model) {
        var reserva = reservasService.findByPrecioBetweenOrderByDescripcion(reservaInf, reservaSup);
        model.addAttribute("reservas", reserva);
        model.addAttribute("reservaInf", reservaInf);
        model.addAttribute("reservaSup", reservaSup);
        return "/pruebas/listado2";
    }
}
