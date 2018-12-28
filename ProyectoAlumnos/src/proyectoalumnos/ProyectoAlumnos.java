/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalumnos;

import java.util.Scanner;

/**
 *
 * @author admin1
 */
public class ProyectoAlumnos {

    /**
     * @param args the command line arguments
     */
        static Scanner teclado=new Scanner(System.in);
        static CGrupo c1=new CGrupo("DAM");

    public static void main(String[] args) {
        // TODO code application logic here
        int opcion=0;
        do {
        opcion=menu();
        switch(opcion){
            case 1:System.out.println("Introduce el nombre");
                   String nombre5=teclado.next();
                   System.out.println("Introduce la direccion");
                   String direccion=teclado.next();
                   System.out.println("Introduce el dni");
                   String dni=teclado.next();
                   CAlumno a2=new CAlumno(dni, nombre5, direccion);
                   c1.añadirAlumno(a2);
                   System.out.println("¿Cuántas asignaturas quieres introducir?");
                   int numasig=teclado.nextInt();
                    
                   System.out.println("Introduce "+numasig+" asignaturas: ");
                   for (int i=0;i<numasig;i++){
                       System.out.println("Introduce el nombre de la asignatura");
                       String nombre4= teclado.next();
                       a2.añadirAsignatura(new CAsignatura(nombre4));
                   }

                   ;break;
            case 2:System.out.println("Introduce el nombre");
                   String nombre=teclado.next();
                   System.out.println("");
                   char pregunta2;
                   do{
                   System.out.println("¿Seguro que quieres eliminar a "+nombre+"? (S/N)");
                   String pregunta=teclado.next();
                   pregunta2=pregunta.charAt(0);
                   if(pregunta2=='S'){
                   c1.eliminar(nombre);
                   }
                   else if(pregunta2=='N'){
                       System.out.println("Operación cancelada");
                   }
                   }while(pregunta2!='S'&&pregunta2!='N');break;
            case 3:System.out.println("Introduce el nombre");
                   String nombre2=teclado.next();
                   CAlumno a1=c1.devolverAlumno(nombre2);
                   for (int i=0;i<a1.getListaAsignaturas().size();i++){
                       System.out.println("Introduce la nota de la asignatura "+a1.getListaAsignaturas().get(i).getNombre());
                       int nota= teclado.nextInt();
                       a1.getListaAsignaturas().get(i).setNota(nota);
                   }
                   break;
            case 4:System.out.println("Introduce el nombre");
                   String nombre3=teclado.next();
                   try{
                   CAlumno a3=c1.devolverAlumno(nombre3);
                   System.out.println(a3.toString());
                   }
                   catch(NullPointerException e){
                       System.out.println("Ese alumno no existe");
                   }
                   
        }
        }while(opcion!=5);
    }
        // TODO code application logic here
    public static int menu(){
        System.out.println("Selecciona una opción:");
                
        System.out.println("1. Matricular" +
                            "\n"+
                            "2. Baja de alumno" +
                            "\n" +
                            "3. Poner notas" +
                            "\n" +
                            "4. Mostrar expediente" +
                            "\n" +
                            "5. Salir");
        int opcion=teclado.nextInt();
        return opcion;
    }
}