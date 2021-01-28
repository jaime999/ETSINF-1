
/**
 * Write a description of class Jugador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jugador
{
    String nombre;
    int posicion = 0;
    
    
    public Jugador(String n) {
        nombre = n;
    }
    
    public boolean haGanado() {
        if(posicion == 62) {
            return true;
        }
        
        else { return false; }
    }
}
