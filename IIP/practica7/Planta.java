/** Clase Planta: representa un conjunto de plazas de parking en una planta 
  * de un parking.
  * @author IIP
  * @version Curso 2015/2016
  */
public class Planta {
  
    // ATRIBUTOS
    private Plaza[] plazas;
    private int plazasLibres;
    private int planta;

    /** Constructor que crea una Planta dados un numero de planta y un numero 
      * de plazas por planta.
      * La planta, al comienzo, esta vacia.
      * @param numPlanta int numero de planta, numPlanta >= 0.
      * @param numPlazas int numero de plazas por planta, numPlazas > 0.
      */
    public Planta(int numPlanta, int numPlazas){
        planta = numPlanta;
        plazas = new Plaza[numPlazas];
        plazasLibres = numPlazas;
        for(int i = 0; i < numPlazas; i++) {
            plazas[i] = new Plaza(planta, i);
        }
    }

    /** Devuelve el numero de planta.
      * @return int numero de planta del parking.
      */
    public int getPlanta(){return planta;}
  
    /** Devuelve el numero de plazas libres.
      * @return int numero de plazas de la planta.
      */
    public int getPlazasLibres(){return plazasLibres;}
    
    /** Devuelve si la planta esta llena.
      * @return boolean planta llena (sin plazas libres).
      */
    public boolean estaLlena(){
        boolean res = false;
        if(plazasLibres < 1){res = true;}
        return res;
    }

    /** Devuelve la primera plaza libre en la planta, o 
      * -1 si no hay plazas libres. 
      * @return int, indice de la primera plaza libre en la planta o 
      * -1 si no hay plazas libres.
      */
    public int primeraLibre(){
        int res = -1;
        boolean bBreak = false;
        for(int i = 0; i < plazas.length; i++){
            if(bBreak){break;}
            if(plazas[i].esVacia()){
                res = i;
                bBreak = true;
            }
        }
        return res;
    }
    // ==== Emplea Plaza.esVacia() ====

    /** Entra un coche en la planta y devuelve su plaza, o 
      * devuelve null cuando no hay plazas libres.
      * Precondicion: el coche no esta en la planta.
      * @param m String matricula del coche.
      * @param h Hora hora de entrada del coche.
      * @return Plaza si el coche entra o null en caso contrario.
      */
    public Plaza entrarCoche(String m, Hora h){
        Plaza res = null;
        if(!estaLlena()){
                int z = primeraLibre();
                plazas[z] = new Plaza(m, h, planta, z);
                res = plazas[z];
                plazasLibres--;
            }
        return res;
    }
    public int plazasLibres() {
        int res = 0;
        for( int i = 0; i < plazas.length; i++) {
            if( plazas[i].getMatricula() == null) { res++;}
        }
        return res;
    }
    // ==== Emplea estaLlena() y Plaza.entrarCoche(String, Hora) ====

    /** Comprueba si un coche dado esta en la planta.
      * @param m String matricula del coche a buscar.
      * @return Plaza, la plaza que ocupa el coche, si se encuentra, 
      * o null si no se encuentra.
      */
    public Plaza buscarCoche(String m) {
        Plaza res = null;
        for(int i = 0; i < plazas.length; i++) {
            if(res != null) {break;}
            if( !plazas[i].esVacia() && plazas[i].getMatricula().equals(m)) { 
                res = plazas[i];}
        }
        return res;
    }

    // ==== Emplea Plaza.esVacia() y Plaza.getMatricula() ====

    /** Saca el coche del parking, devolviendo cuantos minutos ha estado.
      * @param m String matricula del coche. Precondicion: siempre esta.
      * @param h Hora hora de salida. 
      *   Precondicion: posterior a la hora de entrada del coche.
      * @return int, numero de minutos que el coche ha estado en el parking.
      */
    public int salirCoche(String m, Hora h) {
        Plaza aux = buscarCoche(m);
        int res = h.compareTo(aux.getHoraEntrada());
        plazas[aux.getPlaza()] = new Plaza(planta, aux.getPlaza());
        plazasLibres++;
        return res;
    }
    
    // ==== Emplea buscarCoche(String), Hora.aMinutos(), 
    //      Plaza.getHoraEntrada() y Plaza.salirCoche() ====

    /** Vacia toda la planta y devuelve el numero total de minutos 
      * que los coches han permanecido 
      * en la planta hasta una hora dada.
      * @param h Hora hora en la que todos los coches deben salir. 
      *   Precondicion: posterior a la hora de entrada.
      * @return int, numero total de minutos transcurridos.
      */
    public int vaciarPlanta(Hora h) {
        int res = 0;
        for(int i = 0; i < plazas.length; i++) {
            if(plazas[i].getMatricula() != null){
                res += salirCoche(plazas[i].getMatricula(), h);
            }
        }
        return res;
    }

    // ==== Emplea Hora.aMinutos(), Plaza.esVacia(), Plaza.getHoraEntrada() 
    //      y Plaza.salirCoche() ====
  
    /** Devuelve un String con la ocupacion del parking, con 'X' ocupada, 
      * ' ' libre. <br>
      * Formato: <pre> planta (ocupando 3 posiciones), espacio, ocupacion 
      * ("  X" o "   "), espacio, ..., ocupacion ("  X" o "   "), 
      * espacio, '\n'</pre>
      * Ejemplo de formato (5 plazas): <pre> "  2   X       X   X      " </pre>
      * @return String, representacion de la ocupacion de la planta.
      */
    public String toString() {
        String res = "  " + planta + " ";
        for(int i = 0; i < plazas.length; i++){
            if(plazas[i].esVacia()) { res += "    ";}
            else { res += "  X ";}
        }
        return res + "\n";
    }

    // ==== Emplea Plaza.esVacia() ====

}
