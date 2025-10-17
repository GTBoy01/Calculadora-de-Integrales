/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

/**
 *
 * @author macom
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYDataset;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GraficadorJFreeChartY extends JFrame {

    public GraficadorJFreeChartY(String titulo, String expresionFuncionY, DerivadaDefinidasY funcionY, double valorY, double resultadoX) {
        setTitle(titulo);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        ChartPanel panel = crearPanelGrafico(titulo, expresionFuncionY, funcionY, valorY, resultadoX);
        setContentPane(panel);
    }

    private ChartPanel crearPanelGrafico(String titulo, String expresionFuncionY, DerivadaDefinidasY funcionY, Double valorY, Double resultadoX) {

        // Generamos los puntos con y como variable independiente
        XYDataset dataset = crearDataset(expresionFuncionY, funcionY, -10, 10, 0.05, valorY, resultadoX);

        JFreeChart grafico = ChartFactory.createXYLineChart(
                titulo,
                "y",         // eje X (ahora y es la variable independiente)
                "x = f(y)",  // eje Y (resultado)
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        XYPlot plot = grafico.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // === Serie 0: línea azul ===
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesShapesVisible(0, false);

        // === Serie 1: punto rojo ===
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesShape(1, new Ellipse2D.Double(-4, -4, 8, 8));
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);

        plot.setRenderer(renderer);

        // === Estilo de fondo ===
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(new Color(200, 200, 200));
        plot.setRangeGridlinePaint(new Color(200, 200, 200));

        // === Ejes centrados en 0 ===
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);
        plot.setDomainZeroBaselinePaint(Color.BLACK);
        plot.setRangeZeroBaselinePaint(Color.BLACK);

        // === Ejes ===
        NumberAxis ejeX = (NumberAxis) plot.getDomainAxis(); // eje X representa y
        ejeX.setAutoRange(true);
        ejeX.setTickUnit(new org.jfree.chart.axis.NumberTickUnit(1));

        NumberAxis ejeY = (NumberAxis) plot.getRangeAxis(); // eje Y representa x
        ejeY.setAutoRange(true);

        // === Panel interactivo ===
        ChartPanel panel = new ChartPanel(grafico);
        panel.setDomainZoomable(true);
        panel.setRangeZoomable(true);
        panel.setMouseWheelEnabled(true);
        panel.setMouseZoomable(true);

        return panel;
    }

    private XYDataset crearDataset(String expresionFuncionY, DerivadaDefinidasY funcionY,
                                   double yMin, double yMax, double paso,
                                   Double valorY, Double resultadoX) {

        XYSeries serie = new XYSeries("x = f(y) = " + expresionFuncionY);
        for (double y = yMin; y <= yMax; y += paso) {
            try {
                double x = funcionY.evaluar(y);
                if (!Double.isNaN(x) && !Double.isInfinite(x)) {
                    serie.add(y, x); // y es eje X, x es valor dependiente
                }
            } catch (Exception e) {
                // Ignorar errores de cálculo
            }
        }

        XYSeries punto = new XYSeries("Punto (y, x)");
        if (valorY != null && resultadoX != null) {
            punto.add(valorY, resultadoX);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serie);
        dataset.addSeries(punto);

        return dataset;
    }
}
