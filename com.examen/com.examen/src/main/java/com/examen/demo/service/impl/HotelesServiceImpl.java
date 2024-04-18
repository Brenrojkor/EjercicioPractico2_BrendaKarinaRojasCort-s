/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.service.impl;

import com.examen.demo.domain.Hoteles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.examen.demo.dao.HotelesDao;
import com.examen.demo.service.HotelesService;

@Service
public class HotelesServiceImpl implements HotelesService {

     @Autowired
    private HotelesDao hotelesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Hoteles> getHoteles(boolean activos) {
        var lista =hotelesDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Hoteles getHoteles(Hoteles hoteles) {
        return hotelesDao.findById(hoteles.getId()).orElse(null);
    }  

    
    
}