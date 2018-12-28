/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos18;

import java.util.Scanner;

/**
 *
 * @author admin1
 */
public class Metodos18 {

    /**
     * @param args the command line arguments
     */
    static         int num, num2=0, num1=0, num3;

    public static void main(String[] args) {
        System.out.println("introduce un numero: ");
        Scanner teclado=new Scanner(System.in);
        num=teclado.nextInt();
        num3=num;
        num2=esCapicua();
        System.out.println(num2);
        if (num3==num2){
            System.out.println("es capicua");
        }
        else{
            System.out.println("no es capicua");
        }
    }
    public static int esCapicua(){
        
        while (num!=0){
            num1=num%10;
            num2=num2*10+num1;
            num=num/10;
        }
        
        return num2;
    }
}

