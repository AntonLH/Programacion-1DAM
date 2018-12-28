/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos19;

import java.util.Scanner;

/**
 *
 * @author admin1
 */
public class Metodos19 {

    /**
     * @param args the command line arguments
     */
    static final double pi = 3.14;
    
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int m,c;
        double radio;
        System.out.println("Introduce un lado: ");
        m=teclado.nextInt();
        System.out.println("Introduce otro lado: ");
        c=teclado.nextInt();
        System.out.println("Introduce radio: ");
        radio=teclado.nextInt();
        int a=area(m,c);
            System.out.println(a+" area");
        int b=longitud(m,c);
            System.out.println(b+" longitud");
        System.out.println(area_circulo(radio)+"");
        System.out.println(longitud_circulo(radio)+"");
            
    }    
    public static int area(int lado1,int lado2){
        int area=lado1*lado2;
        return area;
    
    }
    public static double area(double lado1,double lado2){
        double area=lado1*lado2;
        return area;
    
    }
    public static int longitud(int lado1,int lado2){
        int longitud=lado1*2+lado2*2;
        return longitud;
    
    }
    public static double longitud(double lado1,double lado2){
        double longitud=lado1*2+lado2*2;
        return longitud;
    
    }

    public static double area_circulo(double radio){
        double area=pi*radio*radio;
        return area;
    
    }

    public static double longitud_circulo(double radio){
        double longitud=2*pi*radio;
        return longitud;
    
    }
}
