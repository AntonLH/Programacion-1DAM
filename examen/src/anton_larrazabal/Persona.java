/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anton_larrazabal;

/**
 *
 * @author admin1
 */
public class Persona {
    private String nombre, apellido1, apellido2, dni;
    private int nivel_estudios;
    private static String[] String_estudios={"Elemental","Medio", "Superior"};
    private static int[] contador=new int[3];
    
    /**
     * Constructor que inicializa los atributos recibidos como argumentos
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param dni
     * @param nivel_estudios 
     */
    public Persona(String nombre, String apellido1, String apellido2, String dni, int nivel_estudios) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        if (nivel_estudios>=1&&nivel_estudios<=3){
            this.nivel_estudios = nivel_estudios;
            contador[nivel_estudios-1]++;
        }
        else{
            this.nivel_estudios=1;
            contador[0]++;
        }
    }
    /**
     * devuelve un String con una contraseña generada por letras del nombre y los dos apellidos
     * @return 
     */
    public String password(){
        return (nombre.substring(0,1)+apellido1.substring(0,2)+apellido2.substring((apellido2.length()-1),apellido2.length())).toUpperCase();
    }
    /**
     * Devuelve true si el dni sea válido y false en caso contrario
     * @return 
     */
    public boolean dniValido(){
        if(dni.length()!=9)return false;
        
        else{
            int dni_numeros=Integer.parseInt(dni.substring(0, 8));
            int resto=dni_numeros%23;
            String letras_dni="TRWAGMYFPDXBNJZASQVHLCKE";
            if(dni.substring(8, 9).equals(letras_dni.substring(resto, resto+1))) return true;
            else return false;
        }
    }

    /**
     * Muestra todos los datos de la persona
     */
    public void mostrarDatos(){
        System.out.println("Nombre: "+nombre+", Apellidos: " + apellido1 + ", " + apellido2 + ", DNI: " + dni + ", Nivel de estudios: " + String_estudios[nivel_estudios-1] + ", Password: "+password()+", DNI VALIDO: "+dniValido());
    }
    /**
     * Muestra las estadisticas según el nivel de estudios
     */
    public static void estadisticas(){
        int total=0;
        System.out.println("Estadisticas según nivel de estudios:");
        for (int i=0;i<contador.length;i++){
            total+=contador[i];
            System.out.println(String_estudios[i]+": "+contador[i]);
        }
        System.out.println("Numero total de personas: "+total);
    }        
}
