/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_array2;

/**
 *
 * @author admin1
 */
public class Ejercicios_Array2 {

    /**
     * @param args the command line arguments
     */
        static int[] componentes = new int [20];

    public static void main(String[] args) {
       componentes=cargarTabla();
       long total_prod=prodImpares(componentes);
       int total_suma=sumaPares(componentes);
       imprimir(componentes, total_prod, total_suma);
    }
    public static int generarNumero(){
       int numero= (int) (Math.random() * (100 +1));
       return numero;
    }
    public static int[] cargarTabla(){
        int cont=0;
        while (cont<20){
            componentes[cont]=generarNumero();
            cont++;
        }
        return componentes;
    }
    public static int sumaPares(int [] numeros){
        int total=0;
        for(int i=1;i<numeros.length;i=i+2){
            total+=numeros[i];
        }
        return total;
    }
    public static long prodImpares(int [] numeros){
        long total=1;
        for(int i=0;i<numeros.length;i=i+2){
            total*=numeros[i];
        }
        return total;
    }
    public static void imprimir(int [] numeros, long total_prod, int total_suma){
        for(int i=0;i<numeros.length;i++){
            int j=i+1;
            System.out.println("Edad número  "+j+": "+numeros[i]);
        }
        System.out.println(total_prod);
        System.out.println(total_suma);

    }
}
