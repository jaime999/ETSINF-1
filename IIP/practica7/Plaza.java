/** Clase Plaza: define la ocupacion de una plaza de parking.
  * @author IIP
  * @version Curso 2015/2016
  */
public class Plaza {
    
    // ATRIBUTOS
    private String matricula;
    private Hora horaEntrada;
    private int planta, plaza;   

    /** Constructor que inicializa una plaza de parking vacia
      * con un numero de planta y un numero de plaza dados.
      * @param p int numero de planta de la plaza.
      * @param n int numero de plaza.
      */
    public Plaza(int p, int n){
        planta = p;
        plaza = n;
        matricula = null;
        Hora horaEntrada = null;
    }

    /** Constructor que inicializa una plaza de parking ocupada.
      * @param m String con la matricula del coche que ocupa la plaza.
      * @param h Hora hora de entrada del coche.
      * @param p int numero de planta de la plaza.
      * @param n int numero de plaza.
      */
    public Plaza(String m, Hora h, int p, int n){
        matricula = m;
        horaEntrada = h;
        planta = p;
        plaza = n;
    }

    /** Devuelve la matricula.
      * @return String, matricula del coche que ocupa la 
      * plaza o null si esta vacia. 
      */
    public String getMatricula(){
        return matricula;
    }

    /** Devuelve la hora de entrada.
      * @return Hora, hora de entrada del coche en la plaza 
      * o null si esta vacia. 
      */
    public Hora getHoraEntrada(){
        return horaEntrada;
    }

    /** Devuelve el numero de planta.
      * @return int, numero de planta de la plaza.
      */
    public int getPlanta(){
        return planta;
    }

    /** Devuelve el numero de plaza.
      * @return int, numero de plaza.
      */
    public int getPlaza(){
        return plaza;
    }

    /** Actualiza la matricula.
      * @param m String que indica la matricula del coche. 
      */
    public void setMatricula(String newMatricula){
        matricula = newMatricula;
    }

    /** Actualiza la hora de entrada.
      * @param h Hora que indica la hora de entrada del coche.
      */
    public void setHoraEntrada(Hora h){
        horaEntrada = h;
    }

    /** Entra el coche en la plaza.
      * @param m String con la matricula del coche a aparcar en la plaza.
      * @param h Hora que indica la hora de entrada del coche en el parking.
      */
    public void entrarCoche(String m, Hora h){
        matricula = m;
        horaEntrada = h;
    }

    /** Saca el coche de la plaza.
      */
    public void salirCoche(){
        matricula = null;
        horaEntrada = null;
    }

    /** Comprueba si la plaza esta vacia.
      * @return boolean, true si esta vacia o false en caso contrario.
      */
    public boolean esVacia(){
        boolean res = false;
        if(matricula == null && horaEntrada == null){res = true;}
        return res;
    }

    /** Devuelve un String representando la plaza.<br>
      * Formato: "Coche con matricula MATRICULA en plaza PLANTA-PLAZA, 
      * entrada a las HORAENTRADA".<br>
      * Si la plaza esta vacia, "No hay ningun coche en esta plaza".
      * @return String, representacion de la plaza.
      */
    public String toString(){
        String res ="No hay ningun coche en esta plaza";
        if(!esVacia()){
            res = "Coche con matricula " + matricula + " en plaza " 
            + planta + "-" + plaza + ", entrada a las " 
            + horaEntrada.toString();
        }
        return res;
    }
}
