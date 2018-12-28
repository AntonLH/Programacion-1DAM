/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin1
 */
public class Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Furgoneta f1=new Furgoneta("U3333", 2);
        Camion cam1=new Camion("C4444",20);
        Coche c1=new Coche("1111Y", 2);
        Microbus m1=new Microbus("2222M",3);
        c1.mostrarDatos();
        f1.mostrarDatos();
        cam1.mostrarDatos();
        System.out.println("El precio de c1 es: "+c1.precioAlquiler(5));
        System.out.println("El precio de cam1 es: "+cam1.precioAlquiler(10));
        System.out.println("El precio de f1 es: "+f1.precioAlquiler(2));
        
        Vehiculo[] garaje=new Vehiculo[4];
        garaje[0]=c1;
        garaje[1]=m1;
        garaje[2]=cam1;
        garaje[3]=f1;
        
        System.out.println("Mostrar datos de todo el garaje");
        for (int i=0;i<garaje.length;i++){
            garaje[i].mostrarDatos();
        }
        System.out.println("Precio alquiler de todo");
        for (int i=0;i<garaje.length;i++){
            System.out.println("Precio alquiler de 5 días: "+garaje[i].precioAlquiler(5));
        }
    }
    
}
