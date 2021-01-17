import java.util.Scanner;
/**
 * Write a description of class Ejercicio1 here.
 * 
 * @author (your name) Jaime Martínez Sánchez, Antonio Abarca Miota
 */
public class Ejercicio1 {
    
    public static String dibujarCuadrado(int n) {
        String result = "";
        int m = n/2;
        for(int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if(j<m-1 || i<m-1 || j>m || i>m) {    
                    result += "*";
                }
                
                else {
                    result += " ";
                }                
            }
            result += "\n";
        }
        return result;
    }
    
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        System.out.println("Tamaño del cuadrado:");
        int n = t.nextInt();
        System.out.println(dibujarCuadrado(n));
             
    }              
 }                  
           
    
            
        