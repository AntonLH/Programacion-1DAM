/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacontactos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin1
 */
public class Listacontactos {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado=new Scanner(System.in);
    static ArrayList <Contacto> contactos=null;
    public static void main(String[] args) {
        // TODO code application logic here
        File f1=new File("contactos.dat");
        if(!f1.exists()){
            contactos=new ArrayList();
        }
        else{
            try{
            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois=new ObjectInputStream(fis);
                contactos= (ArrayList<Contacto>) ois.readObject();
                ois.close();
                fis.close();
            
            }catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Listacontactos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int opcion=0;
        do{
        System.out.println("* 1. Añadir contacto\n" +
                            "* 2. Visualizar contactos ordenados\n" +
                            "* 3. Felicitar cumple\n" +
                            "* 4. Buscar contacto\n" +
                            "* 5. Borrar contacto\n" +
                            "* 6. Salir");
            System.out.println("Selecciona una opción (1-6)");
        opcion=teclado.nextInt();
        switch(opcion){
            case 1: añadir();break;
            case 2: mostrar();break;
            case 3: felicitar();break;
            case 4: buscar();break;
            case 5: borrar();break;
            
        }
        }while(opcion!=6);
            FileOutputStream fos =null;
            ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("contactos.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(contactos);
        } catch (IOException ex) {
            Logger.getLogger(Listacontactos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void añadir(){
        System.out.println("Introduce telefono");
        String telefono=teclado.next();
        System.out.println("Introduce email");
        String email=teclado.next();
        System.out.println("Introduce grupo(1.- familia, 2.-Amigos, 3.-Trabajo)");
        int grupo=teclado.nextInt();
        System.out.println("Introduce nombre");
        String nombre=teclado.next();
        System.out.println("Introduce apellidos");
        String apellidos=teclado.next();
        System.out.println("Introduce dia de nacimiento");
        int dia=teclado.nextInt();
        System.out.println("Introduce mes de nacimiento");
        int mes=teclado.nextInt();
        System.out.println("Introduce año de nacimiento");
        int año=teclado.nextInt();
        
        GregorianCalendar fechaNac= new GregorianCalendar(año, mes, dia);
        Contacto c1=new Contacto(telefono,email,grupo, nombre, apellidos, fechaNac);
        contactos.add(c1);
    }
    public static void mostrar(){
        Collections.sort(contactos, new ordenadoapellidonombre());
        for (int i=0;i<contactos.size();i++){
            contactos.get(i).mostrar();
        }

    }
    public static void buscar(){
        System.out.println("Introduce nombre");
        String nom=teclado.next();
        
        for (int i=0;i<contactos.size();i++){
            if(nom.equals(contactos.get(i).getNombre())){
                contactos.get(i).mostrar();
            }
        }

    }
    public static void borrar(){
        System.out.println("Introduce nombre");
        String nom=teclado.next();
        
        for (int i=0;i<contactos.size();i++){
            if(nom.equals(contactos.get(i).getNombre())){
                contactos.remove(i);
            }
        }

    }
    public static void felicitar(){
    Calendar fechaActual = Calendar.getInstance();
        for (int i=0;i<contactos.size();i++){
            if((contactos.get(i).getFechaNac().get(Calendar.DAY_OF_MONTH)==fechaActual.get(Calendar.DAY_OF_MONTH))&&(contactos.get(i).getFechaNac().get(Calendar.MONTH)==(fechaActual.get(Calendar.MONTH)+1))){
                int años=fechaActual.get(Calendar.YEAR) -contactos.get(i).getFechaNac().get(Calendar.YEAR);
                System.out.println("Cumpleaños de "+contactos.get(i).getNombre()+"\n Hoy cumple "+años+" años\nTelefono:"+contactos.get(i).getTelefono()+"\ne-mail:"+contactos.get(i).getEmail());
            }
        }
    }

}
