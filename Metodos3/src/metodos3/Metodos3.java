/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos3;

import java.util.Scanner;

public class Metodos3 {

    public static void main(String[] args) {
        System.out.println("Introduce un número");
        Scanner teclado=new Scanner(System.in);
        int n1=teclado.nextInt();
        int n2=teclado.nextInt();

        int a=esMayor(n1,n2);
        if (a==1){
            System.out.println("n1 es mayor");
        }
        else if(a==2) {
            System.out.println("n2 es mayor");
        }
        else if (a==3){
            System.out.println("Son iguales");
        }
        
    }
    public static int esMayor(int n1, int n2){
        if (n1<n2){
            return 2;
        }
        else if (n2<n1){
            return 1;
        }
        else {
            return 3;
        }
    }
}