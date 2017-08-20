
package retoscomputaciongrafica2;

import java.awt.Color;
import java.awt.Graphics2D;


/**
 *
 * @author CRISTIAN FRANCO
 * @author FELIPE GARCÍA
 * @author Andres Reyes
 */
public class Algoritmos {
    
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 500;
    public static int Xmin = 125;
    public static int Xmax = 375;
    public static int Ymin = 125;
    public static int Ymax = 375;
    
    private final int ADENTRO = 0; 
    private final int IZQUIERDA = 1;   
    private final int DERECHA = 2;  
    private final int ABAJO = 4; 
    private final int ARRIBA = 8;    
    
    
    
    
    public void liangBarsky(int x0, int y0, int x1, int y1, Graphics2D g2d){
        System.out.println("\nEjecutando Algoritmo Liang-Barsky");
        double u1 = 0, u2 = 1;
        int dx = x1 - x0, dy = y1 - y0;
        int p[] = {-dx, dx, -dy, dy};
        int q[] = {x0 - Xmin, Xmax - x0, y0 - Ymin, Ymax - y0};
        for(int i = 0; i < 4; i++){
            if(p[i] == 0){
                if(q[i] < 0){
                    return;
                }
            } 
            else{
                double u = (double) q[i] / p[i];
                if(p[i] < 0){
                    u1 = Math.max(u, u1);
                } 
                else{
                    u2 = Math.min(u, u2);
                }
            }
        }
        if(u1 > u2){
            return;
        }
        int nx0, ny0, nx1, ny1;
        nx0 = (int) (x0 + u1 * dx);
        ny0 = (int) (y0 + u1 * dy);
        nx1 = (int) (x0 + u2 * dx);
        ny1 = (int) (y0 + u2 * dy);
        g2d.setColor(Color.RED);
        g2d.drawLine(x0,y0,nx0,ny0);
        g2d.setColor(Color.BLUE);
        g2d.drawLine(nx0, ny0, nx1, ny1);
    
    }


    private int obtenerUbicacion(int x, int y) {

        int ubicacion = ADENTRO;

        if (x < Xmin) {
            ubicacion |= IZQUIERDA;
        } else if (x > Xmax) {
            ubicacion |= DERECHA;
        }
        if (y < Ymin) {
            ubicacion |= ARRIBA;
        } else if (y > Ymax) {
            ubicacion |= ABAJO;
        }
        return ubicacion;
    }

    
    
    public int[] cohenSutherland(int x0, int y0, int x1, int y1) {
        System.out.println("\nEjecutando Algoritmo Cohen-Sutherland");
        int ubicacionInicial = obtenerUbicacion(x0, y0);
        int ubicacionFinal = obtenerUbicacion(x1, y1);
        int puntosLinea[] = new int[4];
        boolean estaAdentro = false;

        while (true) {
            if ((ubicacionInicial | ubicacionFinal) == 0) { // punto inicial y final estan adentro del rectangulo
                estaAdentro = true;
                break;
            } else if ((ubicacionInicial & ubicacionFinal) != 0) { // hay dos puntos de intersección
                break;
            } else {
                // en las variables "x" y "y" se guardan los puntos de intersección
                int x, y;
                //variable que define desde donde pintar la linea
                int fueraDelRectangulo = (ubicacionInicial != 0) ? ubicacionInicial : ubicacionFinal;
                if ((fueraDelRectangulo & ABAJO) != 0) {
                    x = x0 + (x1 - x0) * (Ymax - y0) / (y1 - y0);
                    y = Ymax;
                } else if ((fueraDelRectangulo & ARRIBA) != 0) {
                    x = x0 + (x1 - x0) * (Ymin - y0) / (y1 - y0);
                    y = Ymin;
                } else if ((fueraDelRectangulo & DERECHA) != 0) {
                    y = y0 + (y1 - y0) * (Xmax - x0) / (x1 - x0);
                    x = Xmax;
                } else {
                    y = y0 + (y1 - y0) * (Xmin - x0) / (x1 - x0);
                    x = Xmin;
                }

                if (fueraDelRectangulo == ubicacionInicial) {
                    x0 = x;
                    y0 = y;
                    ubicacionInicial = obtenerUbicacion(x0, y0);
                } else {
                    x1 = x;
                    y1 = y;
                    ubicacionFinal = obtenerUbicacion(x1, y1);
                }
            }
        }
        if (estaAdentro) {
            puntosLinea[0] = x0;
            puntosLinea[1] = y0;
            puntosLinea[2] = x1;
            puntosLinea[3] = y1;
            return puntosLinea;
        }
        return null;
    }
    
}
    
    
