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
 * @author usuario
 */
public class GraficadorFunciones extends JFrame{
    //
    private String funcion;
    private List<Point.Double> puntos;
    
    public GraficadorFunciones(String funcion) {
        this.funcion = funcion;
        this.puntos = new ArrayList<>();
        inicializarVentana();
        calcularPuntos();
        debugFuncion(); // Para verificar
    }
    
    private void inicializarVentana() {
        setTitle("Gráfico: f(x) = " + funcion);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new PanelGrafico());
    }
    
    private void calcularPuntos() {
        puntos.clear();
        
        for (double x = -5.0; x <= 5.0; x += 0.1) {
            try {
                double y = evaluarFuncionManual(x);
                if (!Double.isNaN(y) && !Double.isInfinite(y)) {
                    puntos.add(new Point.Double(x, y));
                }
            } catch (Exception e) {
                // Ignorar puntos con error
            }
        }
    }
    
    private double evaluarFuncionManual(double x) {
        String expr = funcion.toLowerCase().replace(" ", "");
        
        // Casos especiales para funciones comunes
        if (expr.equals("x")) {
            return x;
        }
        else if (expr.equals("x^2") || expr.equals("x2")) {
            return x * x;
        }
        else if (expr.equals("x^3") || expr.equals("x3")) {
            return x * x * x;
        }
        else if (expr.equals("2*x+3") || expr.equals("2x+3")) {
            return 2 * x + 3;
        }
        else if (expr.equals("sin(x)")) {
            return Math.sin(x);
        }
        else if (expr.equals("cos(x)")) {
            return Math.cos(x);
        }
        else if (expr.equals("tan(x)")) {
            return Math.tan(x);
        }
        else if (expr.equals("exp(x)") || expr.equals("e^x")) {
            return Math.exp(x);
        }
        else if (expr.equals("log(x)")) {
            return x > 0 ? Math.log10(x) : Double.NaN;
        }
        else if (expr.equals("ln(x)")) {
            return x > 0 ? Math.log(x) : Double.NaN;
        }
        else if (expr.equals("sqrt(x)") || expr.equals("√x")) {
            return x >= 0 ? Math.sqrt(x) : Double.NaN;
        }
        else if (expr.equals("1/x")) {
            return x != 0 ? 1.0 / x : Double.NaN;
        }
        else if (expr.equals("abs(x)") || expr.equals("|x|")) {
            return Math.abs(x);
        }
        else {
            // Intentar analizar expresiones simples como "2x", "x+1", etc.
            return evaluarExpresionSimple(expr, x);
        }
    }
    
    private double evaluarExpresionSimple(String expr, double x) {
        try {
            // Quitar espacios y preparar expresión
            expr = expr.replace(" ", "").toLowerCase();
            
            // Reemplazar x con valor
            expr = expr.replace("x", "(" + x + ")");
            
            // Manejar multiplicación implícita: 2x -> 2*x
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
        System.out.println("=== DEBUG FUNCIÓN: " + funcion + " ===");
        
        for (double x = -5; x <= 5; x++) {
            try {
                double y = evaluarFuncionManual(x);
                System.out.printf("f(%.1f) = %.2f%n", x, y);
            } catch (Exception e) {
                System.out.printf("f(%.1f) = ERROR: %s%n", x, e.getMessage());
            }
        }
        System.out.println("Total puntos válidos: " + puntos.size());
        System.out.println("=== FIN DEBUG ===");
    }
    
    // Panel gráfico (el mismo de antes, pero funcionando)
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
            
            // Marcas
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
            
            // Origen
            g2d.drawString("0", width/2 + 5, height/2 + 15);
        }
        
        private void dibujarFuncion(Graphics2D g2d, int width, int height) {
            g2d.setColor(Color.BLUE);
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
