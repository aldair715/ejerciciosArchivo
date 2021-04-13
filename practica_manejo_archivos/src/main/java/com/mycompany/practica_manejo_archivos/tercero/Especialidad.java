/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.tercero;

import java.io.Serializable;

/**
 *
 * @author HP 8va Gen
 */
public class Especialidad implements Serializable{
    static final long serialVersionUID=43L;
    //creando atributos
    private String nomEspecialidad;
    //creando metodos 
    public void mostrarEspecialidad()
    {
        System.out.println("NOMBRE DE ESPECIALIDAD \t"+this.nomEspecialidad);
    }
    //creando metodo para agregar una especialidad
    
    //creando los getter and setter

    public String getNomEspecialidad() {
        return nomEspecialidad;
    }

    public void setNomEspecialidad(String nomEspecialidad) {
        this.nomEspecialidad = nomEspecialidad;
    }
    
    
}
