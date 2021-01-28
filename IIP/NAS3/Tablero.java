
/**
 * Write a description of class Tablero here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tablero
{
   Jugador jugador1, jugador2;
   String[][] casillas = new String[63][63];
   int[] ocas = new int[15];
   
   public Tablero() {
       jugador1 = null;
       jugador2 = null;
       
       ocas[0] = 0;
       ocas[1] = 4;
       ocas[2] = 9;
       ocas[3] = 13;
       ocas[4] = 17;
       ocas[5] = 22;
       ocas[6] = 26;
       ocas[7] = 31;
       ocas[8] = 35;
       ocas[9] = 40;
       ocas[10] = 44;
       ocas[11] = 49;
       ocas[12] = 53;
       ocas[13] = 58;
       ocas[14] = 62;
       for (int i = 0; i<63; i++)  {
           if(i+1<10) {
               casillas[0][i] = i+1 + "  ";
            }
            
           else {
               casillas[0][i] = i+1 + " ";
            }
           
           if(i==0 || i==4 || i==9 || i==13 || i==17 || i==22
                || i==26 || i==31 || i==35 || i==40 || i==44
                || i==49 || i==53 || i==58 || i==62) {
                    casillas[1][i] = "O  ";
                }
                
           else if (i==5 || i==11) {
               casillas[1][i] = "P  ";
            }
            
           else if (i== 18 || i==30) {
               casillas[1][i] = "T  ";
            }
            
           else if (i==25 || i==52) {
               casillas[1][i] = "D  ";
            }
            
           else if(i==41) {
               casillas[1][i] = "L  ";
            }
            
           else if(i==51) {
               casillas[1][i] = "C  ";
            }
            
           else if(i==57) {
               casillas[1][i] = "M  ";
            }
            
           else {
               casillas[1][i] = "X  ";
            }
        }
    }
    
   public void añadirJugadores(Jugador j1, Jugador j2) {
       jugador1 = j1;
       jugador2 = j2;
    }
   
   public String toString() {
       String res = "";
       for (int i = 0; i<casillas.length; i++) {
           res += casillas[0][i];
        }
       res += "\n";
       
       for (int i = 0; i<casillas.length; i++) {
           res += casillas[1][i];
        }
        
       return res;
    }
    
   public int moverFicha(int p, int t) {
       int posicionFinal = p;
       if (posicionFinal + t > 62) {
           int res = 62 - p;
           posicionFinal = 62 - (t-res);
        }
       
        else {
            posicionFinal = p + t;
        }                
               
       return posicionFinal;
    }
    
   public int accionCasilla(int p) {
          for(int i = 0; i<ocas.length-1; i++) {
           if(p==ocas[i]) {
               System.out.println("De oca a oca y tiro porque me toca");
               return ocas[i+1];
            }
        }
        
        if (p==5) {
            System.out.println("De puente a puente y tiro porque me lleva la corriente");
            return 11;
        }
        
        if (p==11) {
            System.out.println("De puente a puente y tiro porque me lleva la corriente");
            return 5;
        }
        
        if (p==25) {
            System.out.println("De dado a dado y tiro porque me ha tocado");
            return 52;
        }
        
        if (p==52) {
            System.out.println("De dado a dado y tiro porque me ha tocado");
            return 25;
        }
        
        if (p==40) {
            System.out.println("Del laberinto al 30");
            return 29;
        }
        
        if (p==57) {
            System.out.println("Has caído en la calavera, vuelves al principio");
            return 0;
        }

        
        return p;
    }
}
