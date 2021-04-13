/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos;

import java.io.Serializable;

/**
 *
 * @author HP 8va Gen
 */
public class Materia implements Serializable{
    //colocar atributos
     static final long serialVersionUID=43L;
    private String nombreMateria;
    private int añoMateria;
    private int horaMateria;
    //metodos
    public void mostrarMateria()
    {
        System.out.println("NOMBRE MATERIA:\t"+nombreMateria);
        System.out.println("AÑO DE LA MATERIA:\t"+añoMateria);
        System.out.println("HORARIO:\t"+horaMateria);
    }
    //getter and setter

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getAñoMateria() {
        return añoMateria;
    }

    public void setAñoMateria(int añoMateria) {
        this.añoMateria = añoMateria;
    }

    public int getHoraMateria() {
        return horaMateria;
    }

    public void setHoraMateria(int horaMateria) {
        this.horaMateria = horaMateria;
    }
    
}
