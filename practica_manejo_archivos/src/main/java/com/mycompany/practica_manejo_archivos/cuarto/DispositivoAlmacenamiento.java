/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.cuarto;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author HP 8va Gen
 */
public class DispositivoAlmacenamiento implements Serializable{
    static final long serialVersionUID=43L;
    //definimos nuestros atributos
    private String marca;
    private double capacidad;
    private double espacioDisponible;
    
    //metodos de nuestro clase
    
    public void mostrar()
    {
        System.out.println("MARCA DEL DISPOSITIVO:\t"+this.marca);
        System.out.println("CAPACIDAD DEL DISPOSITIVO:\t"+this.capacidad);
        System.out.println("ESPACIO DISPONIBLE DEL DISPOSITIVO:\t"+this.espacioDisponible);
    }
    //getter and setters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getEspacioDisponible() {
        return espacioDisponible;
    }

    public void setEspacioDisponible(double espacioDisponible) {
        this.espacioDisponible = espacioDisponible;
    }

   
    
    
}
