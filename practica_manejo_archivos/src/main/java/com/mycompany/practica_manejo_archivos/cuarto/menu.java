/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.cuarto;

import java.util.Scanner;

/**
 *
 * @author HP 8va Gen
 */
public class menu {
    public static void main(String[] args) {
        int N;
        boolean p=false;
        Scanner leer=new Scanner(System.in);
        operaciones oper=new operaciones();
        try{
            while(p==false)
            {
                System.out.println("*************INGRESE DISCO DURO*********************");
                System.out.println("1.AÑADIR DISCO DURO");
                System.out.println("2.AÑADIR ARCHIVO O ARCHIVOS AL DISCO DURO");
                System.out.println("3.LISTAR LOS ARCHIVOS DEL DISCO DURO");
                System.out.println("4.ELIMINAR ARCHIVO EN DISCO DURO");
                System.out.println("5.SALIR");
                N=leer.nextInt();
                switch(N)
                {
                    case 1:
                        oper.añadirDiscoDuro();
                    break;
                    case 2:
                        oper.añadirVariosOunArchivo();
                    break;
                    case 3:
                        oper.listarArchivo();
                    break;
                    case 4:
                        leer.nextLine();
                        System.out.println("COLOQUE EL NOMBRE DEL ARCHIVO A ELIMINAR");
                        String cad=leer.nextLine();
                        oper.eliminarArchivo(cad);
                    break;
                    default:
                        p=true;
                    break;
                }
            }
        }
        catch(Exception error)
        {
            
        }
    }
}
