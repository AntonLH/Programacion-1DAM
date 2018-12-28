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
public class Hipoteca {
    private int capital, redito,tiempo;

    public Hipoteca(int capital, int redito, int tiempo) {
        this.capital = capital;
        this.redito = redito;
        this.tiempo = tiempo;
    }
    public double cuota(){
        return capital*redito*tiempo/100;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getTiempo() {
        return tiempo;
    }
    
}
