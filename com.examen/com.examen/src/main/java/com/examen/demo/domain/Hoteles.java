/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "hoteles")
public class Hoteles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hoteles")
    private Long id;
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_hoteles", updatable = false)
    List<Reservas> reservas;

    public Hoteles() {
    }

    public Hoteles(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}