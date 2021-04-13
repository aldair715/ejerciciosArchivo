/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.segundo;

import java.io.Serializable;

/**
 *
 * @author HP 8va Gen
 */
public class Cancion implements Serializable{
    static final long serialVersionUID=43L;
    //creando archivos y canciones
    private String nombreCancion;
    private float duracion;
    private String genero;
    //creando el metodo 
    public void mostrarCancion()
    {
        System.out.println("NOMBRE CANCION:\t"+this.nombreCancion);
        System.out.println("DURACION:\t"+this.duracion);
        System.out.println("GENERO:\t"+this.genero);
    }
    //construyendo los gettern and setter

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
