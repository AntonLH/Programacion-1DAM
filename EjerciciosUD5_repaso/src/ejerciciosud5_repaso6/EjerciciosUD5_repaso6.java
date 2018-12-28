/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso6;

/**
 *
 * @author admin1
 */
public class EjerciciosUD5_repaso6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hipoteca h1= new Hipoteca(1917, 10, 2);
        System.out.println("TIEMPO\tCUOTA");
        for(int i=h1.getTiempo();i<20;i++){
            h1.setTiempo(i);
            System.out.println(i+"\t"+h1.cuota());
        }
    }
    
}
