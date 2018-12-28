/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin1
 */
import java.util.Scanner;
public class AplicacionFlota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int opcion2, opcion;
        Coche c1;
        Furgoneta f1;
        Camion cam1;
        Microbus m1;
        String matricula;
        System.out.println("Introduce el número de plazas de la flota: ");
        int numplazas=teclado.nextInt();
        CFlota cf1=new CFlota(numplazas);
        do{
        System.out.println("Introduce el número de la opción:\n1. Alta vehículo" +
                            "\n" +
                            "2. Baja vehículo" +
                            "\n" +
                            "3. Mostrar Flota" +
                            "\n" +
                            "4. Mostrar Precio Alquiler de un vehículo X días" +
                            "\n" +
                            "5. Mostrar Precio Alquiler Todos X días" +
                            "\n" +
                            "6. Estadística de vehículos (mostrar el número de vehículos de cada tipo" +
                            "\n" +
                            "y el número total)" +
                            "\n" +
                            "7. Salir");
        opcion=teclado.nextInt();
        switch (opcion){
            case 1:System.out.println("Introduce el tipo de Vehículo \n1. Coche\n2. Microbus\n3. Camion\n4. Furgoneta");
               opcion2=teclado.nextInt();
                switch(opcion2){
                case 1: System.out.println("Coche seleccionado");
                        System.out.println("Introduce la matrícula");
                        matricula=teclado.next();
                        System.out.println("Introduce el número de plazas");
                        int plazas=teclado.nextInt();
                        c1=new Coche(matricula, plazas);
                        cf1.agregarVehiculo(c1);break;
                case 2: System.out.println("Microbus seleccionado");
                        System.out.println("Introduce la matrícula");
                         matricula=teclado.next();
                        System.out.println("Introduce el número de plazas");
                         plazas=teclado.nextInt();
                        m1=new Microbus(matricula, plazas);
                        cf1.agregarVehiculo(m1);break;
                case 3: System.out.println("Camion seleccionado");
                        System.out.println("Introduce la matrícula");
                         matricula=teclado.next();
                        System.out.println("Introduce el número pma");
                         plazas=teclado.nextInt();
                        cam1=new Camion(matricula, plazas);
                        cf1.agregarVehiculo(cam1);break;

                case 4: System.out.println("Furgoneta seleccionado");
                        System.out.println("Introduce la matrícula");
                         matricula=teclado.next();
                        System.out.println("Introduce el número pma");
                         plazas=teclado.nextInt();
                        f1=new Furgoneta(matricula, plazas);
                        cf1.agregarVehiculo(f1);break;

                }
            break;
            case 2: System.out.println("Introduce la matrícula del vehículo a eliminar: ");
                matricula=teclado.next();
                cf1.eliminarVehiculo(matricula);break;
            case 3: System.out.println("Mostrar flota: ");
                cf1.mostrarFlota();break;
            case 4: System.out.println("Introduce la matrícula del vehículo del cual mostrar el alquiler: ");
                matricula=teclado.next();
                System.out.println("Introduce el número de dias de alquiler: ");
                int dias=teclado.nextInt();
                cf1.precioAlquiler(matricula, dias);break;
            case 5:System.out.println("Introduce el número de dias de alquiler: ");
                dias=teclado.nextInt();
                cf1.precioAlquilertTodos(dias);break;
            case 6:System.out.println("Estadísticas de vehículos:\n Número de vehículos total: "+cf1.totVehic()+"\n Número de coches: "+cf1.numCoches()+"\n Número de microbuses: "+cf1.numMicrobus()+"\n Número de furgonetas: "+cf1.numFur()+"\n Número de camiones: "+cf1.numCam());break;
            case 7:System.out.println("Salir");break;
           default:System.out.println("Introduce un número del 1 al 7");
        }
        }while(opcion!=7);
    }
}