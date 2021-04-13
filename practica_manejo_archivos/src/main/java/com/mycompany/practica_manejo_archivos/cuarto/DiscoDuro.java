/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.cuarto;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP 8va Gen
 */
public class DiscoDuro  extends DispositivoAlmacenamiento{
    static final long serialVersionUID=42L;
    private String tipoInterfaz;
    private List<Archivo> ListaArchivo;
    //hacemos heredacion de la clase padre
    //
    public DiscoDuro()
    {
        ListaArchivo=new ArrayList<>();
    }
    
    //mostrar
    @Override
    public void mostrar()
    {
        super.mostrar();
        System.out.println("COLOQUE EL TIPO DE INTERFAZ DEL DISCO DURO:\t"+this.tipoInterfaz);
    }
    //getter and setter

    public String getTipoInterfaz() {
        return tipoInterfaz;
    }

    public void setTipoInterfaz(String tipoInterfaz) {
        this.tipoInterfaz = tipoInterfaz;
    }

    public List<Archivo> getListaArchivo() {
        return ListaArchivo;
    }

    public void setListaArchivo(List<Archivo> ListaArchivo) {
        this.ListaArchivo = ListaArchivo;
    }
    
}
