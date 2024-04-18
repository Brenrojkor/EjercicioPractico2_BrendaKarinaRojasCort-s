/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.demo.service;

import com.examen.demo.domain.Hoteles;
import java.util.List;

public interface HotelesService {
    
    public List<Hoteles> getHoteles(boolean activo);

    // Se obtiene un Hoteles, a partir del id de un categoria
    public Hoteles getHoteles(Hoteles hoteles);
    
}