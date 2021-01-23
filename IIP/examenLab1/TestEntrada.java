import java.util.Scanner;
/**
 * Clase TestEntrada. 
 * 
 *  @author (IIP. Grado en Informatica. ETSINF, UPV) 
 *  @version (Curso 2015-16)
 */
public class TestEntrada {
    public static void main(String[] args) { 
        // 1. Crea una entrada para la pelicula "Irrational Man" proyectada  
        //    en los cines "Babel" en la sesion de las 22:45.
        
        /* COMPLETAR */ 
        
        Entrada a = new Entrada("Irrational man", "Babel", 22, 45);
        
        // Lectura de horas y minutos
        Scanner teclado = new Scanner(System.in);
        System.out.print("   -> Introduzca las horas (entre 0 y 23): ");
        int h = teclado.nextInt();
        System.out.print("   -> Introduzca los minutos (entre 0 y 59): ");
        int m = teclado.nextInt();
        // 2. Una vez leidos los datos de horas y minutos desde el teclado:
        // (a) Compruebe si son correctos (0<=h<24 y 0<=m<60) 
        // (b) Si lo son debe debe mostrar por pantalla el mensaje "Datos correctos!!"
        //     y llamar al metodo cambiarSesionMas60 con los valores introducidos para 
        //     modificar, si es el caso, la sesion.
        // (c) Si los datos no fueran correctos debe mostrar por pantalla 
        //     el mensaje "Datos incorrectos!!"
        
        /* COMPLETAR */ 
        
        if (h >= 0 && h < 24 && m >= 0 && m < 60) {
            System.out.println("Datos correctos!!");
            Hora nueva = new Hora(h, m);
            a.cambiarSesionMas60(nueva);
        }
        else {
            System.out.println("Datos incorrectos!!");        
        }
  }
}