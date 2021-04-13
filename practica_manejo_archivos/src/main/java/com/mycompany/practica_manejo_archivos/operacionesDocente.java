/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos;


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

/**
 *
 * @author HP 8va Gen
 */
public class operacionesDocente {
    private Docente docente;
    private Materia materia;
    List<Materia> temporal;
    int S=0;
    Scanner leer=new Scanner(System.in);
    public operacionesDocente()
    {
        temporal=new ArrayList<>();
    }
    //vamos a crear un archivo file 
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
            System.out.println("Error:"+error);
        }
    }
    //metodo de cracion de archivo
    public void crearArchivo()
    {
        String ruta="C:\\programacion\\uno.txt";
        Path path=Paths.get(ruta);
        try{
            if(!Files.exists(path))
            {
                Files.createFile(path);
            }
        }
        catch(Exception e)
        {
             System.out.println("Error"+e);
        }
    }
    //guardar en archivo
    public void guardarObjeto()
    {
        crearFile();
        crearArchivo();
        String ruta="C:\\programacion\\uno.txt";
        try{
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(docente);
            oos.close();
            archivo.close();
        }
         catch(FileNotFoundException ex)
        {
            Logger.getLogger(operacionesDocente.class.getName()).log(Level.SEVERE,null,ex);
        } catch (IOException ex) {
            Logger.getLogger(operacionesDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //leer en archivo
    public void leerArchivo()
    {
        crearFile();
        crearArchivo();
        String ruta="C:\\programacion\\uno.txt";
        try{
            
            FileInputStream file=new FileInputStream(ruta);
            ObjectInputStream ios=new ObjectInputStream(file);
            if(ios!=null)
            {
                docente=(Docente)ios.readObject();
            }
            else
            {
                System.out.println("ARCHIVO VACIO");
            }
            
        }
        catch(FileNotFoundException e)
        {
            Logger.getLogger(operacionesDocente.class.getName()).log(Level.SEVERE, null,e);

        } catch (IOException ex) {
            Logger.getLogger(operacionesDocente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(operacionesDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //añadiendo a la clase docente
    public void añadirDocente()
    {
        docente=new Docente();
       try{
             System.out.println("1.---------------DATOS PERSONALES--------------------");
            System.out.println("1.1. ESCRIBA EL O LOS NOMBRES DEL DOCENTE");
            docente.setNombre(leer.nextLine());
            System.out.println("1.2. ESCRIBA EL APELLIDO PATERNO DEL DOCENTE");
            docente.setPaterno(leer.nextLine());
            System.out.println("2.1. ESCRIBA EL APELLIDO MATERNO DEL DOCENTE");
            docente.setMaterno(leer.nextLine());
            System.out.println("----------------------------------------------------");
            System.out.println("2.--------------------DATOS ACADEMICOS-------------");
            System.out.println("2.1. ESCRIBA EL TITULO DE LA PERSONA");
            docente.setTitulo(leer.nextLine());
            int t;
            do
            {
                System.out.println("3.-------------------------HORARIO--------------------------");
                System.out.println("3.1. ESCRIBA LA CARGA HORARIA DEL DOCENTE");
                t=leer.nextInt();
            }while(t<=0 );
            docente.setCargaHorario(t);
            guardarObjeto();
            leer.nextLine();
       }catch(Exception error)
       {
           System.out.println("ERROR:"+error);
       }
        
    }
    public void mostrarDocente()
    {
        leerArchivo();
        if(docente!=null)
        {
            
            docente.mostrarDocente();
        }
        else
        {
            System.out.println("no hay docentes añadidos");
        }
    }
    //metodos de la clase Materia y envio de la datos a la clase Materia
   
    public void añadirMateria()
    {
        materia=new Materia();
        leerArchivo();
        try{
            System.out.println("1.----------------------DATOS MATERIA----------------");
            System.out.println("1.1.ESCRIBA EL NOMBRE DE LA MATERIA");
            materia.setNombreMateria(leer.nextLine());
            int t,t1;
            do
            {
                System.out.println("1.2. ESCRIBA EL AÑO DE LA MATERIA");
                t=leer.nextInt();
            }while(t<=2000 || t>=2100);
            boolean p;
            if(S>=docente.getCargaHorario())
            {
                System.out.println("No hay mas espacio");
            }
            else
            {
                do
                {
                    System.out.println("1.3. ESCRIBA LAS HORAS QUE DURA LA MATERIA");
                    t1=leer.nextInt();
                    S=S+t1;
                    p=calcularCargaHoraria(S);
                    if(p==false)
                    {
                       S=S-t1; 
                    }



                }while(t1<=0 || p==false);
                S=S+t1; 
                materia.setAñoMateria(t);
                materia.setHoraMateria(t1);
                temporal.add(materia);
                System.out.println("MATERIA AÑADIDA A LISTA TEMPORAL NO SE OLVIDE GUARDARLOS");

            }
        }
        catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
        
        
        
       
        leer.nextLine();
        
    }
    public void mostrarMateriaAsignadas()
    {
        leerArchivo();
        if(docente.getListaMateria()!=null)
        {
            
            for(Materia t: docente.getListaMateria())
            {
                t.mostrarMateria();
                System.out.println("\t");
            }
            
        }
        else
        {
             System.out.println("TODAVIA NO ASIGNO MATERIA");
        }
    }
    public void aceptacion(){
        
        //try{
            if(docente!=null && temporal.size()>0)
            {
                
                for(Materia mat:temporal)
                {
                    
                    docente.getListaMateria().add(mat);
                }
                
                guardarObjeto();
                temporal.clear();
                System.out.println("ELEMENTOS ASIGNADOS, LISTA TEMPORAL LIMPIADO");

            }
            else{
                System.out.println("LISTA DE MATERIAS NO ASIGNADAS VACIA");
            }
        /*}
        catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
       */
    }
    public void mostrarNoAsignados()
    {
        try{
            if(!temporal.isEmpty())
            {
                for(Materia mat:temporal)
                {
                    mat.mostrarMateria();
                }
            }
            else{
                System.out.println("LISTA TEMPORAL VACIA");
            }
        }catch(Exception error)
        {
            System.out.println("ERROR:"+error);
        }
    }
    public boolean verificarAsignarMateriaAlDocente()
    {
        
        if(docente!=null && docente.getListaMateria()!=null)
        {
           
            return true;
        }
        else
        {
            
            return false;
        }
    }
  
    public boolean calcularCargaHoraria(int t1)
    {
        if(docente!=null)
        {
            if(t1<=(docente.getCargaHorario()))
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
    public void calculo()
    {
        if(calcularCargaHoraria(S))
        {
            System.out.println("Todavia queda espacio de"+(docente.getCargaHorario()-S));
        }
        else
        {
            System.out.println("No hay espacio o no añadio un docente");
        }
    }
}
