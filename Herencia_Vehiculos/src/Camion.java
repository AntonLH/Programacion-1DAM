public class Camion extends VehiculoCarga {

    private double PRECIO_fijo_CAMION=40;

    public Camion(String mat, double a) {
        super(mat, a);
    }

    @Override
    public double precioAlquiler(int dias) {
        return super.precioAlquiler(dias)+PRECIO_fijo_CAMION;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Esto es un camión");
        super.mostrarDatos(); //To change body of generated methods, choose Tools | Templates.
    }

}
