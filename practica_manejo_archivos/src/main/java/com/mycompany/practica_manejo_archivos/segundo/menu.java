/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica_manejo_archivos.segundo;

import java.util.Scanner;

/**
 *
 * @author HP 8va Gen
 */
public class menu {

    public static void main(String[] args) {
        int N;
        String cad;
        Scanner leer = new Scanner(System.in);
        operaciones oper = new operaciones();
        boolean p = true;
        try {
            while (p == true) {
                System.out.println("***************************MENU ALBUM********************");
                System.out.println("1.CREAR ALBUM");
                System.out.println("2.AÑADIR CANCION A UN DETERMINADO ALBUM");
                System.out.println("3.BUSCAR CANCION");
                System.out.println("4.MOSTRAR CANCIONES DE UN DETERMINADO ALBUM");
                System.out.println("5.ELIMINAR ALBUM");
                System.out.println("6.SALIR");
                N = leer.nextInt();
                leer.nextLine();
                switch (N) {
                    case 1:
                        oper.crearAlbum();
                        break;
                    case 2:
                        System.out.println("COLOQUE EL NOMBRE DE LA CANCION A BUSCAR");
                        cad = leer.nextLine();
                        oper.añadirCancion(cad);
                        break;
                    case 3:

                        System.out.println("COLOQUE EL NOMBRE DE LA CANCION A BUSCAR");
                        cad = leer.nextLine();
                        oper.buscarCancion(cad);
                        break;
                    case 4:

                        System.out.println("COLOQUE EL NOMBRE DEL ALBUM EN EL CUAL DESEA VER LAS CANCIONES");
                        cad = leer.nextLine();
                        oper.mostrarCanciones(cad);
                        break;
                    case 5:

                        System.out.println("COLOQUE EL NOMBRE DEL ALBUM EL CUAL VA A ELIMINAR");
                        cad = leer.nextLine();
                        oper.eliminarAlbum(cad);
                        break;
                    case 6:
                        oper.leerArchivo();
                        break;
                    case 7:

                        break;
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR:" + error);
        }

    }
}
