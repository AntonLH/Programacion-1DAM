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
        Alimentos a1= new Alimentos("aaa",10,3,false);
        a1.mostrarAtributos();
        System.out.println(a1.esDietetico());
        System.out.println(a1.calorias(23));
        System.out.println(a1.claveA());
    }
    
}
