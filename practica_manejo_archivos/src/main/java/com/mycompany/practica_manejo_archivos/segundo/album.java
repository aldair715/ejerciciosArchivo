/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.segundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP 8va Gen
 */
public class album implements Serializable{
    static final long serialVersionUID=42L;
    //creando atributos del album
    private String nombre;
    private String artista;
    private String formato;
    private List<Cancion> cancion;
    //creando metodo de inicio
    public album()
    {
       cancion=new ArrayList<>();
    }
    //creando metodo mostrar para mostrar 
    public void mostrarAlbum()
    {
        System.out.println("NOMBRE ALBUM:\t"+this.nombre);
        System.out.println("ARTISTA ALBUM:\t"+this.artista);
        System.out.println("FORMATO ALBUM:\t"+this.formato);
        if(cancion!=null)
        {
            for(Cancion can:cancion)
            {
                can.mostrarCancion();
            }
        }
    }
    public void añadirCancion(Cancion can)
    {
        this.cancion.add(can);
    }
    //getter and setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<Cancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<Cancion> cancion) {
        this.cancion = cancion;
    }
    
    
}
