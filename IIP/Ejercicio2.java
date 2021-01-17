import java.util.Scanner;
import java.util.Arrays;
/**
 * Write a description of class Ejercicio2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ejercicio2
{
    public static String relojDigital(String dia, int hora, int minuto, int segundo) {
        String reloj = "";
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves",
                         "Viernes", "Sábado", "Domingo"};
                         
        for (int i = 0; i<dias.length; i++) {
            if (!Arrays.stream(dias).anyMatch(dia::equals)) {
                return ("Día incorrecto");
            }
        }
        
        if (hora > 23 || hora < 0) {
            return ("Hora incorrecta");
        }
        
        if (minuto > 59 || minuto < 0) {
            return ("Minuto incorrecto");
        }
        
        if (segundo > 59 || segundo < 0) {
            return ("Segundo incorrecto");
        }
        
        for (int i = 0; i<10; i++) {            
            
            if (segundo == 60) {
                segundo = 0;               
                if (minuto == 59) {
                    minuto = 0;
                    if(hora == 23) {
                        hora = 0;
                        if (dia.equals("Domingo")) {
                            dia = "Lunes";
                        }
                        
                        else {
                            for (int j=0; j<dias.length; j++) {
                                if (dias[j].equals(dia)) {                                    
                                    dia = dias[j+1];
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        hora = hora+1;
                    }
                }
                else {
                    minuto = minuto+1;
                }                
            }
            
            System.out.println(dia + " " + String.format("%02d", hora) + ":" + String.format("%02d", minuto)
                                + ":" + String.format("%02d", segundo));
            segundo = segundo+1;
        }
        return reloj;
                        
                        
    }
    
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        System.out.println("Introduzca el día de la semana:");
        String d = t.nextLine();
        System.out.println("Introduzca la hora:");
        int h = t.nextInt();
        System.out.println("Introduzca el minuto:");
        int m = t.nextInt();
        System.out.println("Introduzca el segundo:");
        int s = t.nextInt();
        
        System.out.println(relojDigital(d, h, m, s));
    }
}
