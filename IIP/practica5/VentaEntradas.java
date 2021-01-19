
import java.util.Scanner;
import java.util.Locale;

/** Clase VentaEntradas.
 *  Practica 5 - IIP - ETSINF-UPV.
 *  
 *  @author
 *  @version Curso 2015/16
 */
public class VentaEntradas {

    public static void main(String []args) {
        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
        
        // Lectura de los datos de la entrada
        System.out.println("Caracteristicas de la entrada: ");
        System.out.print("   Titulo: ");
        String titulo = teclado.nextLine();
        /* A COMPLETAR: Lectura del RESTO de datos de la Entrada */
        System.out.print("   Cine    ");
        String cine = teclado.nextLine();
        
        System.out.print("   Hora de la sesión   ");
        int hs  = teclado.nextInt();
        System.out.print("   Minuto de la sesión   ");
        int ms  = teclado.nextInt();
        
        
        
        // Creacion de la Entrada
        Entrada e = new Entrada(titulo, cine, hs, ms);
    
        // Lectura de los datos para aplicar descuentos
        // variables a utilizar inicializadas por defecto a false:
        boolean diaEspec = false, festivo = false, 
                vispera = false, tCliente = false;
                
        System.out.print("   Edad ");
        int edad = teclado.nextInt(); teclado.nextLine();
        
        System.out.print("   Es el día del espectador? (SI/NO) "); 
        String res = teclado.next().toUpperCase(); 
        if (res.equals("SI")) { diaEspec = true; }
        else { diaEspec = false; }
        /* A COMPLETAR: Lectura del RESTO de datos para aplicar DESCUENTOS */
        
        System.out.print("   Es festivo? (SI/NO)");
        String res2 = teclado.next().toUpperCase();
        if (res2.equals("SI")) {festivo = true;}
        else { festivo = false; };
        
        System.out.print("   Es víspera de festivo? (SI/NO)");
        String res3 = teclado.next().toUpperCase();
        if (res3.equals("SI")) {vispera = true;}
        else { vispera = false; };
        
        System.out.print("   Tiene tarjeta cliente? (SI/NO)");
        String res4 = teclado.next().toUpperCase();
        if (res4.equals("SI")) { tCliente = true;}
        else { tCliente = false; };
        
        
        

        // Calculo del precio final de la Entrada e, 
        // invocando al metodo precioFinal
        double pFin = e.precioFinal(edad, diaEspec, festivo, 
                              vispera, tCliente);
                      
    
        // Mostrar por pantalla el precio final
        System.out.println("El precio final para la entrada es: " 
                           + String.format("%.2f", pFin) + " euros");
    }
}