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
public class Baraja {
    private String[] palo={"oros", "copas", "espadas", "bastos"};
    private int numero;
    private int numero2;
    public Baraja() {
        numero=(int)(Math.random()*10)+1;
        numero2=(int)(Math.random()*4)+0;
    }
    public void mostrar(){
        System.out.println(numero+" de "+palo[numero2]);
    }

    public int getNumero() {
        return numero;
    }
    
}
