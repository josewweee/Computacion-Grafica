
package retoscomputaciongrafica2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author CRISTIAN FRANCO
 * @author FELIPE GARCÍA
 */
public class RetosComputacionGrafica2 extends JPanel{
    
    Algoritmos algoritmo = new Algoritmos();
    String entradaTeclado = "";

    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 500;
    public static int Xmin = 125;
    public static int Xmax = 375;
    public static int Ymin = 125;
    public static int Ymax = 375;
    
    public int getxMin() {
        return Xmin;
    }

    public void setxMin(int xMin) {
        this.Xmin = xMin;
    }

    public int getxMax() {
        return Xmax;
    }

    public void setxMax(int xMax) {
        this.Xmax = xMax;
    }

    public int getyMin() {
        return Ymin;
    }

    public void setyMin(int yMin) {
        this.Ymin = yMin;
    }

    public int getyMax() {
        return Ymax;
    }

    public void setyMax(int yMax) {
        this.Ymax = yMax;
    }
        
        
    @Override
    public void paintComponent(Graphics g) {
        System.out.println("Empezamos el programa");
        System.out.println("------> Introducir:");
        System.out.println("0 ------> LIANG - BARSKY");
        System.out.println("1 ------> Cohen - Sutherland");
        System.out.print("NÚMERO DEL ALGORITMO ELEGIDO = ");
        
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        
        
        int option = Integer.parseInt(entradaTeclado);
        double inicia = System.currentTimeMillis();
        super.paintComponent(g);
        
        Graphics2D g2d;// = (Graphics2D) g;
        g2d = (Graphics2D) g;
        
        
                            //EJECUCIÓN DE LIANG - BARSKY
        switch (option) {
            case 0:
                int one = 0;
                int two = 500;
                for(int i = 0; i < 10; i++){
                    int x0 = (int) Math.floor(Math.random() * (one - (two + 1)) + (two));
                    int y0 = (int) Math.floor(Math.random() * (one - (two + 1)) + (two));
                    int x1 = (int) Math.floor(Math.random() * (one - (two + 1)) + (two));
                    int y1 = (int) Math.floor(Math.random() * (one - (two + 1)) + (two));
                    algoritmo.liangBarsky(x0, y0, x1, y1, g2d);
                }
                
                break;
                            // EJECUCIÓN DE COHEN - SUTHERLAND
            case 1:
                setxMin(getWidth() / 2 - 125);
                setxMax(getWidth() / 2 + 125);
                setyMin(getHeight() / 2 - 125);
                setyMax(getHeight() / 2 + 125);
                Random r = new Random();
                // Se crea el arreglo que tiene los puntos con los interceptos que se deben pintar
                int puntosLinea[];
                for (int i = 0; i < 10000; i++) {
                    
                    int x0 = Math.abs(r.nextInt());
                    int y0 = Math.abs(r.nextInt());
                    int x1 = Math.abs(r.nextInt());
                    int y1 = Math.abs(r.nextInt());
                    
                    puntosLinea = algoritmo.cohenSutherland(x0 % getWidth(), y0 % getHeight(), x1 % getWidth(), y1 % getHeight());
                    // si no hay puntos de intersección, pinta las lineas normal
                    if (puntosLinea == null) {
                        g2d.setColor(Color.red);
                        g2d.drawLine(x0 % getWidth(), y0 % getHeight(), x1 % getWidth(), y1 % getHeight());
                    } else {
                        g2d.setColor(Color.red);
                        //desde los puntos iniciales pinta de rojo hasta los puntos de intersección iniciales
                        g2d.drawLine(x0 % getWidth(), y0 % getHeight(), puntosLinea[0] % getWidth(), puntosLinea[1] % getHeight());
                        //desde los puntos finales de intersección pinta hasta el final de la linea
                        g2d.drawLine(puntosLinea[2] % getWidth(), puntosLinea[3] % getHeight(), x1 % getWidth(), y1 % getHeight());
                        
                        //Pinta la parte de la línea que esta adentro
                        g2d.setColor(Color.blue);
                        g2d.drawLine(puntosLinea[0] % getHeight(), puntosLinea[1] % getHeight(), puntosLinea[2] % getHeight(), puntosLinea[3] % getHeight());
                    }
                }   break;
            default:
                return;
        }
        
        int termina = (int) (System.currentTimeMillis()/1000);
        
        System.out.println(inicia);
        System.out.println(termina);
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("RETO 2 COMPUTACIÓN GRÁFICA");
        
        // Al cerrar el frame, termina la ejecuciÛn de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new RetosComputacionGrafica2());
        
        // Asignarle tamaño
        frame.setSize(500, 500);
        
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        
        // Mostrar el frame
        frame.setVisible(true);
        
           
    }
    
}
