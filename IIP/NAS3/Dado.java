import java.io.*;
/**
 * Write a description of class Dado here.
 * 
 * @author (your name) Jaime Martínez Sánchez. Antonio Abarca Miota
 * @version (a version number or a date)
 */
public class Dado {
   /** n >= 0 */
public static void dibujaZ(int n) {
for(int i=0; i<n; i++) System.out.print("Z");
System.out.println();
for(int i=0; i<n-2; i++) {
for(int j=0; j<n-2-i; j++) System.out.print(" ");
System.out.println("Z");
}
for(int i=0; i<n; i++) System.out.print("Z");
System.out.println();
}
}

        
        
