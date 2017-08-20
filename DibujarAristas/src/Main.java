
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Main extends JPanel {

    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 800;
    
    PolygonObject po;
    PolygonObject poClip;
    /**
     * Draw the axis and the object
     * @param g 
     */
        @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        drawAxis(g2d);
        drawObject(g2d);
        
    }

    
    private void drawAxis(Graphics2D g2d) {
        /*g2d.setColor(Color.red);
        drawEdge(g2d,new Point(0, -100), new Point(0, 100));
        g2d.setColor(Color.green);
        drawEdge(g2d,new Point(-100, 0), new Point(100, 0));*/
    }
    
    
    private void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.blue);
        po.edges.stream().forEach((e) -> {
            Point p0 = e.p1;
            Point p1 = e.p2;
            drawEdge(g2d, p0, p1);
            //liangBarsky(p0,p1,g2d);
        });
        g2d.setColor(Color.black);
        poClip.edges.stream().forEach((e) -> {
            Point p0 = e.p1;
            Point p1 = e.p2;
            drawEdge(g2d, p0, p1);
        });
        g2d.setColor(Color.pink);
        po.edges.stream().forEach((e) -> {
            Point p0 = e.p1;
            Point p1 = e.p2;
            liangBarsky(p0,p1,g2d);
        });
    }
    
// -------------------- FUNCION LIAN BARSKY --------------------
    public static int Xmin = 50;
    public static int Xmax = 250;
    public static int Ymin = 50;
    public static int Ymax = 150;
    
     public void liangBarsky(Point p0, Point p1, Graphics2D g2d){
        //System.out.println("ENTRO A BLUE: " + nx1);
        int x0 = p0.x;
        int x1 = p1.x;
        int y0 = p0.y;
        int y1 = p1.y;
        
        /*x0 = p0.x + FRAME_WIDTH/2;
        y0 = FRAME_HEIGHT/2 - p0.y ;
        x1 = p1.x + FRAME_WIDTH/2;
        y1 = FRAME_HEIGHT/2 - p1.y;*/
        
        double u1 = 0, u2 = 1;
        int dx = x1 - x0, dy = y1 - y0;
        int p[] = {-dx, dx, -dy, dy};
        int q[] = {x0 - Xmin, Xmax - x0, y0 - Ymin, Ymax - y0};
        for(int i = 0; i < 4; i++){
            if(p[i] == 0){
                if(q[i] < 0){
                    System.out.println("EXIT");
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
            System.out.println("EXIT2");
            return;
        }
        int nx0, ny0, nx1, ny1;
        /*x0 = p0.x + FRAME_WIDTH/2;
        y0 = FRAME_HEIGHT/2 - p0.y ;
        x1 = p1.x + FRAME_WIDTH/2;
        y1 = FRAME_HEIGHT/2 - p1.y;*/
        
        nx0 = (int) (x0 + u1 * dx);
        ny0 = (int) (y0 + u1 * dy);
        nx1 = (int) (x0 + u2 * dx);
        ny1 = (int) (y0 + u2 * dy);
        /*g2d.setColor(Color.RED);
        g2d.drawLine(x0,y0,nx0,ny0);
        System.out.println("ENTRO A RED: " + nx0);*/
        g2d.setColor(Color.PINK);
        System.out.println("ENTRO A BLUE: " + nx1);
        g2d.drawLine(nx0, ny0, nx1, ny1);
    
    }
    
    

    private void drawEdge(Graphics2D g2d,Point p0, Point p1) {
        /*int x0 = p0.x + FRAME_WIDTH/2;
        int y0 = FRAME_HEIGHT/2 - p0.y ;
        int x1 = p1.x + FRAME_WIDTH/2;
        int y1 = FRAME_HEIGHT/2 - p1.y;*/
        int x0 = p0.x;
        int x1 = p1.x;
        int y0 = p0.y;
        int y1 = p1.y;
        g2d.drawLine(x0, y0, x1, y1);
    }

 
    public void readObjectDescription(String fileName) {
        Scanner in;
        po = new PolygonObject();
        poClip = new PolygonObject();
        try {
            in = new Scanner(new File(fileName));
            // Read the number of vertices
            int numVertices = in.nextInt();
            Point[] vertexArray = new Point[numVertices];
            // Read the vertices
            for (int i = 0; i < numVertices; i++) {
                // Read a vertex
                int x = in.nextInt();
                int y = in.nextInt();
                vertexArray[i] = new Point(x, y);
            }
            // Read the number of edges
            int numEdges = in.nextInt();
            // Read the edges
            for (int i = 0; i < numEdges; i++) {
                // Read an edge
                int start = in.nextInt();
                int end = in.nextInt();
                Edge edge = new Edge(vertexArray[start], vertexArray[end]);
                po.add(edge);
            }
            int numVerticesArea = in.nextInt();
            Point[] ClippingArea = new Point[numVerticesArea];
            // Read the vertices
            for (int i = 0; i < numVerticesArea; i++) {
                // Read a vertex
                int x = in.nextInt();
                int y = in.nextInt();
                ClippingArea[i] = new Point(x, y);
            }
            int clipping = in.nextInt();
            // Read the edges
            for (int i = 0; i < clipping; i++) {
                // Read an edge
                int start = in.nextInt();
                int end = in.nextInt();
                Edge edge = new Edge(ClippingArea[start], ClippingArea[end]);
                poClip.add(edge);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        Main m = new Main();

        // Read the file with the object description
        m.readObjectDescription("objeto.txt");

        // Create a new Frame
        JFrame frame = new JFrame("Wire Frame Object");
        // Upon closing the frame, the application ends
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add a panel called DibujarCasita3D
        frame.add(m);

        // Asignarle tamaño
        frame.setSize(Main.FRAME_WIDTH, Main.FRAME_HEIGHT);
        // Put the frame in the middle of the window
        frame.setLocationRelativeTo(null);
        // Show the frame
        frame.setVisible(true);
    }

}
