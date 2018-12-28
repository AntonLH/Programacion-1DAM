/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosromanos;

import java.util.Scanner;

/**
 *
 * @author admin1
 */
public class Numerosromanos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num, mil, cien, diez, unidad, i;
        String numromano="";
        Scanner teclado= new Scanner(System.in);
        num=teclado.nextInt();
        if (num>3999){
            System.out.println("Introduce un número menor que 4000");
            System.exit(0);
        }
        
        mil=num/1000;
        num=num%1000;
        cien=num/100;
        num=num%100;
        diez=num/10;
        num=num%10;
        unidad=num;
        System.out.println(mil+" "+cien+" "+diez+" "+unidad);
        for (i=0;i<mil;i++){
            numromano=numromano+"M"; 
        }
        
        
        if (cien==9){
            numromano=numromano+"CM";
        }
        else if (cien>=5){
            numromano=numromano+"D";  
            for (i=5;i<cien;i++){
            numromano=numromano+"C";
            }
        }
        if (cien==4){
            numromano=numromano+"CD";
        }
        else if (cien<5){
            
            for (i=0;i<cien;i++){
            numromano=numromano+"C";                
            }
        }
        if (diez==9){
            numromano=numromano+"XC";
        }
        else if (diez>=5){
            numromano=numromano+"L";  
            for (i=5;i<diez;i++){
            numromano=numromano+"X";
            }
        }
        if (diez==4){
            numromano=numromano+"XL";
        }
        else if (diez<5){
            
            for (i=0;i<diez;i++){
            numromano=numromano+"X";                
            }
        }
        if (unidad==9){
            numromano=numromano+"IX";
        }
        else if (unidad>=5){
            numromano=numromano+"V";  
            for (i=5;i<unidad;i++){
            numromano=numromano+"I";
            }
        }
        if (unidad==4){
            numromano=numromano+"IV";
        }
        else if (unidad<5){
            
            for (i=0;i<unidad;i++){
            numromano=numromano+"I";                
            }
        }
        System.out.println(numromano);
    }
    
}
