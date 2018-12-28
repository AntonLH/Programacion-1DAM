public class VehiculoPasajero extends Vehiculo {

    private int plazas;

    private static final double PRECIO_PLAZA_DIA=1.5;

    public VehiculoPasajero(String matricula, int plazas) {
        super(matricula);
        this.plazas=plazas;
    }

    public int getPlazas() {
        return plazas;
    }

    @Override
    public double precioAlquiler(int dias) {
        return super.precioAlquiler(dias)+PRECIO_PLAZA_DIA*plazas*dias;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Esto es un vehiculo de pasajeros");
        System.out.println("La matricula es: "+super.getMatricula());
        System.out.println("El número de plazas es: "+plazas);
    }
    
}
