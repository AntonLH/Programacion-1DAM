/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anton_larrazabal2;

/**
 *
 * @author admin1
 */
public class Anton_Larrazabal2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Reloj r1=new Reloj(9,5,59);
        r1.segundoSiguiente();
        System.out.print("segundoSiguiente: ");
        r1.mostrar24();
        r1.segundoAnterior();
        System.out.print("segundoAnterior: ");
        r1.mostrar24();
        r1.mostrar12();
        r1.mostrar24();
        Reloj r2=new Reloj(13,59,59);
        r2.segundoSiguiente();
        System.out.print("segundoSiguiente: ");
        r2.mostrar24();
        r2.segundoAnterior();
        System.out.print("segundoAnterior: ");
        r2.mostrar24();
        r2.mostrar12();
        r2.mostrar24();
        Reloj r3=new Reloj(00,00,00);
        r3.segundoAnterior();
        System.out.print("segundoAnterior: ");
        r3.mostrar24();
        r3.segundoSiguiente();
        System.out.print("segundoSiguiente: ");
        r3.mostrar24();
        r3.mostrar12();
        r3.mostrar24();
        
        Reloj hora_actual=new Reloj();
        hora_actual.mostrar24();
        for (int i=0;i<200;i++){
            hora_actual.segundoSiguiente();
            hora_actual.mostrar24();
        }
    }
    
}
