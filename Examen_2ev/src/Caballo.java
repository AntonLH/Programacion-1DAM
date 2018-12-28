/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin1
 */
public class Caballo {
    private int ocupacion=0, capacidad;
    private Guerrero[] ocupantes;
    public Caballo(int ocupantes){
        capacidad=ocupantes;
        this.ocupantes=new Guerrero[ocupantes];
    }
    public int buscar(String nombre){
      int i=0;
      boolean aux=false;
        while (i<ocupacion && aux==false){
            if (nombre.equals(ocupantes[i].getNombre())){
                aux=true;
                return i;
            }
            else if(i==ocupacion-1){
                System.out.println("No existe ese guerrero");
                return -1;
            }
            i++;
        }
        return -1;
    }
    public void mostrarGuerreroPosicion(int pos){
        if (pos<ocupacion) ocupantes[pos].mostrarDatos();
        else System.out.println("No hay ningún guerrero en esa posición");
    }
    public void montarseEnCaballo(Guerrero g){
        if (g instanceof Griegos&&ocupacion<ocupantes.length){
            System.out.println("Guerrero griego "+ g.getNombre()+" montado en caballo");
            ocupantes[ocupacion]=g;
            ocupacion++;
        }
        else if (ocupacion>=ocupantes.length) System.out.println("No hay sitio");
        else if (g instanceof Troyanos){
            System.out.println("\t\t\tAtención!!\nGuerrero Troyano "+g.getNombre()+" intentando acceder al caballo");
            g.setMuerto(true);
        }
    }
    public void mostrarCaballo(){
        System.out.println("Capacidad: "+ocupantes.length);
        System.out.println("Ocupación: "+ocupacion);
        for(int i=0;i<ocupacion;i++){
            ocupantes[i].mostrarDatos();
        }
    }
}
