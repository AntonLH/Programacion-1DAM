public class VehiculoCarga extends Vehiculo {

    private double pma;

    private static int PRECIO_TONELADA_PMA=20;

    public VehiculoCarga(String mat, double pmautoriz) {
        super(mat);
        pma=pmautoriz;
    }

    @Override
    public double precioAlquiler(int dias) {
        return super.precioAlquiler(dias)+PRECIO_TONELADA_PMA*pma; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Esto es un vehiculo de carga");
        System.out.println("La matricula es: "+super.getMatricula());
        System.out.println("PMA es: "+pma);
    }
    
}
