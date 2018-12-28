/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosud5_repaso3;

/**
 *
 * @author admin1
 */
public class EjerciciosUD5_repaso3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Triangulo m1= new Triangulo(100,200,300);
        System.out.println("Es isosceles: "+m1.esIsosceles());
        System.out.println("Es equilatero: "+m1.esEquilatero());
        System.out.println("Es rectangulo: "+m1.esRectangulo());
        System.out.println("Perimetro: "+m1.perimetro());

    }
    
}
