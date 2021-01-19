/**
 * Clase Hora. 
 * 
 *  @author (              ) 
 *  @version (Curso 2014-15)
 */
public class Hora
{
    // ATRIBUTOS:
    private int h;
    private int m;
    // CONSTRUCTORES:
   /**
    *  Hora correspondiente a las hor horas y min minutos.
    *  Precondicion: 0<=hor<24, 0<=min<60.
    */
    public Hora(int hor,int min) {
       m = min;
       h = hor;
    }
   
    /**
     * Hora (horas y minutos) actual UTC (tiempo coordinado universal).
     */
    public Hora(){
       long t = System.currentTimeMillis () % (24*3600*1000);
       int tRestante = (int) (System.currentTimeMillis() % (24*3600*1000));
       int segundos = tRestante/1000;
       m = segundos/60;
       h = m/60;
       m = m % 60;
    }
    
    // CONSULTORES Y MODIFICADORES:
   /** Consulta las horas de la Hora */ 
   public int getHora() {
       return h;
    }

   /** Consulta los minutos de la Hora */ 
   public int getMin() {
       return m;
    }
   
   /** Modifica las horas de la Hora */ 
   public void setHora(int hor){
       this.h = hor;
    }
   
   /** Modifica los minutos de la Hora */ 
   public void  setMin(int min){
       this.m = min;
    }
   
   // OTROS METODOS:
   /** Devuelve la hora en formato "hh:mm".
   */
   public String toString(){
       String hh = "0" +h;
       int longitudh = hh.length();
       hh = hh.substring(longitudh-2);
       String mm = "0" +m;
       int longitudm = mm.length();
       mm = mm.substring(longitudm-2);
       return (hh + ":" + mm);
    }
   
   /** Devuelve el numero de minutos transcurridos Desde las 00:00 hasta la Hora */
   public int aMinutos(){
       int aMinutos = m + h * 60;
       return (aMinutos);
    }

    /** Compara cronologicamente la Hora y hor. El resultado es un valor:
   *     - negativo si la Hora es anterior a hor,
   *     - cero si son iguales,
   *     - positivo si la Hora es posterior a hor.
   */
  
   public int compareTo (Hora otraHora){
        return this.aMinutos()-otraHora.aMinutos();
    }

   

  /** Devuelve true sii o y la Hora son dos horas iguales. 
   */
   public boolean equals (Object o){
        return o instanceof Hora &&
               ((Hora) o).h == this.h &&
               ((Hora) o).m == this.m;
    }
      
  // ACTIVIDAD EXTRA:      
  /** Devuelve una hora a partir de la descripcion 
   *  textual en formato "hh:mm".
   */ 
}
