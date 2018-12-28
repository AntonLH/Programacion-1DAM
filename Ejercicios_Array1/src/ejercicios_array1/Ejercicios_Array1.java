/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_array1;

import java.util.Scanner;

/**
 *
 * @author admin1
 */
public class Ejercicios_Array1 {

    /**
     * @param args the command line arguments
     */
    final static int[] edad = new int [5];

    public static void main(String[] args) {
        int cont=0, edadmedia=0;
        while (cont<5){
            edad[cont]=leerEdad();
            cont++;
        }
        imprimirEdad(edad);
        calcularMedia(edad);
    }
    public static int leerEdad(){
        System.out.println("Introduce una edad entre 18 y 35 años: ");
        Scanner teclado=new Scanner(System.in);
        int edad=teclado.nextInt();
        if (edad>=18 && edad<=35){
            return edad;
        }
        return 0;
    }
    public static int calcularMedia(int [] edades){
        int total=0;
        for(int i=0;i<edades.length;i++){
            total+=edades[i];
        }
        return total;

    }
    public static void imprimirEdad(int [] edades){
        for(int i=0;i<edades.length;i++){
            int j=i+1;
            System.out.println("Edad número  "+j+": "+edades[i]);
        }       
        double totalmedia=calcularMedia(edad)/edades.length;
        System.out.println(totalmedia);
    }
}
