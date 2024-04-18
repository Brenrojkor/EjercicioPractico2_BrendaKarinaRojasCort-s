/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long numero_cedula;
    private Long cliente_nombre;
    private int num_clientes;
    private double fecha_ingreso;
    private int fecha_salida;

    public Reservas() {
    }

    public Reservas(Long numero_cedula, Long cliente_nombre, double fecha_ingreso, int num_clientes) {
        this.numero_cedula = numero_cedula;
        this.cliente_nombre = cliente_nombre;
        this.fecha_ingreso = fecha_ingreso;
        this.num_clientes = num_clientes;
    }
}

