/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.cuarto;

import java.io.Serializable;

/**
 *
 * @author HP 8va Gen
 */
public class Archivo implements Serializable{
    static final long serialVersionUID=41L;
    private String nombreArchivo;
    private double tamañoArchivo;
    //crear para mostrar
    public void mostrar()
    {
        System.out.println("NOMBRE ARCHIVO:\t"+this.nombreArchivo);
        System.out.println("TAMAÑO ARCHIVO:\t"+this.tamañoArchivo);
    }
    //getter and setter

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public double getTamañoArchivo() {
        return tamañoArchivo;
    }

    public void setTamañoArchivo(double tamañoArchivo) {
        this.tamañoArchivo = tamañoArchivo;
    }
    
}
