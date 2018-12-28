/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin1
 */

public class CFlota {
    private int numVehiculos=0, numCoches=0, numMicrobuses=0, numCamiones=0, numFurgonetas=0;
    private Vehiculo[] garaje;
    
    public CFlota(int num) {
        garaje=new Vehiculo[num];
    }
    public void mostrarFlota(){
        if (numVehiculos==0)System.out.println("El garaje está vacío");
        else {
            for(int i=0;i<numVehiculos;i++){
                System.out.println(i);
                garaje[i].mostrarDatos();
            }
        }
    }
    public boolean agregarVehiculo(Vehiculo v){
        if(numVehiculos<garaje.length){ 
            garaje[numVehiculos]=v;
            numVehiculos++;
            if (v instanceof Coche)numCoches++;
            else if (v instanceof Microbus)numMicrobuses++;
            else if (v instanceof Furgoneta)numCamiones++;
            else if (v instanceof Camion)numFurgonetas++;
            return true;
        }
        else return false;
    }
    public void obtenerDatos(String mat){
        int i=0;
        boolean aux=false;
        while (i<numVehiculos && aux==false){
            if (mat.equals(garaje[i].getMatricula())){
                garaje[i].mostrarDatos();
                aux=true;
            }
            else if(i==numVehiculos-1){
                System.out.println("No existe esa matrícula");
            }
            i++;
        }
    }
    public void precioAlquiler(String mat, int dias){
        int i=0;
        boolean aux=false;
        while (i<numVehiculos && aux==false){
            if (mat.equals(garaje[i].getMatricula())){
                System.out.println(garaje[i].precioAlquiler(dias));
                aux=true;
            }
            else if(i==numVehiculos-1){
                System.out.println("No existe esa matrícula");
            }
            i++;
        }

    }
    public void precioAlquilertTodos(int dias){
        for(int i=0;i<numVehiculos;i++){
            System.out.println(tipoVehiculo(garaje[i])+" con matricula "+garaje[i].getMatricula()+" cuesta: "+garaje[i].precioAlquiler(dias));
        }
    }
    public String tipoVehiculo(Vehiculo v){
        if (v instanceof Coche)return "Coche";
        else if (v instanceof Microbus)return "Microbus";
        else if (v instanceof Furgoneta)return "Furgoneta";
        else if (v instanceof Camion)return "Camion";
        else return " ";
    }
    public int totVehic() {
        return numVehiculos;
    }

    public int numCoches() {
        return numCoches;
    }

    public int numMicrobus() {
        return numMicrobuses;
    }

    public int numCam() {
        return numCamiones;
    }

    public int numFur() {
        return numFurgonetas;
    }
    public void eliminarVehiculo(String mat){
        for(int i=0;i<numVehiculos;i++){
            if (mat.equals(garaje[i].getMatricula())){
                if (garaje[i] instanceof Coche)numCoches--;
                else if (garaje[i] instanceof Microbus)numMicrobuses--;
                else if (garaje[i] instanceof Furgoneta)numCamiones--;
                else if (garaje[i] instanceof Camion)numFurgonetas--;
                for(int j=i;j<numVehiculos;j++){
                    garaje[j]=garaje[j+1];
                }
                numVehiculos--;
            }
        }
    }
}