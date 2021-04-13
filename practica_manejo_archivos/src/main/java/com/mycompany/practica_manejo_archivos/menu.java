/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos;

import java.util.Scanner;

/**
 *
 * @author HP 8va Gen
 */
public class menu {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        operacionesDocente oper=new operacionesDocente();
        int N=0;
        boolean p=true;
        try{
             while(p==true)
            {
                System.out.println("**************************MENU***************************");
                System.out.println("1.Crear Docente");
                System.out.println("2.Crear Materia");
                System.out.println("3.Asignar Materia a Docente");
                System.out.println("4.Mostra Docente");
                System.out.println("5.Mostrar Materias asignadas");
                System.out.println("6.Mostrar Materias no Asignadas");
                System.out.println("7.SALIR");
                N=leer.nextInt();
                switch(N)
                {
                    case 1:
                        oper.añadirDocente();
                    break;
                    case 2:
                        oper.añadirMateria();
                    break;
                    case 3:
                        oper.aceptacion();

                    break;
                    case 4:
                      oper.mostrarDocente();
                    break;
                    case 5:
                        oper.mostrarMateriaAsignadas();
                    break;
                    case 6:
                        oper.mostrarNoAsignados();
                     break;
                    case 7:
                        oper.leerArchivo();
                    break;
                    default:
                        p=false;
                    break;
                }
            }
        }catch(Exception error)
        {
            System.out.println("ERROR : "+error);
        }
       
    }
}
