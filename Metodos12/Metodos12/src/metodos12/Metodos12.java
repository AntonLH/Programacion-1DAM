package metodos12;

import java.util.Scanner;

public class Metodos12 {

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int n;
        do{
            System.out.println("Introduce un número: ");
            n=teclado.nextInt();
            int a=cifras(n);
                System.out.println(a+" cifras");
        }while (n!=0);
    }    
    public static int cifras(int num){
        int contador=0;
        while (num!=0){
            num=num/10;
            contador++;
        }
        return contador;
        
    }
}