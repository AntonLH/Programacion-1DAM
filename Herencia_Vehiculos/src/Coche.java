public class Coche extends VehiculoPasajero {
    
    
    private static final double PRECIO_PLAZA_DIA=1.5;

    public Coche(String mat, int plazas) {
        super(mat, plazas);
    }

    public double precioAlquiler(int dias) {
       return super.precioAlquiler(dias)+PRECIO_PLAZA_DIA*super.getPlazas()*dias;

    }

    @Override
    public void mostrarDatos() {
        System.out.println("Esto es un coche");
        super.mostrarDatos(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
