/**
 * Clase Entrada. 
 * 
 *  @author (IIP. Grado en Informatica. ETSINF, UPV) 
 *  @version (Curso 2015-16)
 */
public class Entrada { 
    // Definicion de constantes para el calculo del precio de la entrada:
    /** Precio Base a partir del cual se calcula el precio final */
    public static final double PRECIO_BASE = 7.60;
    /** Edad senior */
    public static final int SENIOR = 65;
    /** Descuento por espectador mayor de 65 años (SENIOR) */
    public static final double DTO_SENIOR = 0.3;
    /** Descuento por ser el dia del espectador */
    public static final double DTO_DIA_ESPECTADOR = 0.8;
    /** Descuento por ser festivo */
    public static final double DTO_FESTIVO = 1.2;
    /** Descuento por ser vispera de festivo */
    public static final double DTO_VISPERA = 1.1;
    /** Descuento por ser cliente */
    public static final double DTO_CLIENTE = 0.8;
  
    private String titulo; 
    private String cine;
    private Hora horaSesion;

    /** Crea una Entrada con titulo, cine, horas y minutos 
     *  de la hora de la sesion dados
     */
    public Entrada(String t, String c, int hs, int ms) {
        titulo = t; cine = c; horaSesion = new Hora(hs, ms);
    }

    /** Devuelve el titulo de la Entrada */
    public String getTitulo() { return titulo; }

    /** Devuelve el cine de la Entrada */
    public String getCine() { return cine; }

    /** Devuelve la hora de la sesion de la Entrada */
    public Hora getHoraSesion() { return horaSesion; }

    /** Actualiza a t el titulo de la Entrada */
    public void setTitulo(String t) { titulo = t; }

    /** Actualiza a c el cine de la Entrada */
    public void setCine(String c) { cine = c; }

    /** Actualiza a hs la hora de la sesion de la Entrada */
    public void setHoraSesion(Hora hs) { horaSesion = hs; }

    /** Devuelve un String con la informacion de la Entrada */
    public String toString() {
        return "\"" + titulo + "\", proyectada en " + cine + ", a las " 
            + horaSesion + "\nPrecio base: " + PRECIO_BASE + " euros";
    }

    /** Comprueba si dos entradas son iguales, esto es, si coinciden 
     *  su titulo, cine y hora de la sesion.
     */
    public boolean equals(Object o) {
        return (o instanceof Entrada) 
            && this.titulo.equals(((Entrada) o).titulo) 
            && this.cine.equals(((Entrada) o).cine) 
            && this.horaSesion.equals(((Entrada) o).horaSesion);
    }
  
    /** Devuelve el precio final de la Entrada (redondeado a centimos de euro),
     *  segun si es el dia del espectador, si el dia es festivo, 
     *  si es vispera de festivo y si el espectador tiene tarjeta de cliente.
     */
    public double precioFinal(int edad, boolean diaEspec, boolean festivo, 
                              boolean visp, boolean tjtaCliente) {
        double res = 0.0, precioFinal = 0.0;
        if (edad >= SENIOR) { res = DTO_SENIOR * PRECIO_BASE; }
        else {
            if (diaEspec) { res = DTO_DIA_ESPECTADOR * PRECIO_BASE; }
            else {
                precioFinal = PRECIO_BASE;
                if (festivo) { precioFinal = DTO_FESTIVO * precioFinal; }
                else if (visp) { precioFinal = DTO_VISPERA * precioFinal; }
                if (tjtaCliente) { res = DTO_CLIENTE * precioFinal; }
                else { res = precioFinal; }
            }
        }
        return Math.round(res * 100) / 100.0;
    }
    
	/** Modifica la sesion de la Entrada en curso a nuevaH SOLO si 
	 *  nuevaH es posterior a la de la Entrada en curso en mas 
	 *  de 60 minutos. En caso contrario, no debera modificarla.
	 *  Recuerda que en la clase Hora esta definido el metodo aMinutos 
	 *  que devuelve el numero de minutos transcurridos desde las 00:00 
	 *  hasta la Hora en curso.
	 */
    public void cambiarSesionMas60(Hora nuevaH) {
        /* COMPLETAR */ 
        
        if (nuevaH.aMinutos() > horaSesion.aMinutos() + 60)
	    setHoraSesion(nuevaH);			    
    }
        
}
