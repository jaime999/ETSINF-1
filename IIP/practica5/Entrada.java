
/**
 *  Clase Entrada. 
 *  Practica 5 - IIP - ETSINF-UPV.
 *  
 *  @author
 *  @version Curso 2015/16
 */
public class Entrada {
    // Definicion de constantes para el calculo del precio de la entrada:
    // Precio Base a partir del cual se calcula el precio final
    public static final double PRECIO_BASE = 7.60;
    // Descuento por espectador mayor de 65 anyos (SENIOR)    
    public static final int SENIOR = 65;
    public static final double DTO_SENIOR = 0.3;
    
    // Descuento por ser el dia del espectador        
    public static final double DTO_DIA_ESPECTADOR = 0.8;
    
    // Descuento por ser festivo
    public static final double DTO_FESTIVO = 1.2;
    
    // Descuento por ser vispera de festivo
    public static final double DTO_VISPERA = 1.1;
    
    // Descuento por ser cliente
    public static final double DTO_CLIENTE = 0.8;
    
    //   // Definicion de ATRIBUTOS de INSTANCIA PRIVADOS
    private String titulo;
    private String cine;
    private Hora horaSesion;

   /** Crea una Entrada con titulo t, cine c, horas hs,
   *  y minutos ms de la sesion.
   */
    public Entrada(String t, String c, int hs, int ms) {
       titulo = t;
       cine = c;
       horaSesion = new Hora(hs, ms);
       
    }

    /** Devuelve el <b>titulo</b> de la pelicula de la Entrada. */
    public String getTitulo() { return titulo; }
 
     /** Devuelve el <b>cine</b> de la entrada. */
    public String getCine() { return cine; }

     /** Devuelve la <b>hora</b> de la sesion de la Entrada. */
    public Hora getHoraSesion() { return horaSesion; }

    /** Actualiza a <b>t</b> el titulo de la pelicula de la Entrada. */
    public void setTitulo(String t) { titulo = t; }

    /** Actualiza a <b>c</b> el cine de la Entrada. */
    public void setCine(String c) { c = cine; }

    /** Actualiza a <b>hs</b> la hora de la sesion de la Entrada. */
    public void setHoraSesion(Hora hs) { Hora horaSesion = new Hora(); }

    /** Devuelve un String con los datos de la Entrada.
     * El formato de la salida sigue el siguente ejemplo: 
     *   "Anochece en La India", proyectada en Cines Babel, a las 22:30
     *   Precio base: 7.60 euros
     */
    public String toString() {
        return "\"" + titulo + "\", proyectada en " + cine + ", a las " 
            + horaSesion + "\nPrecio base: " + PRECIO_BASE + " euros";
    }

    /** Comprueba si o es una Entrada con los mismos datos que la Entrada actual. */
    public boolean equals(Object o) {
        return o instanceof Entrada &&
        this.titulo.equals( ( (Entrada) o).titulo) &&
        this.cine.equals( ( (Entrada) o).cine) &&
        this.horaSesion.equals( ( (Entrada) o).horaSesion);
    }
  
     /** Calcula el precio final de la Entrada aplicando al precio base los 
      *  descuentos segun la edad del espectador, el dia de la sesion 
      *  (espectador, festivo o vispera) y si tiene tarjeta de cliente o no.
      */
    public double precioFinal(int edad, boolean diaEspec, boolean festivo, 
                              boolean visp, boolean tjtaCliente) {
        double precio = PRECIO_BASE;
        if (edad >= SENIOR) 
        precio = precio * DTO_SENIOR; 
            
        if (diaEspec)  
        precio = precio * DTO_DIA_ESPECTADOR;
        
        if (festivo)
        precio = precio * DTO_FESTIVO;
                
        if (tjtaCliente)
        precio = precio * DTO_CLIENTE;
                                        
        if (visp)
        precio = precio * DTO_VISPERA;                            
        
        return precio;
       
    }        
}
