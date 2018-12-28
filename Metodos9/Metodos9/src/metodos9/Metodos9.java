/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos9;
import java.util.Scanner;
/**
 *
 * @author admin1
 */
public class Metodos9 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int n;
        do{
        System.out.println("Introduce un año: ");
        n=teclado.nextInt();
        boolean bisiesto=esBisiesto(n);
        if (bisiesto==true){
            System.out.println("Es bisiesto.");
        }
        else {   
            System.out.println("No es bisiesto.");
        }
        
    }while (n!=0);
    }
    public static boolean esBisiesto(double num){
        if (((num%4==0)&&(num%100!=0))||(num%400==0)){
            return true;
        }
        else{
            return false;
        }
    }
}
