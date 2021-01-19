/**
 * La clase IIPMath implementa algunas operaciones matematicas:
 * IIPMath.sqrt(double) e IIPMath.log(double).
 *
 * @author ()
 * @version ()
 */
public class IIPMath {
    
    // A COMPLETAR
    public final static double LOG_2 = 0.6931471805599453;
        
    /**
     * Devuelve la raiz cuadrada de x >= 0, con error epsilon > 0. 
     * A COMPLETAR COMENTARIO
     */
    public static double sqrt(double x, double epsilon) {
        // A COMPLETAR
        double tAnterior;
        double tActual = (1 + x) / 2;
        
             
        double suma = 0;
        do{         
           tAnterior = tActual;
           tActual = (tAnterior + x / tAnterior) / 2;
        }    
        while((tAnterior - tActual) > epsilon);
            return tActual;
    }
    
    /**
     * Devuelve la raiz cuadrada de x >= 0 con error 1e-15. 
     * A COMPLETAR COMENTARIO
     */
    public static double sqrt(double x) {    
        // A COMPLETAR
        return sqrt(x, 1e-15);
    }  
                    
    /* ******************************************************** */
    /* ******************************************************** */
    /* ******************************************************** */
                
    /**
     * Devuelve log(z), 1/2 <= z < 1, con error epsilon > 0.
     * A COMPLETAR COMENTARIO
     */
    public static double logBase(double z, double epsilon) {
        // A COMPLETAR
        double y = (1 - z) / (1 + z); 
        double tActual = y;
        int k = 1;
        double tAnterior;
        double suma = y;         
        while (tActual > epsilon){ 
            tAnterior = tActual;
            tActual = y*y*((2*k-1)/(2*k+1.0))*tAnterior;
            suma += tActual;
            k++;           
      }
      
      return -2*suma;
    }
    
        
    /**
     * Devuelve log(x), x > 0, con error epsilon > 0.
     * A COMPLETAR COMENTARIO
     */
    public static double log(double x, double epsilon) {
        int m = 0;
        double z = x;
        
         if( x > 1/2 && x < 1){
         logBase(x, epsilon);
        }
         else {            
           while( z >= 1 ) {
            z = z/2;
            m++;
           }
     
           while( z < 0.5 ) {
            z = z * 2;
            m--;
           }
        }
        return m * LOG_2 + logBase(x, epsilon);
        
    }    
  
  
      /**
     * Devuelve log(x), x > 0, con error 1e-15.
     * A COMPLETAR COMENTARIO
     */
     public static double log(double x) {   
         int m = 0;
        double z = x;
        
         if( x > 1/2 && x < 1){
         return logBase(x, 1e-15);
        }
         else {            
           while( z >= 1 ) {
            z = z/2;
            m++;
           }
     
           while( z < 0.5 ) {
            z = z * 2;
            m--;
           }
        }
        return m * LOG_2 + logBase(z, 1e-15);                        
  }
}