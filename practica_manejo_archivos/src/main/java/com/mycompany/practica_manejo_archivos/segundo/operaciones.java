/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.segundo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP 8va Gen
 */
public class operaciones {
    List<album> listaAlbum;

    private album alb;

    Scanner leer=new Scanner(System.in);
    public operaciones()
    {
    
        listaAlbum=new ArrayList<>();
        
    }
    public void crearFile()
    {
        String ruta="C:\\programacion";
        Path path=Paths.get(ruta);
        try{
            if(!Files.exists(path))
            {
                Files.createDirectories(path);
            }
           
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }
    }
    public void crearArchivo()
    {
        String ruta="C:\\programacion\\dos.txt";
        Path path=Paths.get(ruta);
        try{
            if(!Files.exists(path))
            {
                Files.createFile(path);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void guardarObjeto()
    {
        crearFile();
        crearArchivo();
        String ruta="C:\\programacion\\dos.txt";
    
        try{
          
            FileOutputStream file=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(file);
            oos.writeObject(listaAlbum);
            oos.close();
            file.close();
        }
         catch(FileNotFoundException ex)
        {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE,null,ex);
        } catch (IOException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void leerArchivo()
    {
        crearFile();
        crearArchivo();
        String ruta="C:\\programacion\\dos.txt";
        try{
            FileInputStream file=new FileInputStream(ruta);
            ObjectInputStream ios=new ObjectInputStream(file);
            if(ios!=null)
            {
                listaAlbum=(List<album>)ios.readObject();
               
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El archivo esta vacio");
            }
        }
        catch(FileNotFoundException e)
        {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null,e);

        } catch (IOException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void crearAlbum()
    {
        alb=new album();
        try{
            
            System.out.println("---------CREANDO ALBUM--------");
            System.out.println("1.- COLOQUE EL NOMBRE DEL ALBUM");
            alb.setNombre(leer.nextLine());
            System.out.println("2.- COLOQUE EL/LA ARTISTA DEL ALBUM");
            alb.setArtista(leer.nextLine());
            System.out.println("3.- COLOQUE EL FORMATO DEL ALBUM");
            alb.setFormato(leer.nextLine());
            String question="S";
            System.out.println("AÑADA TODAS LAS CANCIONES QUE QUIERA");
            while(question.equalsIgnoreCase("S"))
            {
                Cancion can=crearCancion();
                alb.getCancion().add(can);
             
                System.out.println("¿¿¿QUIERE COLOCAR CANCIONES EN EL ALBUM????? S/N");
                question=leer.nextLine();
            }
            
            listaAlbum.add(alb);
            guardarObjeto();
        }catch(Exception error)
        {
            System.out.println("Error:"+error);
        }
    }
    //se creara el metodo creacion de cancion, se añade directamente al metodod crearAlbum
    public Cancion crearCancion()
    {
        try{
            Cancion can=new Cancion();
            System.out.println("------------------CREANDO CANCION-----------");
            System.out.println("1.-COLOQUE EL NOMBRE DE LA CANCION");
            can.setNombreCancion(leer.nextLine());
            System.out.println("2.-COLOQUE LA DURACION DE LA CANCION");
            can.setDuracion(leer.nextFloat());
            leer.nextLine();
            System.out.println("3.-COLOQUE EL GENERO DE LA CANCION");
            can.setGenero(leer.nextLine());
            return can;
        }catch(Exception error)
        {
            return null;
        }
    }
    //buscar por cancion y mostrar cancion, nombre del album, nombre del artista
    public void buscarCancion(String cad)
    {
        leerArchivo();
        boolean p=false;
        try{
            for(album al:listaAlbum)
            {
               
                for(Cancion can:al.getCancion())
                {
                    if(can.getNombreCancion().equals(cad))
                    {
                        p=true;
                        System.out.println("NOMBRE DEL ALBUM:\t"+al.getNombre());
                        System.out.println("NOMBRE ARTISTA:\t"+al.getArtista());
                        System.out.println("NOMBRE CANCION:\t"+cad);
                    }
                }
            }
            if(p==false)
            {
                System.out.println("CANCION NO ENCONTRADA");
            }
            
        }
        catch(Exception e)
        {
            System.out.println("ERRROR:"+e);
        }
    }
    //mostrar todas las canciones de un album
    public void mostrarCanciones(String cad)
    {
        leerArchivo();
        
        boolean p=false;
        try{
            if(listaAlbum!=null)
            {
                
                for(album al:listaAlbum)
                {
                    
                    if(al.getNombre().equalsIgnoreCase(cad))
                    {
                        p=true;
                       
                        System.out.println("**************CANCIONES DEL ALBUM**************");
                        for(Cancion can:al.getCancion())
                        {
                            can.mostrarCancion();
                        }
                    }
                }
                if(p==false)
                {
                    System.out.println("ALBUM NO ENCONTRADO");
                }
            }
            else{
                System.out.println("LISTA DE ALBUMS ESTA VACIA");
            }
        }catch(Exception error)
        {
            
        }
    }
    //eliminar un determinado album
    public void eliminarAlbum(String cad)
    {
        leerArchivo();
        album paraRemover=new album();
        boolean p=false;
        try{
            if(listaAlbum!=null)
            {
                for(album al:listaAlbum)
                {
                    if(al.getNombre().equalsIgnoreCase(cad))
                    {
                        System.out.println("ALBUM ENCONTRADO, SEGURO QUIERE ELIMINARLO S/N ?????");
                        String opcion=leer.nextLine();
                        if(opcion.equalsIgnoreCase("S"))
                        {
                            paraRemover=al;
                            p=true;
                        }
                        else{
                            System.out.println("ALBUM NO ELIMINADO  ");
                        }
                    }
                }
                
                if(p==false)
                {
                    System.out.println("ALBUM NO ENCONTRADO");
                }
                else{
                    listaAlbum.remove(paraRemover);
                    guardarObjeto();
                }
            }
            else{
                System.out.println("LISTA DE ALBUMS ESTA VACIA");
            }
        }catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
    }
    //añadir una cancion a un album
    public void añadirCancion(String cad)
    {
        leerArchivo();
        boolean p=false;
        try{
            if(listaAlbum!=null)
            {
                for(album al:listaAlbum)
                {
                    if(al.getNombre().equalsIgnoreCase(cad))
                    {
                        System.out.println("ALBUM ENCONTRADO, SEGURO QUIERE AÑADIR CANCION S/N ?????");
                        String opcion=leer.nextLine();
                        if(opcion.equalsIgnoreCase("S"))
                        {
                            Cancion can=crearCancion();
                            al.getCancion().add(can);
                            p=true;
                            
                        }
                        else{
                            System.out.println("ALBUM NO ELIMINADO  ");
                        }
                    }
                }
                
                if(p==false)
                {
                    System.out.println("ALBUM NO ENCONTRADO");
                }
                else
                {
                    guardarObjeto();
                }
            }
            else{
                System.out.println("LISTA DE ALBUMS ESTA VACIA");
            }
        }catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
    }
    
}
