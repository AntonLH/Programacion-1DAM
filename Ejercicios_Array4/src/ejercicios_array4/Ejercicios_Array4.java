/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_array4;

import java.util.Scanner;

/**
 *
 * @author admin1
 */
public class Ejercicios_Array4 {

    /**
     * @param args the command line arguments
     */
     static String[] arr_alumnos = new String [10];
    static int[] arr_notas = new int [10];
    static int[] arr_datos = new int [5];
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        arr_alumnos=cargarArrayNombres();
        arr_notas=cargarArrayAlumnos();
        mostrarTodosDatos(arr_alumnos, arr_notas);
        arr_datos=calculoDatos(arr_notas);
        mostrarEstadisticas(arr_alumnos, arr_datos);

    }
    public static String[] cargarArrayNombres(){
        int cont=0;
        Scanner teclado=new Scanner(System.in);
        while (cont<arr_alumnos.length){
            System.out.println("Introduce el nombre de un alumno: ");
            arr_alumnos[cont]=teclado.next();
            cont++;
        }
        return arr_alumnos;

    }
    public static int[] cargarArrayAlumnos(){
        int cont=0;
        while (cont<arr_alumnos.length){
            arr_notas[cont]=(int) (Math.random() * (11 +0));
            cont++;
        }
        return arr_notas;
    }
    public static void mostrarTodosDatos(String[] arr_alumnos, int[] arr_notas){
        for(int i=0;i<arr_alumnos.length;i++){
            int j=i+1;
            System.out.println("Nota del alumno "+arr_alumnos[i]+": "+arr_notas[i]);
        }

    }
    public static int[] calculoDatos(int[] arr_notas){
        int media=0, maxima=0, minima=10, alum_minima=0, alum_maxima=0;
        for(int i=0;i<arr_notas.length;i++){
            media=media+arr_notas[i];
            if (arr_notas[i]<=minima){
                minima=arr_notas[i];
                alum_maxima=i;
           }
            if (arr_notas[i]>=maxima){
                maxima=arr_notas[i];
                 alum_minima=i;
            }
        }
        media=media/arr_notas.length;
        arr_datos[0]=media;
        arr_datos[1]=minima;
        arr_datos[2]=maxima;
        arr_datos[3]=alum_minima;
        arr_datos[4]=alum_maxima;
        return arr_datos;
        }
    
    public static void mostrarEstadisticas(String[] arr_alumnos, int[] arr_datos){
        System.out.println("Media de la clase: "+arr_datos[0]);
        System.out.println("Maxima de la clase: "+arr_datos[2]+", la ha conseguido "+arr_alumnos[arr_datos[3]]);
        System.out.println("Minima de la clase: "+arr_datos[1]+", la ha conseguido "+arr_alumnos[arr_datos[4]]);
    }
}