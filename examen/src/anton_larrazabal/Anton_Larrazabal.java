/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anton_larrazabal;

/**
 *
 * @author admin1
 */
public class Anton_Larrazabal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona p1= new Persona("Jon", "Avalos", "Etxeberria", "12345678A",2);
        p1.mostrarDatos();
        Persona p2= new Persona("Cristina", "Hipolito", "Stamp", "12345678Z",3);
        p2.mostrarDatos();
        Persona.estadisticas();
    }
    
}
