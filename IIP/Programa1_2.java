
/**
 * Write a description of class Programa1_2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner; 

public class Programa1_2
{
    public static double getFahrenheit(double celsius) {
        double fahrenheit = (9.0/5.0)*celsius+32;
        return fahrenheit;
      
    }
    
    public static double getCelsius(double fahrenheit) {
        double celsius = (5.0/9.0)*(fahrenheit-32);
        return celsius;
      
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Grados Celsius: ");
        double c = sc.nextDouble();
        System.out.println("El total en grados Fahrenheit es " + getFahrenheit(c));
        System.out.println("Grados Fahrenheit: ");
        double f = sc.nextDouble();
        System.out.println("El total en grados Celsius es " + getCelsius(f));
    }
}

