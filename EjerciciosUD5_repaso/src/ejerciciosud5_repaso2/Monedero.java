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
public class Monedero {
    private double dinero;
    
    public Monedero(double d){
        this.dinero=d;
    }
    public void ingresar(double d){
        this.dinero+=d;
    }
    public void retirar(double d){
        this.dinero-=d;
    }
    public double consultar(){
        return dinero;
    }
}
