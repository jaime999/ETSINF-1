/**
 * Clase Hora. 
 * 
 *  @author (IIP. Grado en Informatica. ETSINF, UPV) 
 *  @version (Curso 2015-16)
 */
public class Hora {
    private static final int MS_POR_DIA = 24 * 3600 * 1000;
    private int h;
    private int m;

    /**
     *  Hora correspondiente a las hh horas y mm minutos.
     *  Precondicion: 0<=hh<24, 0<=mm<60.
     */
    public Hora(int hh, int mm) {
        this.h = hh;
        this.m = mm;
    }
 
    /**
     * Hora (horas y minutos) actual UTC (tiempo coordinado universal)
     */
    public Hora() {   
        //long t =  (System.currentTimeMillis() % (24 * 3600 * 1000));
        long t =  System.currentTimeMillis() % MS_POR_DIA;
        this.h = (int) (t / (3600 * 1000));
        this.m = (int) (t % (3600 * 1000)) / (60 * 1000); 
    }
    
    /** Devuelve las horas de la Hora */ 
    public int getHoras() { return this.h; }

    /** Devuelve los minutos de la Hora */ 
    public int getMin() {  return this.m; }
   
    /** Actualiza a hh las horas de la Hora */ 
    public void setHoras(int hh) { this.h = hh; }
   
    /** Actualiza a mm los minutos de la Hora */ 
    public void setMin(int mm) { this.m = mm; }
   
    /** Devuelve la Hora en formato "hh:mm" */
    public String toString() {
        String hh = "0" + this.h;
        hh = hh.substring(hh.length() - 2);
        String mm = "0" + this.m;
        mm = mm.substring(mm.length() - 2);
        return hh + ":" + mm;
    }
   
    /** Devuelve el numero de minutos transcurridos 
     *  desde las 00:00 hasta la la Hora */
    public int aMinutos() { return this.h * 60 + this.m; }
    
    /** Compara cronologicamente la Hora y otraHora. El resultado es un valor:
     *     - negativo si la Hora es anterior a otraHora,
     *     - cero si son iguales,
     *     - positivo si la Hora es posterior a otraHora.
     */
    public int compareTo(Hora otraHora) {
        int actualMinutos = this.aMinutos();
        int otraHoraMinutos = otraHora.aMinutos();
        return actualMinutos - otraHoraMinutos;
    }

    /** Devuelve true sii o es una Hora que coincide
     *  en horas y minutos con la Hora */
    public boolean equals(Object o) {
        return o instanceof Hora
            && this.h == ((Hora) o).h
            && this.m == ((Hora) o).m;
    }  
}
