/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.controller;

import com.examen.demo.domain.Usuarios;
import com.examen.demo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadosService empleadosService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var empleados = empleadosService.getEmpleados();
        model.addAttribute("empleados", empleados);
        model.addAttribute("totalempleados", empleados.size());
        return "/empleados/listado";
    }

    @GetMapping("/nuevo")
    public String EmpleadoNuevo(Empleados empleado) {
        return "/empleados/modifica";
    }

    

    @PostMapping("/guardar")
    public String usuarioGuardar(Usuarios usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            EmpleadosService.save(empleado,false);        
                    }            
       
    
        EmpleadosService.save(usuario,true);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String empleadoEliminar(Empleados empleado) {
        EmpleadosService.delete(empleados);
        return "redirect:/empleado/listado";
    }

    @GetMapping("/modificar/{id}")
    public String empleadoModificar(Empleados empleados, Model model) {
        model.addAttribute("empleados", empleados);
        return "/empleados/modifica";
    }
}
