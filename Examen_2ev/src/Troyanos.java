public class Troyanos extends Guerrero {
    
    public Troyanos(){
        super("TroyanoX", 18, 10);
    } 

    public Troyanos(String n, int edad, int f) {
        super(n, edad, f);
    }

    @Override
    public boolean retirarse() {
        super.retirarse();
        System.out.println("Los guerreros Troyanos NUNCA se retiran");
        return false;
    }
    @Override
    public void mostrarDatos(){
        System.out.print("Troyano: ");
        super.mostrarDatos();
    }

}