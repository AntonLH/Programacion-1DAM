public class Guerrero {

    private String nombre;

    private int edad;

    private int fuerza;

    private boolean herido;

    private boolean muerto;

    public Guerrero() {
    }

    public Guerrero(String n, int edad, int f) {
        if (comprobarEdad(edad)) this.edad=edad;
        else this.edad=25;
        if (comprobarFuerza(f)) this.fuerza=f;
        else this.fuerza=5;
        this.nombre=n;
        this.herido=false;
        this.muerto=false;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public boolean isHerido() {
        return herido;
    }

    public void setHerido(boolean herido) {
        this.herido = herido;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean retirarse() {
        System.out.println("\t\t\t Acción:Retirarse\n");
        mostrarDatos();
        return false;
    }

    public static boolean comprobarEdad(int edad) {
        if (edad>=15&&edad<=60)return true;
        else return false;
    }

    public static boolean comprobarFuerza(int f) {
        if (f>=1&&f<=10)return true;
        else return false;
    }

    public void mostrarDatos() {
        System.out.println(nombre);
        System.out.println("Edad: "+edad+" Fuerza: "+fuerza);
        if(herido)System.out.println("Está herido");
        else System.out.println("No está herido\n");
    }
}