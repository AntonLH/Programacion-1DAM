/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1ev_antón;
import java.util.Scanner;
/**
 *
 * @author admin1
 */
public class Examen1ev_Antón {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int mes, cont=0, cont_semana=1, dia_temp_maxima=0, dia_temp_minima=0;
        double temperatura, temp_maxima=-20, temp_minima=40, media=0;
        boolean seguir=true;
        String seguir_si_no, nombre_dia_max, nombre_dia_min;
        Scanner teclado=new Scanner(System.in);
        mes= pedirMes();
        String nombre_mes=nombreMes(mes);
        do{
        System.out.println("Datos del mes de "+nombre_mes+", semana "+cont_semana+":");
        while(cont<7){
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
        nombre_dia_max=nombreDia(dia_temp_maxima);
        nombre_dia_min=nombreDia(dia_temp_minima);
        mostrarDatosSemana(media, temp_maxima, nombre_dia_max, temp_minima, nombre_dia_min);
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
    public static double leerTemperatura(){
        double temperatura;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce la temperatura en ºC: ");
        temperatura=teclado.nextDouble();
        while(temperatura<-20||temperatura>40){
            System.out.println("Introduce una temperatura entre -20ºC y 40ºC: ");
            temperatura=teclado.nextInt();
        }
        return temperatura;

    }
    public static String nombreMes(int mes){
        if (mes==1){
            return "Enero";
        }
        else if (mes==2){
            return "Febrero";
        }
        else if (mes==3){
            return "Marzo";
        }
        else if (mes==4){
            return "Abril";
        }
        else if (mes==5){
            return "Mayo";
        }
        else if (mes==6){
            return "Junio";
        }
        else if (mes==7){
            return "Julio";
        }
        else if (mes==8){
            return "Agosto";
        }
        else if (mes==9){
            return "Septiembre";
        }
        else if (mes==10){
            return "Octubre";
        }
        else if (mes==11){
            return "Noviembre";
        }
        else if (mes==12){
            return "Diciembre";
        }
        else {
            return "incorrecto";
        }
    }
    
    public static void mostrarDatosSemana(double media, double maxima, String semana_max, double minima, String semana_min){
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
    public static String nombreDia(int dia){
        if (dia==1){
            return "Lunes";
        }
        else if (dia==2){
            return "Martes";
        }
        else if (dia==3){
            return "Miércoles";
        }
        else if (dia==4){
            return "Jueves";
        }
        else if (dia==5){
            return "Viernes";
        }
        else if (dia==6){
            return "Sábado";
        }
        else if (dia==7){
            return "Domingo";
        }
        else {
            return "dia_incorrecto";
        }
}
}