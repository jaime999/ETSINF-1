import java.util.Scanner;
import java.util.Locale;
import java.io.File;
/** Clase Parking: representa un conjunto de plantas de un parking junto con 
  * el coste por minuto.
  * @author IIP
  * @version Curso 2015/2016
  */
public class Parking {
  
    // ATRIBUTOS
    private Planta[] plantas;
    private int numPlazas;
    private double coste;    
    
    /** Constructor que crea un parking a partir del numero de plantas, 
      * numero de plazas por planta, y coste en euros por minuto.
      * El parking, al comienzo, esta vacio.
      * @param p int numero de plantas, p > 0.
      * @param n int numero de plazas por planta, n > 0.
      * @param c double coste en euros por minuto, c > 0.
      */
    public Parking(int p, int n, double c){
        plantas = new Planta[p];
        numPlazas = n;
        coste = c;
        for(int i = 0; i < p; i++) {
            plantas[i] = new Planta(i, n);
        }
    }

    /** Constructor que crea un parking a partir de los datos de un fichero 
      * cuyo nombre se pasa como parametro.<br>
      * Formato del fichero:
      * <pre>
      * plantas plazas
      * coste
      * planta matricula horas minutos
      * ...
      * planta matricula horas minutos
      * </pre>
      * Los datos son correctos (no hay coches ni plazas repetidos, 
      * plantas no completas y correctas, 
      * y horas correctas). 
      * @param nomFich String nombre del fichero con los datos.
      * @throws Exception si ocurre algun error de entrada/salida.
      */
    public Parking(String nomFich) throws Exception {
        Scanner in = new Scanner(new File(nomFich)).useLocale(Locale.US);
        int p = in.nextInt(), n = in.nextInt(); 
        double c = in.nextDouble();

        plantas = new Planta[p];
        for (int i = 0; i < p; i++) {
            plantas[i] = new Planta(i, n);
        }
        numPlazas = n;
        coste = c;

        String mat; 
        int h, m;
        while (in.hasNext()) {
            p = in.nextInt(); 
            mat = in.next(); 
            h = in.nextInt(); 
            m = in.nextInt();
            plantas[p].entrarCoche(mat, new Hora(h, m));
        }

        in.close();
    }

    /** Devuelve el numero de plantas.
      * @return int, numero de plantas del parking.
      */
    public int getNumPlantas() { 
        return plantas.length;
    }

    /** Devuelve el numero de plazas por planta.
      * @return int, numero de plazas por planta en el parking.
      */
    public int getNumPlazas() {
        return numPlazas;
    }

    /** Devuelve el coste.
      * @return double, coste del parking (euros/minuto).
      */
    public double getCoste() {
        return coste;
    }

    /** Actualiza el coste.
      * @param c double nuevo coste (euros/minuto) del parking, c > 0.
      */
    public void setCoste(double c) {
        coste = c;
    }
  
    /** Verifica si el parking esta lleno
      * @return boolean true si lleno, false si no
      */
    public boolean estaLleno() {
        boolean res = true;
        for( int i = 0; res && i < plantas.length; i++) {
            if(!plantas[i].estaLlena()){res = false;}
        }
        return res;
    }
    // ==== Emplea Planta.esVacia() ====

    /** Entra un coche dados su matricula, su hora de entrada 
      * y un numero de planta de preferencia, 
      * y devuelve la plaza donde el coche entra, 
      * o null en otro caso. Precondicion: coche no presente.
      * Si la planta de preferencia no esta disponible, 
      * busca plazas libres en las plantas mas cercanas.
      * @param m String matricula del coche a entrar.
      * @param h Hora hora de entrada del coche.
      * @param p int planta de preferencia.
      * @return Plaza si el coche entra, o null en caso contrario.
      */
    public Plaza entrarCoche(String m, Hora h, int p) {
        Plaza res = null;
        int max = max(plantas.length , p);
        if(!estaLleno()){
            boolean end = false;
            int aux;
            for(int i = 0; !end && i < max; i++) {
                aux = p + i;
                if(aux < plantas.length && !plantas[aux].estaLlena()) {
                    res = plantas[aux].entrarCoche(m, h);
                    end = true;
                }
                else {
                    aux = p - i;
                    if(aux > -1 && !plantas[aux].estaLlena()) {
                        res = plantas[aux].entrarCoche(m, h);
                        end = true;
                    }
                }
            }
        }
        return res;
    }
    
    public int max( int length, int p) {
        int res;
        int aux = 0;
        if(length % 2 == 1) { res = (length / 2)+ 1 + Math.abs(p - length / 2);}
        else {
            if(p >= length / 2){ aux = 1;}            
            res = (length / 2) + Math.abs(p + aux - length / 2);
        }
        return res;
    }
    // ==== Emplea Planta.entrarCoche(String, Hora) ====

    /** Comprueba sie un coche de matricula dada esta en el parking. 
      * @param m String matricula del coche a buscar.
      * @return Plaza, plaza ocupada por el coche, si se encuentra, 
      * o null si no se encuentra.
      */
    public Plaza buscarCoche(String m) {
        Plaza res = null;
        for(int i = 0; res == null && i < plantas.length; i++) {
                res = plantas[i].buscarCoche(m);
        }
        return res;
    }
    // ==== Emplea Planta.buscarCoche(String) ====

    /** Saca el coche del parking y devuelve su coste.
      * @param m String matricula del coche a salir. Precondicion: siempre esta.
      * @param h Hora hora de salida del coche. 
      *   Precondicion: posterior a la hora de entrada.
      * @return double, coste en euros a pagar.
      */
    public double salirCoche(String m, Hora h) {
        double res = 0;
        res = coste * plantas[buscarCoche(m).getPlanta()].salirCoche(m, h);
        return res;
    }
    // ==== Emplea Planta.buscarCoche(String) y 
    //      Planta.sacarCoche(String, Hora) ====

    /** Vacia todo el parking, suponiendo que son las 23:59, 
      * y calcula y devuelve el coste total.
      * @return double, coste total en euros a pagar por todos los coches 
      *   que salen del parking.
      */
    public double vaciarParking() {
        double res = 0;
        Hora h = new Hora(23, 59);
        for(int i = 0; i < plantas.length; i++) {
            res += plantas[i].vaciarPlanta(h);
        }
        return res * coste;
    }
    // ==== Emplea Planta.vaciarPlanta(Hora) ====
  
    /** Devuelve un String que representa la ocupacion del parking, 
      * con 'X' ocupada, ' ' libre.
      * Debe colocar un encabezamiento con los numeros de 
      * plaza correspondientes.<br>
      * Ejemplo: <pre>
      *          "      0   1   2   3   4 
      *             0   X   X       X    
      *             1       X   X       X
      *             2   X   X             " </pre>
      * @return String, representacion del parking.
      */
    public String toString() {
        String res = "   ";
        for(int i = 0; i < numPlazas; i++) {res += "   " + i;}
        res += " \n";
        for(int k = 0; k < plantas.length; k++) {
            res += plantas[k].toString();
        }
        return res;
    }
    // ==== Emplea Planta.toString() ====

}
