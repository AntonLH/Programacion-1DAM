/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso2_2;

/**
 *
 * @author admin1
 */
public class ejerciciosud5_repaso2_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Baraja b1=new Baraja();
        b1.mostrar();
        Baraja b2=new Baraja();
        b2.mostrar();
        if(b1.getNumero()>b2.getNumero())System.out.println("El 1 gana");
        else if(b1.getNumero()==b2.getNumero()) System.out.println("Empate");
        else System.out.println("El 2 gana");
    }
    
}
