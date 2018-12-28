/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso2_3;

/**
 *
 * @author admin1
 */
public class EjerciciosUD5_repaso2_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente u1=new Cliente("anton","aaa","942484848",4);
        Cliente u2=new Cliente("aitor","mendoza","942484848",3);
        System.out.println(u1.esDeCantabria());
        u1.estadisticas();
        u2.estadisticas();
    }
}
