public class Griegos extends Guerrero {
    
    public Griegos(){
        super("GriegoX", 20, 8);
    } 

    public Griegos(String n, int edad, int f) {
        super(n, edad, f);
    }
         
    @Override
    public boolean retirarse() {
        super.retirarse();
        if (isHerido()&&!isMuerto()){
            System.out.println("RETIRADA");
        return true;
        }
        else if (isMuerto()){
            System.out.println("El griego no se puede retirar, está muerto.");
            return false;
        }
        else{
            return false;
        }
    }
    @Override
    public void mostrarDatos(){
        System.out.print("Griego: ");
        super.mostrarDatos();
    }
}
