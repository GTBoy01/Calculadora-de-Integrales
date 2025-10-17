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
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GraficadorDerivadaX extends JFrame {

    public GraficadorDerivadaX(String titulo, String funcionDerivada, Double valorX, Double valorY) {
        setTitle(titulo);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        ChartPanel panel = crearPanel(funcionDerivada, valorX, valorY);
        setContentPane(panel);
    }

    private ChartPanel crearPanel(String funcionDerivada, Double valorX, Double valorY) {
        XYSeries serie = new XYSeries("f'(x) = " + funcionDerivada);

        // Graficar función derivada
        for (double x = -10; x <= 10; x += 0.05) {
            try {
                double y = evaluarFuncion(funcionDerivada, x);
                if (!Double.isNaN(y) && !Double.isInfinite(y)) {
                    serie.add(x, y);
                }
            } catch (Exception e) {
                // Ignorar errores
            }
        }

        // Punto rojo opcional
        XYSeries punto = new XYSeries("Punto (x,y)");
        if (valorX != null && valorY != null) {
            punto.add(valorX, valorY);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serie);
        dataset.addSeries(punto);

        // Crear gráfico
        JFreeChart grafico = ChartFactory.createXYLineChart(
                "Gráfica de f'(x)",
                "x",
                "f'(x)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        XYPlot plot = grafico.getXYPlot();

        // Configurar renderer
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Serie 0: derivada azul
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesShapesVisible(0, false);

        // Serie 1: punto rojo
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesShape(1, new Ellipse2D.Double(-4, -4, 8, 8));
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);

        plot.setRenderer(renderer);

        // Fondo blanco y cuadrícula gris
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(new Color(200, 200, 200));
        plot.setRangeGridlinePaint(new Color(200, 200, 200));

        // Cruz central (0,0)
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);
        plot.setDomainZeroBaselinePaint(Color.BLACK);
        plot.setRangeZeroBaselinePaint(Color.BLACK);

        // Ejes automáticos
        NumberAxis ejeX = (NumberAxis) plot.getDomainAxis();
        ejeX.setAutoRange(true);
        ejeX.setAutoRangeIncludesZero(true);

        NumberAxis ejeY = (NumberAxis) plot.getRangeAxis();
        ejeY.setAutoRange(true);
        ejeY.setAutoRangeIncludesZero(true);

        // Panel interactivo: zoom y scroll
        ChartPanel panel = new ChartPanel(grafico);
        panel.setDomainZoomable(true);
        panel.setRangeZoomable(true);
        panel.setMouseWheelEnabled(true);
        panel.setMouseZoomable(true, true);

        return panel;
    }

    // Evaluar función usando DJep
    private double evaluarFuncion(String funcion, double x) throws Exception {
        DJep djep = new DJep();
        djep.addStandardFunctions();
        djep.addStandardConstants();
        djep.setAllowUndeclared(true);
        djep.setAllowAssignment(true);
        djep.setImplicitMul(true);
        djep.addStandardDiffRules();

        djep.addVariable("x", x);
        Node nodo = djep.parse(funcion);
        return (Double) djep.evaluate(nodo);
    }
}
