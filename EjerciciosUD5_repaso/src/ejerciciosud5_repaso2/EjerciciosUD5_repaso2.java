/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso2;

/**
 *
 * @author admin1
 */
public class EjerciciosUD5_repaso2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Monedero m1= new Monedero(100);
        m1.ingresar(10);
        m1.retirar(20);
        System.out.println("Dinero en el monedero: "+m1.consultar());
    }
    
}
