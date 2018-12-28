package metodos8;

import java.util.Scanner;

public class Metodos8 {
        
public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int opcion;
        do{
        opcion = menu();
        if (opcion==1){
        System.out.println("Introduce un caracter:");
        String a=teclado.nextLine();
        char car=a.charAt(0);
        System.out.println("Introduce un número: ");
        int b=teclado.nextInt();
        pintar_linea(car,b);
        }
        else if (opcion==2){
            System.out.println("Introduce caracter para convertirlo a minúscula: ");
            String a=teclado.nextLine();
            char car2=a.charAt(0);
            char carminus= (char) pasar_minuscula(car2);
            System.out.println(carminus);
        }
        else if (opcion==3){
            System.out.println("Introduce caracter para convertirlo a mayúscula: ");
            String a=teclado.nextLine();
            char car2=a.charAt(0);
            char carminus= (char) pasar_mayuscula(car2);
            System.out.println(carminus);
            
        }
        else if (opcion==4){
            int contador=0;
            System.out.println("Introduce frase para convertirla a minúscula: ");
            String a=teclado.nextLine();
            int contador2=a.length();
            while (contador<contador2){
                char car2=a.charAt(contador);
                char carminus= (char) pasar_minuscula(car2);
                contador++;
                System.out.print(carminus);
            }
            System.out.println("");
        }
        else if (opcion==5){
            int contador=0;
            System.out.println("Introduce frase para convertirla a mayúscula: ");
            String a=teclado.nextLine();
            int contador2=a.length();
            while (contador<contador2){
                char car2=a.charAt(contador);
                char carmayus= (char) pasar_mayuscula(car2);
                contador++;
                System.out.print(carmayus);
            }
            System.out.println("");
        }
        }while(opcion!=6);
    }    
    public static void pintar_linea(char caracter, int numero){
        int c=0;
        while (c<numero){
            System.out.print(caracter);
            c++;
        }
        System.out.println("");
    }
    public static int pasar_minuscula(char caracter){
        char a;
        a=(char) (caracter+(' '));
        return a;
    }
    public static int pasar_mayuscula(char caracter){
        char b=(char) (caracter-' ');
        return b;
    }
    public static int menu(){
        Scanner teclado=new Scanner(System.in);
        System.out.println("1.- Pintar una línea" +"\n" +"2.- Convertir letra a minúscula" +"\n" +"3.- Convertir letra a mayúscula" +"\n" +"4.- Convertir frase a minúscula" +"\n" +"5.- Convertir frase a mayúscula" +"\n" +"6.-Salir");
        int menu=teclado.nextInt();
        return menu;
    }
}