/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.controller;

import com.examen.demo.domain.Reservas;
import com.examen.demo.domain.Hoteles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.examen.demo.service.ProductoService;
import com.examen.demo.service.ReservasService;

@Controller
public class ReservasController {

    @Autowired
    private ReservasService hotelesService;
    @Autowired
    private ProductoService registroService;

    @GetMapping("/")
    private String listado(Model model) {
        var reserva = registroService.getProductos(false);
        model.addAttribute("reserva", reserva);
        return "/index";
    }
 

    @GetMapping("/registro/listado")
    public String inicio(Model model) {
        var hotel = hotelesService.gets();
        model.addAttribute("hotel", hotel);
        var Totalreserva = 0;
        for (Item i :hotel) {
            Totalreserva += (i.getCantidad());
        }
        model.addAttribute("hotelTotal",
                Totalreserva);
        return "/registro/listado";
    }

    //Para Agregar un producto al carrito
    @GetMapping("/registro/agregar/{numero_cedula}")
    public ModelAndView agregaReserva(Model model, Item item) {
        reserva reserv = reservasService.get(item);
        if (item2 == null) {
            Producto producto = productoService.getProducto(item);
            item2 = new Item(producto);
        }
        itemService.save(item2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }
    
    //Para mofificar un producto del carrito

    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }
    
    //Para eliminar un elemento del carrito

    @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }
    
    //Para actualizar un producto del carrito (cantidad)

    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }
    
    //Para facturar los productos del carrito... no implementado...

    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }
}