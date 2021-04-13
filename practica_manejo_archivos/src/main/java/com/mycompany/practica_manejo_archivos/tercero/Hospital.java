/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.tercero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP 8va Gen
 */
public class Hospital implements Serializable{
    static final long serialVersionUID=42L;
    //creando atributos
    private String nombre;
    private String direccion;
    private int nivel;
    private List<Especialidad> especialidad;
    //creando y conectando con el hospital
    public Hospital()
    {
        especialidad=new ArrayList<>();
    }
    //creando metodo mostrar
    public void mostrar()
    {
        System.out.println("NOMBRE HOSPITAL:\t"+this.nombre);
        System.out.println("DIRECCION HOSPITAL: \t"+this.direccion);
        System.out.println("NIVEL: \t"+this.nivel);
        if(especialidad!=null)
        {
            for(Especialidad esp:especialidad)
            {
                esp.mostrarEspecialidad();
            }
        }
    }
    //creando metodo para adicionar especialidad
    public void adicionarEspecialidad(Especialidad espe){
        especialidad.add(espe);
        System.out.println("ESPECIALIDAD AGREGADA");
    }
    //crear getter and setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(List<Especialidad> especialidad) {
        this.especialidad = especialidad;
    }
    
}
