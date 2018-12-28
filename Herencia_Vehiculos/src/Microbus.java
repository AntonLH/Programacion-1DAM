public class Microbus extends VehiculoPasajero {

    private static final double PRECIO_PLAZA=2;

    public Microbus(String mat, int plazas) {
        super(mat, plazas);
    }

    public double precioAlquiler(int dias) {
        return super.precioAlquiler(dias)+PRECIO_PLAZA*super.getPlazas();
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Esto es un microbus");
        super.mostrarDatos(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
