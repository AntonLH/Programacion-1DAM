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
public class Triangulo {
   private int lado1, lado2, lado3;

   // Constructor to initialize the lados of the triangle.
   public Triangulo (int l1, int l2, int l3) {
      lado1 = l1;
      lado2 = l2;
      lado3 = l3;
   }

     public boolean esIsosceles () {
      return((lado1 == lado2) && (lado1 != lado3)) ||
          ((lado1 == lado3) && (lado1 != lado2)) ||
          ((lado2 == lado3) && (lado2 != lado1));
   }
   public boolean esRectangulo () {
      return(((lado1*lado1) == ((lado2*lado2) + (lado3*lado3))) ||
          ((lado2*lado2) == ((lado1*lado1) + (lado3*lado3))) ||
          ((lado3*lado3) == ((lado1*lado1) + (lado2*lado2))));
   }



   // Method to test for an equilateral triangle.
   public boolean esEquilatero () {
      return((lado1 == lado2) && (lado1 == lado3));
   }
   public int perimetro(){
       return lado1+lado2+lado3;
   }
}


