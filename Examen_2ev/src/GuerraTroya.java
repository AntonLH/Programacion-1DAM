/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin1
 */
public class GuerraTroya {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Caballo c1=new Caballo(20);
        Griegos g1=new Griegos("Aquiles", 20,9);
        Griegos g2=new Griegos("Agamenon", 25,7);
        Griegos g3=new Griegos("Ajax", 37,6);
        c1.montarseEnCaballo(g1);
        c1.montarseEnCaballo(g2);
        c1.montarseEnCaballo(g3);
        c1.mostrarCaballo();
        Griegos g4=new Griegos();
        c1.montarseEnCaballo(g4);
        c1.mostrarCaballo();
        c1.mostrarGuerreroPosicion(c1.buscar("Agamenon"));
        c1.buscar("Odiseo");
        Troyanos t1=new Troyanos("Paris", 20,10);
        c1.montarseEnCaballo(t1);
    }
    
}
