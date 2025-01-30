/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad2;

import java.util.Scanner;

/**
 *
 * @author 52562
 */
public class Actividad2 {
  
    public static void main(String[] args) {
        try ( 
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingresa tu nombre: ");
            String nombre = scanner.nextLine().toLowerCase(); 
            switch (nombre) {
                case "joel" -> System.out.println(" Hola, Joel! Bienvenido al programa.");
                case "ana" -> System.out.println(" Hola, Ana! Espero que tengas un buen día.");
                case "hector" -> System.out.println(" Hola, Hector! Por favor ingresa tu contarseña.");
                case "carlos" -> System.out.println(" Hola, Carlos! Qué gusto verte por aquí."); 
                default -> System.out.println("Hola, " + nombre + ". No te tengo registrado, pero bienvenido.");
            }   
            int[] numerosPares = new int[50]; 
            int numero = 2, indice = 0;
            while (numero <= 100) {
                numerosPares[indice] = numero;
                numero += 2;
                indice++;
            }
            System.out.println("Lista de numeros pares del 2 al 100:");
            indice = 0;
            while (indice < numerosPares.length) {
                System.out.print(numerosPares[indice] + " ");
                indice++;
            }
        }
    }
}


   

  