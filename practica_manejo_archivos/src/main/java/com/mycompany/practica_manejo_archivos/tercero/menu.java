/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.tercero;

import java.util.Scanner;

/**
 *
 * @author HP 8va Gen
 */
public class menu {
    public static void main(String[] args) {
        int N;
        boolean p=true;
        String cad;
        Scanner leer=new Scanner(System.in);
        operaciones oper=new operaciones();
        while(p==true)
        {
            System.out.println("----------------MENU------------------");
            System.out.println("1.REGISTRAR UN HOSPITAL");
            System.out.println("2.AGREGAR ESPECIALIDAD A UN HOSPITAL");
            System.out.println("3.MOSTRAR ESPECIALIDADES DE UN DETERMINADOD HOSPITAL");
            System.out.println("4.LISTAR HOSPITALES POR ESPECIALIDAD");
            System.out.println("5.SALIR");
            N=leer.nextInt();
            leer.nextLine();
            switch(N)
            {
                case 1:
                    oper.registrarHospital();
                break;
                case 2:
                    System.out.println("COLOQUE UN HOSPITAL PARA AGREGAR ESPECIALIDAD");
                    cad=leer.nextLine();
                    oper.añadirEspecialidad(cad);
                break;
                case 3:
                    System.out.println("COLOQUE UN HOSPITAL, PARA BUSCARLO");
                    cad=leer.nextLine();
                    oper.mostrarEspecialidades(cad);
                break;
                case 4:
                     System.out.println("COLOQUE UNA ESPECIALIDAD");
                    cad=leer.nextLine();
                    oper.buscarEspecialidad(cad);
                break;
            }
        }
    }
}
