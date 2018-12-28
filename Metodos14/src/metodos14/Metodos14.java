/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos14;
import java.util.Scanner;
/**
 *
 * @author admin1
 */
public class Metodos14 {

    /**
     * @param args the command line arguments
     */    
    static int anio;
    static int mes;
    static int dia;

    public static void main(String[] args) {
        do{
        dia=pedirDia();
        }while(dia==0);
        do{
        mes=pedirMes();
        }while(mes==0);
        do{
        anio=pedirAnio(1,2016);
        }while(anio==0);
        
        System.out.println("Fecha actual: "+anio+"/"+mes+"/"+dia);
        
        mostrarSiguienteDia(dia, anio, mes);
        }
    
    public static int pedirMes(){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce mes: ");
        mes=teclado.nextInt();
        if (mes>=1 && mes<=12){
            return mes;
        }
        else {
            return 0;
        }
        
    }
    public static int pedirAnio(int rango1, int rango2){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce año: ");
        anio=teclado.nextInt();
        if (anio>=rango1 && anio<=rango2){
            return anio;
        }
        else {
            return 0;
        }
        
    }
    public static int pedirDia(){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce dia: ");
        dia=teclado.nextInt();
        if (dia==29 && mes==2&&(anio%400==0||(anio%4==0&&anio%100!=0))){
            return dia;
        }
        else if (dia>28 && mes==2){
            return 0;
        }
        else if (dia==31 && (mes==4||mes==6||mes==9||mes==11)){
            return 0;
        }
        else if (dia>=1&&dia<=31&&mes<=12){
            return dia;
        }
        else {
            return 0;
        }
        
    }
    public static void mostrarSiguienteDia(int sigdia,int sigmes,int siganio){
        if (dia==29 && mes==2&&(anio%400==0||(anio%4==0&&anio%100!=0))){
            dia=1;
            mes++;
            System.out.println("Siguiente dia: "+anio+"/"+mes+"/"+dia);
        }
        else if (dia==31 && mes==12){
            anio++;
            mes=1;
            dia=1;
            System.out.println("Siguiente dia: "+anio+"/"+mes+"/"+dia);

        }
        else if (dia==28 && mes==2){
            dia=1;
            mes++;
            System.out.println("Siguiente dia: "+anio+"/"+mes+"/"+dia);

        }
        else if (dia==30 && (mes==4||mes==6||mes==9||mes==11)){
            mes++;
            dia=1;
            System.out.println("Siguiente dia: "+anio+"/"+mes+"/"+dia);

        }
        
        else if (dia==31){  
            mes++;
            dia=1;
            System.out.println("Siguiente dia: "+anio+"/"+mes+"/"+dia);
        }
        
        else {
            dia++;
            System.out.println("Siguiente dia: "+anio+"/"+mes+"/"+dia);
        }
        
    }
}