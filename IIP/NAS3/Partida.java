
/**
 * Write a description of class Partida here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Partida
{
    public static void main(String[] args) {
        Tablero miTablero = new Tablero();
        
        Jugador jugador1 = new Jugador("Jaime");
        Jugador jugador2 = new Jugador("Pedro");
        
        miTablero.añadirJugadores(jugador1, jugador2);
        System.out.println(miTablero.toString());
        
        int tirada, posicionReal, nuevaPosicion, turnosPerdidosJ1 = 0, turnosPerdidosJ2 = 0;
        boolean turno = true;
        while(true) {
            if(turnosPerdidosJ1 != 0) { turnosPerdidosJ1--; turno = false; }
                while(turno && turnosPerdidosJ1 == 0) {
                tirada = (int) (Math.random() * (7 - 1)) + 1;
    
                System.out.println("El jugador " + jugador1.nombre + " ha sacado " + tirada);
                
                jugador1.posicion = miTablero.moverFicha(jugador1.posicion, tirada);
                nuevaPosicion = jugador1.posicion;
                
                posicionReal = nuevaPosicion + 1;
                System.out.println("El jugador ahora está en la casilla " + posicionReal);
                int res = miTablero.accionCasilla(nuevaPosicion);
                if(res != nuevaPosicion) {                    
                    jugador1.posicion = res;
                    posicionReal = res + 1;
                    System.out.println("El jugador ahora está en la casilla " + posicionReal);
                }
                
                else { 
                    if (res == 18 || res == 30) {
                        System.out.println("El jugador " + jugador1.nombre + " pierde 2 turnos");
                        turnosPerdidosJ1 = 2;
                    }
                    
                    else if (res == 51) {
                        System.out.println("El jugador " + jugador1.nombre + " pierde 3 turnos");
                        turnosPerdidosJ1 = 3;
                    }
                    turno = false;
                }
                
                if(jugador1.haGanado()) {
                    System.out.println("El jugador " + jugador1.nombre + " ha ganado");
                    return;
                }
            }
            
            if(turnosPerdidosJ2 != 0) { turnosPerdidosJ2--; turno = true; }
                while (!turno && turnosPerdidosJ2 == 0) {
            
                tirada = (int) (Math.random() * (7 - 1)) + 1;
    
                System.out.println("El jugador " + jugador2.nombre + " ha sacado " + tirada);
                
                jugador2.posicion = miTablero.moverFicha(jugador2.posicion, tirada);
                nuevaPosicion = jugador2.posicion;
                
                posicionReal = nuevaPosicion + 1;
                
                System.out.println("El jugador ahora está en la casilla " + posicionReal);
                int res = miTablero.accionCasilla(nuevaPosicion);
                if(res != nuevaPosicion) {                    
                    jugador2.posicion = res;
                    posicionReal = res + 1;
                    System.out.println("El jugador ahora está en la casilla " + posicionReal);
                    
                    if(res == 0) { turno = false; }
                }
                
                else { 
                    if (res == 18 || res == 30) {
                        System.out.println("El jugador " + jugador2.nombre + " pierde 2 turnos");
                        turnosPerdidosJ2 = 2;
                    }    
                    
                    else if (res == 51) {
                        System.out.println("El jugador " + jugador2.nombre + " pierde 3 turnos");
                        turnosPerdidosJ2 = 3;
                    }
                    turno = true;
                }              
                
                if(jugador2.haGanado()) {
                    System.out.println("El jugador " + jugador2.nombre + " ha ganado");
                    return;
                }
                
            }                        
            
        }
                    
    }        
}
