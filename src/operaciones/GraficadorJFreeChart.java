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

public class GraficadorJFreeChart extends JFrame {

    public GraficadorJFreeChart(String titulo, String expresionDerivada,DerivadaDefinidasX derivadax,Double valorX, Double resultadoY) {
        setTitle(titulo);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        ChartPanel panel = crearPanelGrafico(titulo, expresionDerivada, derivadax, valorX, resultadoY);
        setContentPane(panel);
    }

    private ChartPanel crearPanelGrafico(String titulo, String expresionDerivada,DerivadaDefinidasX derivadax,Double valorX, Double resultadoY) {

        
        XYDataset dataset = crearDataset(expresionDerivada, derivadax, -5, 5, 0.05, valorX, resultadoY);

        JFreeChart grafico = ChartFactory.createXYLineChart(
                titulo,
                "x",
                "f'(x)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
                
        );

        XYPlot plot = grafico.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // === Serie 0: línea azul (derivada) ===
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesShapesVisible(0, false);

        // === Serie 1: punto rojo ===
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesShape(1, new Ellipse2D.Double(-4, -4, 8, 8));
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);

        plot.setRenderer(renderer);

        // === Estilo general ===
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(new Color(200, 200, 200)); // cuadrícula gris clara
        plot.setRangeGridlinePaint(new Color(200, 200, 200));

        // === Ejes centrados en 0 ===
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);
        plot.setDomainZeroBaselinePaint(Color.BLACK);
        plot.setRangeZeroBaselinePaint(Color.BLACK);

        // === Ejes con escala automática ===
        NumberAxis ejeX = (NumberAxis) plot.getDomainAxis();
        ejeX.setAutoRange(true);
        ejeX.setAutoRangeIncludesZero(true);

        NumberAxis ejeY = (NumberAxis) plot.getRangeAxis();
        ejeY.setAutoRange(true);

        // === Panel interactivo ===
        ChartPanel panel = new ChartPanel(grafico);
        panel.setDomainZoomable(true);
        panel.setRangeZoomable(true);
        
        panel.setMouseWheelEnabled(true); // zoom con la rueda del mouse
        panel.setMouseZoomable(true);     // habilita zoom con arrastre

        return panel;
    }

    private XYDataset crearDataset(String expresionDerivada, DerivadaDefinidasX derivadax,
                                   double xMin, double xMax, double paso,
                                   Double valorX, Double resultadoY) {

        XYSeries serie = new XYSeries("f'(x) = " + expresionDerivada);
        for (double x = xMin; x <= xMax; x += paso) {
            try {
                double y = derivadax.evaluar(x);
                if (!Double.isNaN(y) && !Double.isInfinite(y)) {
                    serie.add(x, y);
                }
            } catch (Exception e) {
                // Ignorar errores de cálculo
            }
        }

        XYSeries punto = new XYSeries("Punto (x, R)");
        if (valorX != null && resultadoY != null) {
            punto.add(valorX, resultadoY);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serie);
        dataset.addSeries(punto);

        return dataset;
    }
}
