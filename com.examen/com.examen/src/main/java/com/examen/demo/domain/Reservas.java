/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idReserva;
    private String cliente_nombre;
    private int cnum_huespedes;
    private int hotel_id;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private String numero_cedula;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id", updatable = false)
    List<Hoteles> Hoteles;

    public Reservas() {
    }

}