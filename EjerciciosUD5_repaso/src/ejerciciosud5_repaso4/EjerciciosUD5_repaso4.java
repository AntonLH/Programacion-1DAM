/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso4;

/**
 *
 * @author admin1
 */
public class EjerciciosUD5_repaso4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Alarma a1= new Alarma(20);
        Alarma a2=new Alarma();
        a1.comprueba();
        a2.comprueba();
        int timbre1=a1.getTimbre();
        int timbre2=a2.getTimbre();
        if(timbre1==1){
            a1.normaliza();
        }
        if(timbre2==1){
            a2.normaliza();
        }
        System.out.println(a1.getTemperatura());
        System.out.println(a2.getTemperatura());
    }
    
}
