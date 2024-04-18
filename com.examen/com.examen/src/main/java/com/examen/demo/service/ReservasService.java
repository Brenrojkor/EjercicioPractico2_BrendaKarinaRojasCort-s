/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.demo.service;

import com.examen.demo.domain.Reservas;
import java.util.List;

public interface ReservasService {
    
    public List<Reservas> getReservas(boolean activo);

    // Se obtiene un Categoria, a partir del id de un categoria
    public Reservas getReserva(Reservas reservas);
    
}

