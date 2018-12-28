public class Vehiculo {

    private String matricula;

    private static final double PRECIO_POR_DIA=50;

    public Vehiculo(String matricula) {
        this.matricula=matricula;
    }

    public double precioAlquiler(int dias) {
        return dias*PRECIO_POR_DIA;
    }

    public String getMatricula() {
        return matricula;
    } 
    public void mostrarDatos(){
    }
    
}
