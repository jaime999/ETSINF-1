/**
 * Clase Hora. 
 * 
 *  @author (IIP. Grado en Informatica. ETSINF, UPV) 
 *  @version (Curso 2015-16)
 */
public class Hora {

    // ATRIBUTOS:
    private int h;
    private int m;

    // CONSTRUCTORES:
    /**
     *  Hora correspondiente a las hh horas y mm minutos.
     *  Precondicion: 0<=hh<24, 0<=mm<60.
     */
    public Hora(int hh, int mm) {
        this.h=h;
        m=mm;
    }
    /**
     * Hora (horas y minutos) actual UTC (tiempo coordinado universal).
     */
    public Hora(){
        //minutos trnscurridos desde el inicio del 1970
        long t = System.currentTimeMillis() / 60000;
        //minutos transcurridos el día de hoy
        int mA = (int) (t % (60*24));
        //horas completas del día de hoy
        int hA = mA / 60;
        //minutos no pertenecientes a horas completas del día
        mA = mA % 60;
        //no usamos this porque debería ser la primera instruccion
        h=hA;
        m=mA;
    }
    // CONSULTORES Y MODIFICADORES:
    /** Devuelve las horas de la Hora. */ 
    public int getHoras(){
        return h;
    }

    /** Devuelve los minutos de la Hora. */ 
    public int getMin(){
        return m;
    }
   
    /** Modifica las horas de la Hora. */ 
    public void setHoras(int h){
        this.h=h;
    }
    /** Modifica los minutos de la Hora. */ 
    public void setmMin(int m){
        this.m=m;
    }
    // OTROS METODOS:
    /** Devuelve la hora en formato "hh:mm".
     */
    public String toString(){
    String h2D = "0" + h;
    h2D = h2D.substring(h2D.length() - 2);
   
    String m2D = "0" + m;
    m2D = m2D.substring(m2D.length() - 2);
    
    return h2D + ":" + m2D;
   }
    /** Devuelve true sii o es una Hora que coincide en horas
     *  y minutos con la Hora.  
     */
    public boolean equals (Object o){
        return o instanceof Hora &&
               ((Hora) o).h == this.h &&
               ((Hora) o).m == this.m;
    }
      
    /** Devuelve el numero de minutos transcurridos
     *  desde las 00:00 hasta la Hora.
     */
     public int aMinutos(){
        return m + 60*h;
    }
    
    /** Compara cronologicamente la Hora y otraHora. El resultado es un valor:
     *     - negativo si la Hora es anterior a otraHora,
     *     - cero si son iguales,
     *     - positivo si la Hora es posterior a otraHora.
     */
    public int compareTo (Hora otraHora){
        // si this > otraHora
        return this.aMinutos()-otraHora.aMinutos();
        
       
        
        
    // ACTIVIDAD EXTRA:
    /** Devuelve una Hora a partir de la descripcion textual en formato "hh:mm".
     */
    
  
   }
}