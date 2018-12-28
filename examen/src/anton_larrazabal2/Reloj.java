/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anton_larrazabal2;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author admin1
 */
public class Reloj {
    private int hora, minuto, segundo;
    GregorianCalendar horaActual=new GregorianCalendar();
    /**
     * Constructor sin parámetros que inicializa los atributos con la hora actual
     */
    public Reloj() {
        this.hora =horaActual.get(Calendar.HOUR_OF_DAY);
        this.minuto = horaActual.get(Calendar.MINUTE);
        this.segundo = horaActual.get(Calendar.SECOND);
    }
    /**
     * Constructor que inicializa los atributos con los parámetros recibidos si son correctos, si no con la hora actual
     * @param hora
     * @param minuto
     * @param segundo 
     */
    public Reloj(int hora, int minuto, int segundo) {
        if(horaValida(hora, minuto, segundo)){
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = segundo;
        }
        else {
            this.hora =horaActual.get(Calendar.HOUR_OF_DAY);
            this.minuto = horaActual.get(Calendar.MINUTE);
            this.segundo = horaActual.get(Calendar.SECOND);
        }
    }
    /**
     * Método que devuelve true si la hora es válida y false en caso contrario
     * @param hora
     * @param minuto
     * @param segundo
     * @return 
     */
    public boolean horaValida(int hora, int minuto, int segundo){
        if(hora<0||hora>23)return false;
        if(minuto<0||minuto>59) return false;
        if(segundo<0||segundo>59) return false;
        return true;
    }
    /**
     * Método que suma un segundo a la hora
     */
    public void segundoSiguiente(){
        if(this.segundo==59 && this.minuto==59 && this.hora==23){
            this.hora=0;
            this.minuto=0;
            this.segundo=0;
        }
        else if(this.segundo==59 && this.minuto==59){
            this.hora++;
            this.minuto=0;
            this.segundo=0;
        }
        else if(this.segundo==59){
            this.minuto++;
            this.segundo=0;
        }
        else{
            this.segundo++;      
        }
    }
    /**
     * Método que quita un segundo a la hora
     */
    public void segundoAnterior(){
        if(this.segundo==0 && this.minuto==0 && this.hora==0){
           this.hora=23;
           this.minuto=59;
           this.segundo=59;
        }
        else if(this.segundo==0 && this.minuto==0){
            this.hora--;
            this.minuto=59;
            this.segundo=59;
        }
        else if(this.segundo==0){
            this.minuto--;
            this.segundo=59;
        }
        else{
            this.segundo--;    
        }
    }
    /**
     * Método que muestra la hora en formato de 12 horas
     */
    public void mostrar12(){
        if (hora<=12&&hora>0)System.out.println(hora+":"+minuto+":"+segundo+" A.M");
        else if (hora==0){
            int horapm=hora+12;
            System.out.println(horapm+":"+minuto+":"+segundo+" P.M.");
        }
        else{
            int horapm=hora-12;
            System.out.println(horapm+":"+minuto+":"+segundo+" P.M.");
        }
    }
    /**
     * Método que muestra la hora en formato de 24 horas
     */
    public void mostrar24(){
        System.out.println(hora+":"+minuto+":"+segundo);
    }
}
