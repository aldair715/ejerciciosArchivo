/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.tercero;

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
    List<Hospital> ListaHospital;
    private Hospital hospital;
    private Especialidad especialidad;
    
    Scanner leer=new Scanner(System.in);
    public operaciones()
    {
        ListaHospital=new ArrayList<>();
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
        String ruta="C:\\programacion\\tres.txt";
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
        String ruta="C:\\programacion\\tres.txt";
        try{
            FileOutputStream file=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(file);
            oos.writeObject(ListaHospital);
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
        String ruta="C:\\programacion\\tres.txt";
        try{
            FileInputStream file=new FileInputStream(ruta);
            ObjectInputStream ios=new ObjectInputStream(file);
            if(ios!=null)
            {
                ListaHospital=(List<Hospital>)ios.readObject();
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
    //registrar un hospital y agregar especialidades
    public void registrarHospital()
    {
        hospital=new Hospital();
        try{
            System.out.println("1.NOMBRE DEL HOSPITAL");
            hospital.setNombre(leer.nextLine());
            System.out.println("2.DIRECCION DEL HOSPITAL");
            hospital.setDireccion(leer.nextLine());
            do{
                System.out.println("3.NIVEL DEL HOSPITAL");
                hospital.setNivel(leer.nextInt());
            }while(hospital.getNivel()<=0);
            leer.nextLine();
            System.out.println("QUIERE COLOCAR ESPECIALIDADES S/N ????");
            String opcion=leer.nextLine();
            while(opcion.equalsIgnoreCase("S"))
            {
                Especialidad esp=añadirEspecialidad();
                hospital.adicionarEspecialidad(esp);System.out.println("QUIERE COLOCAR ESPECIALIDADES S/N ????");
                System.out.println("QUIERE COLOCAR ESPECIALIDADES S/N ????");
                opcion=leer.nextLine();
            }
            ListaHospital.add(hospital);
            guardarObjeto();
        }catch(Exception error){
            System.out.println("ERROR:"+error);
        }
    }
    //METODO DE RETORNO DE ESPECIALIDADES
    public Especialidad añadirEspecialidad()
    {
        especialidad=new Especialidad();
        try{
            System.out.println("COLOQUE EL NOMBRE DE LA ESPECIALIDAD");
            especialidad.setNomEspecialidad(leer.nextLine());
            return especialidad;
        }catch(Exception error){
            return null;
        }
    }
    //mostra especialidades de un hospital
    public void mostrarEspecialidades(String cad)
    {
        leerArchivo();
        try{
            if(ListaHospital!=null)
            {
                for(Hospital hos:ListaHospital)
                {
                    if(hos.getNombre().equalsIgnoreCase(cad))
                    {
                        System.out.println(hos.getNombre());
                        System.out.println(hos.getDireccion());
                        System.out.println(hos.getNivel());
                        for(Especialidad esp:hos.getEspecialidad())
                        {
                            System.out.println("*******************************");
                            esp.mostrarEspecialidad();
                            System.out.println("*******************************");
                        }
                    }
                }
            }
        }catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
    }
    //listar todos los hospitales por especialidad
    public void buscarEspecialidad(String cad)
    {
        leerArchivo();
        List <String> losHospitales=new ArrayList<>();
        boolean p=false;
        try{
            if(ListaHospital!=null)
            {
                for(Hospital hos:ListaHospital)
                {
                    
                        for(Especialidad esp:hos.getEspecialidad())
                        {
                            if(esp.getNomEspecialidad().equalsIgnoreCase(cad))
                            {
                                p=true;
                                losHospitales.add(hos.getNombre());
                            }
                        }
                    
                }
                if(p==false)
                {
                    System.out.println("NO EXITEN LA ESPECIALIDAD"+cad+"EN LA LISTA");
                }
                else{
                    System.out.println("LISTA DE HOSPITALES CON LA ESPECIALIDAD");
                    for(String cod:losHospitales)
                    {
                        System.out.println("HOSPITAL:\t"+cod);
                    }
                }
            }
        }catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
    }
    //metodo para añadir un especialidad
    public void añadirEspecialidad(String cad)
    {
        leerArchivo();
        boolean p=false;
        try{
            if(ListaHospital!=null)
            {
                for(Hospital hos:ListaHospital)
                {
                    if(hos.getNombre().equalsIgnoreCase(cad))
                    {
                        p=true;
                        Especialidad esp=añadirEspecialidad();
                        hos.getEspecialidad().add(esp);
                        guardarObjeto();
                    }
                    
                }
                if(p==false)
                {
                    System.out.println("NO EXITEN EL HOSPITAL"+cad+"EN LA LISTA");
                }
               
            }
        }catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
    }
}
