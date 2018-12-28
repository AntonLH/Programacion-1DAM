/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso2_3;

/**
 *
 * @author admin1
 */
public class Cliente {
    private String nombre,apellido,telefono;
    private String[] tipo_String={"Sólo Linea Telefónica fija","Linea + Internet","Linea + Internet + linea móvil","Linea+ Internet + linea móvil + televisión por cable"};
    private int[] tipo_precio={12,22,30,38};
    private int[] array_contadores=new int[4];
    private int tipo;
    private int cont_total=0;
    public Cliente(String nombre, String apellido, String telefono, int tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipo=tipo;
    }
    public void generarOferta(){
        System.out.println("Nombre: "+nombre+
                        "\n" +
                        "Apellido: "+apellido+
                        "\n" +
                        "Telefono: "+telefono+
                        "\n" +
                        "Tipo contrato: "+tipo_String[tipo-1] +
                        "\n" +
                        "Mensaje para: "+generaEmail());
            if(tipo>0&&tipo<4){
                System.out.println("***************Oferta especial para "+nombre+" "+apellido+" ****************\n" +"** Si cambias a "+tipo_String[tipo]+"  **\n" +
                    "** "+tipo_precio[tipo]+"euros – 20% ="+(tipo_precio[tipo]*0.8)+" euros el primer año **\n"
                     +"**********************************************************************");
            }
            else if(tipo==4)System.out.println("No hay oferta disponible en este momento.");
    }
    public void clientesTipo(){
    switch(tipo){
        case 1:array_contadores[0]++;break;
        case 2:array_contadores[1]++;break;
        case 3:array_contadores[2]++;break;
        case 4:array_contadores[3]++;break;
        }
    }
    public void estadisticas(){
        clientesTipo();
        for(int i=0;i<4;i++){
            System.out.println("Numero de clientes del contrato "+tipo_String[i]+": "+array_contadores[i]);
            cont_total+=array_contadores[i];
        }
        System.out.println("Número total de clientes: "+cont_total);
    }
    public void cambiarTipoDeContrato(int tipo){
    switch(this.tipo){
        case 1:array_contadores[0]--;break;
        case 2:array_contadores[1]--;break;
        case 3:array_contadores[2]--;break;
        case 4:array_contadores[3]--;break;
        }
        this.tipo=tipo;
        cont_total--;
    }
    public int precio(){
        return tipo_precio[tipo-1];
    }
    public boolean esDeCantabria(){
        return (telefono.substring(0, 3).equals("942"));
    }
    public String generaEmail(){
        return nombre+"_"+apellido+telefono.substring(8)+"@javamail.com";
    }
    public String getNombre() {
        return nombre;
    }
    public int contieneLetra(char letra){
        int cont=0;
        for (int i=0;i<nombre.length();i++){
            if (nombre.charAt(i)==letra)cont++;
        }
        return cont;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}