/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

/**
 *
 * @author macom
 */
import javax.swing.*;
import java.awt.*;

public class GraficaResultados extends JPanel {

    private double[] xs;
    private double[] ys;
    private double xmin, xmax, ymin, ymax;

    public GraficaResultados(double[] xs, double[] ys) {
        this.xs = xs;
        this.ys = ys;

        // Calcular rangos automáticos
        xmin = xs[0];
        xmax = xs[xs.length - 1];
        ymin = Double.MAX_VALUE;
        ymax = Double.MIN_VALUE;
        for (double y : ys) {
            if (y < ymin) ymin = y;
            if (y > ymax) ymax = y;
        }
        if (ymin == ymax) { 
            ymax += 1;
            ymin -= 1;
        }

        setPreferredSize(new Dimension(xs.length * 20 + 100, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        int margen = 50;

        // Ejes
        g.drawLine(margen, h - margen, w - margen, h - margen); // X
        g.drawLine(margen, margen, margen, h - margen); // Y

        // Dibujar puntos con cruz
        for (int i = 0; i < xs.length; i++) {
            int x = margen + (int)((xs[i] - xmin) / (xmax - xmin) * (w - 2*margen));
            int y = h - margen - (int)((ys[i] - ymin) / (ymax - ymin) * (h - 2*margen));

            // Dibujar cruz
            g.drawLine(x - 3, y, x + 3, y);
            g.drawLine(x, y - 3, x, y + 3);
        }

        // Dibujar línea conectando puntos
        g.setColor(Color.RED);
        for (int i = 0; i < xs.length - 1; i++) {
            int x1 = margen + (int)((xs[i] - xmin) / (xmax - xmin) * (w - 2*margen));
            int y1 = h - margen - (int)((ys[i] - ymin) / (ymax - ymin) * (h - 2*margen));
            int x2 = margen + (int)((xs[i+1] - xmin) / (xmax - xmin) * (w - 2*margen));
            int y2 = h - margen - (int)((ys[i+1] - ymin) / (ymax - ymin) * (h - 2*margen));
            g.drawLine(x1, y1, x2, y2);
        }

        // Etiquetas eje X
        g.setColor(Color.BLACK);
        for (int i = 0; i < xs.length; i += 5) {
            int x = margen + (int)((xs[i] - xmin) / (xmax - xmin) * (w - 2*margen));
            g.drawString(String.format("%.1f", xs[i]), x - 10, h - margen + 20);
        }

        // Etiquetas eje Y
        for (int i = 0; i <= 5; i++) {
            int y = h - margen - i * (h - 2*margen)/5;
            double val = ymin + i*(ymax - ymin)/5;
            g.drawString(String.format("%.1f", val), 5, y + 5);
        }
    }

    public static void mostrarGrafica(double[] xs, double[] ys, String titulo) {
        GraficaResultados panel = new GraficaResultados(xs, ys);
        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JFrame frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.add(scroll);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
