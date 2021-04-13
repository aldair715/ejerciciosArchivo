/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.cuarto;

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
    private DiscoDuro disco;
    private Archivo archivo;
    Scanner leer=new Scanner(System.in);
    public operaciones()
    {
       disco=new DiscoDuro();
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
        String ruta="C:\\programacion\\bd.txt";
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
        String ruta="C:\\programacion\\bd.txt";
        try{
            FileOutputStream file=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(file);
            oos.writeObject(disco);
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
        String ruta="C:\\programacion\\bd.txt";
        try{
            FileInputStream file=new FileInputStream(ruta);
            ObjectInputStream ios=new ObjectInputStream(file);
            if(ios!=null)
            {
                disco=(DiscoDuro)ios.readObject();
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
    public void añadirDiscoDuro()
    {
        disco=new DiscoDuro();
        try{
            System.out.println("**********************REGISTRO DE DISCO DURO********************");    
            System.out.println("1. COLOQUE LA MARCA DEL DISPOSITIVO");
            disco.setMarca(leer.nextLine());
            do
            {
              System.out.println("2. COLOQUE LA CAPACIDAD DEL DISPOSITIVO");
              disco.setCapacidad(leer.nextDouble());
            }while(disco.getCapacidad()<=0);
            do{
                System.out.println("3. COLOQUE EL ESPACIO DISPONIBLE DEL DISPOSITIVO");
                disco.setEspacioDisponible(leer.nextDouble());
            }while(disco.getEspacioDisponible()<=0 && disco.getEspacioDisponible()>disco.getCapacidad());
            leer.nextLine();
            System.out.println("4. COLOQUE EL ITPO DE INTERFAZ DEL DISPOSITIVO");
            disco.setTipoInterfaz(leer.nextLine());
            guardarObjeto();
        }catch(Exception error)
        {
            System.out.println("Error"+error);
        }
           
        
    }
    public void añadirArchivo()
    {
        leerArchivo();
        archivo=new Archivo();
        try{
            if(disco!=null)
            {
                double estas;
                System.out.println("--------------------------------REGISTRO DE ARCHIVO---------------");
                System.out.println("1.COLOQUE EL NOMBRE DE ARCHIVO");
                archivo.setNombreArchivo(leer.nextLine());
                
                    System.out.println("2.TAMAÑO DEL TAMAÑO DE ARCHIVO");
                    estas=leer.nextDouble();
                    System.out.println(estas);
                    leer.nextLine();
               
               double ver=disco.getEspacioDisponible()-estas;
               if(ver>=0 && estas>0)
               {
                   archivo.setTamañoArchivo(estas);
                    double esp=disco.getEspacioDisponible();
                    disco.setEspacioDisponible(esp-archivo.getTamañoArchivo());
                    disco.getListaArchivo().add(archivo);
                    guardarObjeto();
               }
               else
               {
                   System.out.println("NO HAY SUFICIENTE ESPACIO");
               }
                
            }
        }catch(Exception error)
        {System.out.println("Error:"+error);}
    }
    //metodo para verificar
    public boolean verificarEspacio(Double espacio)
    {
      
        if(disco!=null)
        {
            Double espacioPermitido=disco.getCapacidad();
            Double espacioDisponible=disco.getEspacioDisponible()-espacio;
            System.out.println(espacioDisponible);
            if(espacioDisponible>=0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    //1 metodo
    public void añadirVariosOunArchivo()
    {
        leerArchivo();
        try{
            System.out.println("QUIERE COLOCAR ARCHIVOS S/N");
            String opcion=leer.nextLine();
            while(opcion.equalsIgnoreCase("S"))
            {
                añadirArchivo();
                 System.out.println("QUIERE COLOCAR ARCHIVOS S/N");
                opcion=leer.nextLine();
            }
        }
        catch(Exception error){System.out.println("Error:"+error);}
    }
    //2 metodo
    public void listarArchivo()
    {
        leerArchivo();
        try{
            if(disco!=null)
            {
                System.out.println(disco.getCapacidad());
                System.out.println(disco.getEspacioDisponible());
                for(Archivo arch:disco.getListaArchivo())
                {
                    arch.mostrar();
                }
            }
        }catch(Exception e)
        {
            System.out.println("ERROR:"+e);
        }
    }
    //3 metodo
    public void eliminarArchivo(String cad)
    {
        leerArchivo();
        Archivo archElim=new Archivo();
        boolean p=false;
        try{
            if(disco!=null)
            {
                for(Archivo arch:disco.getListaArchivo())
                {
                    if(arch.getNombreArchivo().equalsIgnoreCase(cad))
                    {
                        p=true;
                        double esp=disco.getEspacioDisponible();
                        disco.setEspacioDisponible(esp+arch.getTamañoArchivo());
                        archElim=arch;
                        break;
                        
                        
                    }
                }
                
                if(p==false)
                {
                    System.out.println("NO SE ENCUENTRA EL ARCHIVO");
                }
                else{
                    disco.getListaArchivo().remove(archElim);
                    guardarObjeto();
                }
            }
        }catch(Exception error){System.out.println("Error:"+error);}
    }
}
