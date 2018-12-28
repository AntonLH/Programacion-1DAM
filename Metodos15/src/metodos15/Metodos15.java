/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos15;
import java.util.Scanner;
/**
 *
 * @author admin1
 */
public class Metodos15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce la base: ");
        int base=teclado.nextInt();
        System.out.println("Introduce el exponente: ");
        int exponente=teclado.nextInt();
        
        System.out.println(potenciaR(base, exponente));
        
    }
    public static int potenciaR (int base, int exponente) { 
        int resultado;
        if (exponente==0){
            return 1;
        }
        else{
            resultado= base*potenciaR(base, exponente-1);
        }
        return resultado;
    }
}