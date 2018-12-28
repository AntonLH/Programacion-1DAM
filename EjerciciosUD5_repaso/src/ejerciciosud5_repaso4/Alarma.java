/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso4;
import java.util.Scanner;
/**
 *
 * @author admin1
 */
public class Alarma {
    private int temperatura, timbre;
    
    public Alarma(int temperatura) {
        this.temperatura = temperatura;
        this.timbre =0;
    }

    public Alarma() {
        System.out.println("Introduce la temperatura: ");
        Scanner s1=new Scanner(System.in);
        this.temperatura=s1.nextInt();
        this.timbre =0;
    }
    public void comprueba(){
        if (temperatura>35||temperatura<10){
            timbre=1;
        }
    }
    public void normaliza(){
        temperatura=25;
        timbre=0;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getTimbre() {
        return timbre;
    }
    

}
