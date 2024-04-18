/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.demo.service;

import com.examen.demo.domain.Reservas;
import java.util.ArrayList;
import java.util.List;

public interface ReservasService {

    List<Reservas> listaReservas = new ArrayList<>();

    public List<Reservas> gets();

    //Se recupera el registro que tiene el idItem pasado porparámetro
    //si no existe en la tabla se retorna null
    public Reservas get(Reservas reservas);

    //Se elimina el registro que tiene el idItem pasado por parámetro
    public void delete(Reservas reservas);

     
    //Se elimina el registro que tiene el idItem pasado por parámetro

    //El registro de actualiza con la nueva información
    //Si el idItem NO existe en la tabla, se crea el registrocon esa información
    public void save(Reservas reservas);

    public void actualiza(Reservas reservas);

    public void facturar();
}
