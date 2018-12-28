/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_array3;

/**
 *
 * @author admin1
 */
public class Ejercicios_Array3 {

    /**
     * @param args the command line arguments
     */
    static int[] componentes = new int [20];

    public static void main(String[] args) {
       componentes=cargarTabla(componentes.length, 1, 9);
       mostrarArray(componentes);
       mostrarFrecuencias(componentes);
    }
    public static int[] cargarTabla(int tamaño,int valorMin,int valorMax){
        int cont=0;
        while (cont<tamaño){
            componentes[cont]=(int) (Math.random() * (valorMax +valorMin));
            cont++;
        }
        return componentes;
    }
    public static void mostrarFrecuencias(int [] numeros){
        int[] arr_contador=new int [9];
       for(int i=0;i<numeros.length;i++){
          
          switch(numeros[i]){
              case 1:arr_contador[0]++;break; 
              case 2:arr_contador[1]++;break; 
              case 3:arr_contador[2]++;break; 
              case 4:arr_contador[3]++;break; 
              case 5:arr_contador[4]++;break; 
              case 6:arr_contador[5]++;break; 
              case 7:arr_contador[6]++;break; 
              case 8:arr_contador[7]++;break; 
              case 9:arr_contador[8]++;break; 
         }
        } 
        for(int i=0;i<arr_contador.length;i++){
            int j=i+1;
            System.out.println("Número de veces que ha salido el número "+j+": "+arr_contador[i]);
        }

    }
    public static void mostrarArray(int [] numeros){
        for(int i=0;i<numeros.length;i++){
            int j=i+1;
            System.out.println("Posición número "+j+": "+numeros[i]);
        }

    }
    
}
