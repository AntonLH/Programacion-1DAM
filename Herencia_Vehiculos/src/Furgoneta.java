public class Furgoneta extends VehiculoCarga {

    public Furgoneta(String mat, double pma) {
        super(mat, pma);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Esto es una furgoneta");
        super.mostrarDatos();
    }
    
}
