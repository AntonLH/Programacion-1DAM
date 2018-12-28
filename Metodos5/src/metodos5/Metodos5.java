/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos5;

import java.util.Scanner;
import static metodos5.Metodos5.positivo;

/**
 *
 * @author admin1
 */
public class Metodos5 {

    /**
     * @param args the command line arguments
     */
    static int b, c, operacion;
    static boolean positivo;
    public static void main(String[] args) {
        int a=0;
        while (a!=5){
        a=menu();
        switch (a){
            case 1:suma();break;
            case 2:resta();break;
            case 3:multiplicacion();break;
            case 4:division();break;
            case 6:esPositivo();break;
        }
        }
    }
    
    public static void suma(){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Operación seleccionada: Suma");
        
        do{
        System.out.println("Introduce el primer número:");
        b=teclado.nextInt();            
        System.out.println("Introduce el segundo número:");
        c=teclado.nextInt();
        positivo=esPositivo();
        if (positivo==false){
            System.out.println("Introduce números positivos");
        }
        }while(positivo==false);
        operacion=b+c;
        System.out.println(b+"+"+c+" = "+operacion);

    }
    public static void resta(){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Operación seleccionada: Resta");
        do{
        System.out.println("Introduce el primer número:");
        b=teclado.nextInt();            
        System.out.println("Introduce el segundo número:");
        c=teclado.nextInt();
        positivo=esPositivo();
        if (positivo==false){
            System.out.println("Introduce números positivos");
        }
        }while(positivo==false);

        operacion=b-c;
        System.out.println(b+"-"+c+" = "+operacion);

    }
    public static void multiplicacion(){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Operación seleccionada: Producto");
        do{
        System.out.println("Introduce el primer número:");
        b=teclado.nextInt();            
        System.out.println("Introduce el segundo número:");
        c=teclado.nextInt();
        positivo=esPositivo();
        if (positivo==false){
            System.out.println("Introduce números positivos");
        }
        }while(positivo==false);
        operacion=b*c;
        System.out.println(b+"*"+c+" = "+operacion);

    }
    public static void division(){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Operación seleccionada: División");
        do{
        System.out.println("Introduce el primer número:");
        b=teclado.nextInt();            
        System.out.println("Introduce el segundo número:");
        c=teclado.nextInt();
        try{
            operacion=b/c;
        }
        catch (ArithmeticException e){
        System.out.println ("Error: No se puede dividir entre 0");
        return;
        }
        positivo=esPositivo();
        if (positivo==false){
            System.out.println("Introduce números positivos");
        }
        }while(positivo==false);
        
        System.out.println(b+"/"+c+" = "+operacion);

    }
    public static int menu(){
        int a;
        Scanner teclado=new Scanner(System.in);
        System.out.println("*****************");
        System.out.println("Calculadora");
        System.out.println("*****************");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Producto");
        System.out.println("4. División");
        System.out.println("5. Salir");
        System.out.println("6. Positivo");
        a=teclado.nextInt();
        return a;
  }
    public static boolean esPositivo(){
        if (b>0&&c>0){
            positivo=true;
        }
        else {
            positivo=false;
                    
        }
        return positivo;
    }
}