/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciometodos13;

import java.util.Scanner;

/**
 *
 * @author admin1
 */
public class Ejerciciometodos13 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        int mes, año, cont=0, cont_semana=1, dia_temp_maxima=0, dia_temp_minima=0;
        double temperatura, temp_maxima=-20, temp_minima=40, media=0;
        boolean seguir=true;
        String seguir_si_no, nombre_dia_max, nombre_dia_min;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce un número de mes: ");
        mes=teclado.nextInt();
        System.out.println("Introduce un número de año: ");
        año=teclado.nextInt();
        int numdias=numDiasMes(mes, año);
        String nombre_mes=nombreMes(mes);
        do{
        while(cont<numdias){
            temperatura= leerTemperatura();
            if (temperatura>=temp_maxima){
                temp_maxima=temperatura;
                dia_temp_maxima=cont+1;
            }
            if (temperatura<=temp_minima){
                temp_minima=temperatura;
                dia_temp_minima=cont+1;
            }
            media+=temperatura;
            cont++;
        }
        cont=0;
        media=media/7;
        System.out.println("Datos del mes de "+nombre_mes+" de "+año+" Nº Dias registrados "+numdias);
        mostrarDatos(media, temp_maxima,dia_temp_maxima, temp_minima,dia_temp_minima);
        cont_semana++;
        media=0;
        temp_maxima=-20;
        temp_minima=40;
        System.out.println("¿Desea continuar con la siguiente semana? Pulse (S)i o (N)o");
        seguir_si_no=teclado.next();
        char seguir2 =seguir_si_no.charAt(0);
        if (('S'==(seguir2))||('s'==(seguir2))){
           seguir=true;
        }
        else if (('N'==(seguir2))||('n'==(seguir2))){
           seguir=false;
            System.out.println("FIN");
        }
        else {
            System.out.println("Error. Siguiendo con el programa");
        }
        if(cont_semana==5){
        System.out.println("Ya ha introducido los datos de todas las semanas del mes");
        }
        }while((cont_semana<5)&&(seguir==true));
    }
        
    public static int pedirMes(){
        int mes;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce un número de mes: ");
        mes=teclado.nextInt();
        while(mes<1||mes>12){
            System.out.println("Introduce un número de mes correcto: ");
            mes=teclado.nextInt();
        }
        return mes;

    }
    public static boolean esBisiesto(int año){
        boolean bisiesto;
       if (año%400==0||(año%4==0&&año%100!=0)){
           bisiesto=true;
       }
       else {
           bisiesto=false;
       }
       return bisiesto;
    }
    public static int numDiasMes(int mes, int año){
        boolean bisiesto=esBisiesto(año);
        int numdias=30;
        if (mes==2 && bisiesto){
            numdias=29;      
        }
        else if (mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12){
            numdias=31;
        }
        else if (mes==4||mes==6||mes==9||mes==11){
            numdias=30;
        }
        else if (mes==2){
            numdias=28;
        }
        return numdias;
    }
    public static double leerTemperatura(){
        double temperatura;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce la temperatura en ºC: ");
        temperatura=teclado.nextDouble();
        while(temperatura<-20||temperatura>40){
            System.out.println("Introduce una temperatura entre -20ºC y 40ºC: ");
            temperatura=teclado.nextDouble();
        }
        return temperatura;

    }
    public static String nombreMes(int mes){
        String nombremes="";
        switch(mes){
            case 1:nombremes="Enero";break;
            case 2:nombremes="Febrero";break;
            case 3:nombremes="Marzo";break;
            case 4:nombremes="Abril";break;
            case 5:nombremes="Mayo";break;
            case 6:nombremes="Junio";break;
            case 7:nombremes="Julio";break;
            case 8:nombremes="Agosto";break;
            case 9:nombremes="Septiembre";break;
            case 10:nombremes="Octubre";break;
            case 11:nombremes="Noviembre";break;
            case 12:nombremes="Diciembre";break;
        }
        return nombremes;
    }
    
    public static void mostrarDatos(double media, double maxima, int semana_max, double minima, int semana_min){
        double media_farenheit=celsiusAFarenheit(media);
        double min_farenheit=celsiusAFarenheit(minima);
        double max_farenheit=celsiusAFarenheit(maxima);
        System.out.println("              ºC        ºF       Dia");
        System.out.println("Temp. Media   "+media+"       "+media_farenheit+"     -----");
        System.out.println("Temp. Max     "+maxima+"       "+max_farenheit+"     "+semana_max);
        System.out.println("Temp. Min     "+minima+"       "+min_farenheit+"     "+semana_min);
    }
    public static double celsiusAFarenheit(double temperatura){
        double farenheit;
        farenheit=1.8*temperatura+32;
        return farenheit;
    }
    
}
