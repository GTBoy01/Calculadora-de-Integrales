/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GTBOY
 */
public class GraficadorFuncionesY extends JFrame{
    //
    private String funcion;
    private List<Point.Double> puntos;
    
    public GraficadorFuncionesY(String funcion) {
        this.funcion = funcion;
        this.puntos = new ArrayList<>();
        inicializarVentana();
        calcularPuntos();
        debugFuncion(); // Para verificar errores
    }
    
    private void inicializarVentana() {
        //Iniciamos la ventana y sus atributos
        setTitle("Gráfico sobre Y: f(y) = " + funcion);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new PanelGrafico());
    }
    
    private void calcularPuntos() {
        //Metodo que se encarga de dibujar los puntos en base a la funcion dada
        puntos.clear();
        
        for (double y = -5.0; y <= 5.0; y += 0.1) {
            try {
                double x = evaluarFuncionManual(y);
                if (!Double.isNaN(x) && !Double.isInfinite(x)) {
                    puntos.add(new Point.Double(x, y));
                }
            } catch (Exception e) {
                // Ignorar puntos con error
            }
        }
    }
    
    private double evaluarFuncionManual(double y) {
        String expr = funcion.toLowerCase().replace(" ", "");
        
        // Casos especiales para funciones comunes
        if (expr.equals("y")) {
            return y;
        }
        else if (expr.equals("y^2") || expr.equals("y2")) {
            return y * y;
        }
        else if (expr.equals("y^3") || expr.equals("y3")) {
            return y * y * y;
        }
        else if (expr.equals("2*y+3") || expr.equals("2y+3")) {
            return 2 * y + 3;
        }
        else if (expr.equals("sin(y)")) {
            return Math.sin(y);
        }
        else if (expr.equals("cos(y)")) {
            return Math.cos(y);
        }
        else if (expr.equals("tan(y)")) {
            return Math.tan(y);
        }
        else if (expr.equals("exp(y)") || expr.equals("e^y")) {
            return Math.exp(y);
        }
        else if (expr.equals("log(y)")) {
            return y > 0 ? Math.log10(y) : Double.NaN;
        }
        else if (expr.equals("ln(y)")) {
            return y > 0 ? Math.log(y) : Double.NaN;
        }
        else if (expr.equals("sqrt(y)") || expr.equals("√y")) {
            return y >= 0 ? Math.sqrt(y) : Double.NaN;
        }
        else if (expr.equals("1/y")) {
            return y != 0 ? 1.0 / y : Double.NaN;
        }
        else if (expr.equals("abs(y)") || expr.equals("|y|")) {
            return Math.abs(y);
        }
        else {
            // Intentar analizar expresiones simples como "2y", "y+1", etc.
            return evaluarExpresionSimple(expr, y);
        }
    }
    
    private double evaluarExpresionSimple(String expr, double y) {
        try {
            // Quitar espacios y preparar expresión
            expr = expr.replace(" ", "").toLowerCase();
            
            // Reemplazar y con valor
            expr = expr.replace("y", "(" + y + ")");
            
            // Manejar multiplicación implícita: 2y -> 2*y
            expr = expr.replace(")(", ")*(");
            expr = expr.replace("1(", "1*(").replace("2(", "2*(").replace("3(", "3*(")
                     .replace("4(", "4*(").replace("5(", "5*(").replace("6(", "6*(")
                     .replace("7(", "7*(").replace("8(", "8*(").replace("9(", "9*(")
                     .replace("0(", "0*(");
            
            // Si la expresión es solo un número después del reemplazo
            if (expr.matches("-?\\d+(\\.\\d+)?")) {
                return Double.parseDouble(expr);
            }
            
            // Evaluar operaciones básicas
            return evaluarOperaciones(expr);
            
        } catch (Exception e) {
            throw new RuntimeException("No se pudo evaluar: " + expr);
        }
    }
    
    private double evaluarOperaciones(String expr) {
        // Eliminar paréntesis si es un solo número
        if (expr.startsWith("(") && expr.endsWith(")")) {
            String contenido = expr.substring(1, expr.length() - 1);
            if (!contenido.contains("+") && !contenido.contains("-") && 
                !contenido.contains("*") && !contenido.contains("/")) {
                return Double.parseDouble(contenido);
            }
        }
        
        // Buscar operaciones en orden de precedencia
        
        // Suma y resta (de derecha a izquierda)
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (c == '+' && i > 0) {
                double left = evaluarOperaciones(expr.substring(0, i));
                double right = evaluarOperaciones(expr.substring(i + 1));
                return left + right;
            }
            if (c == '-' && i > 0) {
                double left = evaluarOperaciones(expr.substring(0, i));
                double right = evaluarOperaciones(expr.substring(i + 1));
                return left - right;
            }
        }
        
        // Multiplicación y división
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '*') {
                double left = evaluarOperaciones(expr.substring(0, i));
                double right = evaluarOperaciones(expr.substring(i + 1));
                return left * right;
            }
            if (c == '/') {
                double left = evaluarOperaciones(expr.substring(0, i));
                double right = evaluarOperaciones(expr.substring(i + 1));
                return left / right;
            }
        }
        
        // Si no hay operaciones, es un número
        return Double.parseDouble(expr);
    }
    
    private void debugFuncion() {
        System.out.println("=== DEBUG FUNCIÓN SOBRE Y: " + funcion + " ===");
        
        for (double y = -5; y <= 5; y++) {
            try {
                double x = evaluarFuncionManual(y);
                System.out.printf("f(%.1f) = %.2f%n", y, x);
            } catch (Exception e) {
                System.out.printf("f(%.1f) = ERROR: %s%n", y, e.getMessage());
            }
        }
        System.out.println("Total puntos válidos: " + puntos.size());
        System.out.println("=== FIN DEBUG ===");
    }
    
    // Creacion del panel de la grafica de la funcion
    private class PanelGrafico extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            int width = getWidth();
            int height = getHeight();
            
            // Fondo
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, width, height);
            
            // Ejes
            dibujarEjes(g2d, width, height);
            
            // Función
            if (!puntos.isEmpty()) {
                dibujarFuncion(g2d, width, height);
            }
        }
        
        private void dibujarEjes(Graphics2D g2d, int width, int height) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawLine(width/2, 0, width/2, height); // Eje Y
            g2d.drawLine(0, height/2, width, height/2); // Eje X
            
            // Marcas del plano con sus numeros en escala
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.PLAIN, 12));
            
            int escala = 40;
            
            for (int i = -10; i <= 10; i++) {
                if (i == 0) continue;
                
                // Marcas eje X
                int x = width/2 + (i * escala);
                g2d.drawLine(x, height/2 - 5, x, height/2 + 5);
                if (i % 2 == 0) {
                    g2d.drawString(String.valueOf(i), x - 5, height/2 + 20);
                }
                
                // Marcas eje Y
                int y = height/2 - (i * escala);
                g2d.drawLine(width/2 - 5, y, width/2 + 5, y);
                if (i % 2 == 0) {
                    g2d.drawString(String.valueOf(i), width/2 + 10, y + 5);
                }
            }
            
            // Origen del plano (0,0)
            g2d.drawString("0", width/2 + 5, height/2 + 15);
        }
        
        private void dibujarFuncion(Graphics2D g2d, int width, int height) {
            g2d.setColor(Color.RED); // Color diferente para distinguir
            g2d.setStroke(new BasicStroke(2.5f));
            
            Path2D.Double path = new Path2D.Double();
            boolean first = true;
            
            int escala = 40;
            
            for (Point.Double punto : puntos) {
                int screenX = (int) (width/2 + (punto.x * escala));
                int screenY = (int) (height/2 - (punto.y * escala));
                
                if (screenY < -1000 || screenY > height + 1000) {
                    continue; // Saltar puntos fuera de rango
                }
                
                if (first) {
                    path.moveTo(screenX, screenY);
                    first = false;
                } else {
                    path.lineTo(screenX, screenY);
                }
            }
            
            g2d.draw(path);
        }
    }
    
    //
}