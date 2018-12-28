/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso5;

/**
 *
 * @author admin1
 */
public class Cifras {
    private int numero;

    public Cifras(int numero) {
        this.numero = numero;
    }
    public boolean esPar(){
        return (numero%2==0);
    }
    public void divisores(){
        for (int i=1;i<numero;i++){
            if(numero%i==0){
                System.out.println(i);
            }
        }
    }
    public int sumaDigitos(){
        int aux=numero, z, suma=0;
        while (aux>0){
            z=aux%10;
            suma+=z;
            aux=aux/10;
        }
        return suma;
    }
}
