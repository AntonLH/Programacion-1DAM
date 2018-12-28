/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosprimos;
/**
 *
 * @author admin1
 */
public class NumerosPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero=0,contador=0,i,primos=0;
        while(numero<100000){
         for(i=1;i<(numero+1);i++){
         if(numero%i==0){
             contador++;
            }
         }
         if(contador==2){
              System.out.println(numero);
              primos++;
         }
      
        numero++;
        contador=0;
        }
        System.out.println(primos);
    }
}
