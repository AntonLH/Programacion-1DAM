/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos13;

import java.util.Scanner;

/**
 *
 * @author admin1
 */
public class Metodos13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int m,c,mi;
        System.out.println("Introduce metros: ");
        m=teclado.nextInt();
        System.out.println("Introduce centimetros: ");
        c=teclado.nextInt();
        System.out.println("Introduce milimetros: ");
        mi=teclado.nextInt();
        int a=cifras(m,c,mi);
            System.out.println(a+" milimetros");
    }    
    public static int cifras(int metros, int centimetros,int milimetros){
        milimetros+=metros*1000;
        milimetros+=centimetros*10;
        return milimetros;
    }
    
}
