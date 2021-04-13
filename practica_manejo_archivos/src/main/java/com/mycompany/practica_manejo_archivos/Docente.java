/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author HP 8va Gen
 */
public class Docente implements Serializable{
    //creamos atributos de docentes
     static final long serialVersionUID=42L;
    private String nombre;
    private String paterno;
    private String materno;
    private String titulo;
    private int cargaHorario;
    private List<Materia> listaMateria;
    //creamos los metodos
    public void mostrarDocente()
    {
        System.out.println("NOMBRE:\t"+nombre);
        System.out.println("APELLIDO PATERNO:\t"+paterno);
        System.out.println("APELLIDO MATERNO:\t"+materno);
        System.out.println("TITULO:\t"+titulo);
        System.out.println("CARGA HORARIO:\t"+cargaHorario);
        if(listaMateria!=null)
        {
            for(Materia mat:listaMateria)
            {
                mat.mostrarMateria();
                System.out.println("\t");
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(int cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    public List<Materia> getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }
    
    
}
