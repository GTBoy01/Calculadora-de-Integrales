/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package operaciones;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.mariuszgromada.math.mxparser.*;
/**
 *
 * @author GTBOY
 */

public class IntegralIndefinida extends javax.swing.JFrame {

    public IntegralIndefinida() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Integrales Indefinidas");
        // Configurar valores por defecto
        txtFuncion.setText("x^2");
        txtFuncion.selectAll();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblFuncion = new javax.swing.JLabel();
        txtFuncion = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        btnGraficar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cmbEje = new javax.swing.JComboBox<>();
        lblEje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaResultado = new javax.swing.JTextArea();
        lblResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Integrales Indefinidas");

        lblFuncion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFuncion.setText("Función f(x):");

        txtFuncion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFuncion.setText("x^2");
        txtFuncion.setToolTipText("Ejemplos: x^2, sin(x), 2*x+1, e^x, 1/x");
        txtFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuncionActionPerformed(evt);
            }
        });

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCalcular.setText("Calcular Integral");
        btnCalcular.setToolTipText("Calcular la integral indefinida");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        
        btnGraficar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnGraficar.setText("Graficar");
        btnGraficar.setToolTipText("Graficador de funciones simples");
        btnGraficar.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt){
            Btn_Graficar_FuncionActionPerformed(evt);
        }
    });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Limpiar todos los campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVolver.setText("Volver al Menú");
        btnVolver.setToolTipText("Regresar al menú principal");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cmbEje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbEje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X", "Y" }));
        cmbEje.setToolTipText("Integrar respecto al eje X o Y");

        lblEje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEje.setText("Variable:");

        areaResultado.setEditable(false);
        areaResultado.setColumns(20);
        areaResultado.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        areaResultado.setLineWrap(true);
        areaResultado.setRows(5);
        areaResultado.setTabSize(4);
        areaResultado.setToolTipText("Resultado de la integral");
        jScrollPane1.setViewportView(areaResultado);

        lblResultado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblResultado.setText("Resultado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFuncion)
                                    .addComponent(lblEje))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFuncion)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbEje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCalcular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGraficar) 
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                .addComponent(btnVolver))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblResultado)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncion)
                    .addComponent(txtFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEje)
                    .addComponent(cmbEje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
                    .addComponent(btnGraficar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnVolver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void txtFuncionActionPerformed(java.awt.event.ActionEvent evt) {                                           
        calcularIntegral();
    }                                          

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {                                            
        calcularIntegral();
    }                                           

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        limpiarCampos();
    }                                          

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {                                          
        new ui.VentanaInicio().setVisible(true);
            dispose(); // Cierra esta ventana
    }
    
    private void Btn_Graficar_FuncionActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        //Boton de graficación, llamamos a la clase GraficadorFunciones
         String funcion = txtFuncion.getText().trim();
        if (funcion.isEmpty()) {
            mostrarError("Ingresa una función para graficar.");
            return;
        }
        
        try {
            //Aqui no se toman los limites ya que son indefinidas
            String eje = (String) cmbEje.getSelectedItem();
            
            // Aquí llamamos al graficador segun el eje seleccionado
            // Crear y mostrar la ventana del graficador
        if ("X".equals(eje)) {
            // Graficar sobre el eje X (función tradicional y = f(x))
            GraficadorFunciones graficador = new GraficadorFunciones(funcion);
            graficador.setVisible(true);
        } else if ("Y".equals(eje)) {
            // Graficar sobre el eje Y (función x = f(y))
            GraficadorFuncionesY graficador = new GraficadorFuncionesY(funcion);
            graficador.setVisible(true);
        } else {
            mostrarError("Selecciona un eje válido para graficar.");
            return;
        }
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Gráfico para:\n" +
                "Función: " + funcion + "\n" +
                "Eje: " + eje,
                "Graficar Integral", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            mostrarError("Error al preparar gráfico: " + e.getMessage());
        }
         }

    private void calcularIntegral() {
        try {
            String funcion = txtFuncion.getText().trim();
            String eje = (String) cmbEje.getSelectedItem();
            
            if (funcion.isEmpty()) {
                mostrarError("Ingresa una función.");
                return;
            }
            
            String resultado = calcularIntegralIndefinida(funcion, eje);
            
            String mensaje = String.format(
                "══════════════════════════════════════\n" +
                "         INTEGRAL INDEFINIDA         \n" +
                "══════════════════════════════════════\n" +
                " Función: %-26s \n" +
                " Variable: %-25s \n" +
                "══════════════════════════════════════\n" +
                " Resultado: %-24s \n" +
                "                                      \n" +
                " Nota: C = constante de integración   \n" +
                "══════════════════════════════════════",
                (eje.equals("X") ? "f(x) = " + funcion : "x = f(y) = " + funcion),
                eje,
                resultado
            );
            
            areaResultado.setText(mensaje);
            
        } catch (Exception e) {
            mostrarError("Error: " + e.getMessage());
        }
    }
    
    private String calcularIntegralIndefinida(String funcion, String eje) {
        if (eje.equalsIgnoreCase("Y")) {
            try {
                String funcionInversa = obtenerFuncionInversa(funcion);
                return "∫" + funcionInversa + " dy + C";
            } catch (Exception e) {
                return "No disponible para Y";
            }
        }
        
        // Integrales indefinidas básicas para eje X
        String expr = funcion.toLowerCase().replace(" ", "").replace("**", "^");
        
        // Polinomios
    
    
        
        switch (expr) {
                    // POLINOMIOS BÁSICOS
        case "x": return "(1/2)x² + C";
        case "x^2": case "x2": return "(1/3)x³ + C";
        case "x^3": case "x3": return "(1/4)x⁴ + C";
        case "x^4": case "x4": return "(1/5)x⁵ + C";
        case "x^5": case "x5": return "(1/6)x⁶ + C";
        
        // MÚLTIPLOS DE X
        case "2*x": case "2x": return "x² + C";
        case "3*x": case "3x": return "(3/2)x² + C";
        case "4*x": case "4x": return "2x² + C";
        case "5*x": case "5x": return "(5/2)x² + C";
        case "10*x": case "10x": return "5x² + C";
        
        // FUNCIONES TRIGONOMÉTRICAS
        case "sin(x)": return "-cos(x) + C";
        case "cos(x)": return "sin(x) + C";
        case "tan(x)": return "ln|sec(x)| + C";
        case "cot(x)": return "ln|sin(x)| + C";
        case "sec(x)": return "ln|sec(x) + tan(x)| + C";
        case "csc(x)": return "ln|csc(x) - cot(x)| + C";
        
        // FUNCIONES TRIGONOMÉTRICAS CON COEFICIENTES
        case "sin(2*x)": case "sin(2x)": return "-(1/2)cos(2x) + C";
        case "cos(2*x)": case "cos(2x)": return "(1/2)sin(2x) + C";
        case "sin(3*x)": case "sin(3x)": return "-(1/3)cos(3x) + C";
        case "cos(3*x)": case "cos(3x)": return "(1/3)sin(3x) + C";
        
        // FUNCIONES TRIGONOMÉTRICAS AL CUADRADO
        case "sin(x)^2": case "sin^2(x)": return "(1/2)(x - sin(x)cos(x)) + C";
        case "cos(x)^2": case "cos^2(x)": return "(1/2)(x + sin(x)cos(x)) + C";
        case "tan(x)^2": case "tan^2(x)": return "tan(x) - x + C";
        
        // FUNCIONES EXPONENCIALES
        case "e^x": case "exp(x)": return "e^x + C";
        case "e^(2*x)": case "e^(2x)": return "(1/2)e^(2x) + C";
        case "e^(3*x)": case "e^(3x)": return "(1/3)e^(3x) + C";
        case "2^x": return "(2^x)/ln(2) + C";
        case "3^x": return "(3^x)/ln(3) + C";
        case "10^x": return "(10^x)/ln(10) + C";
        
        // FUNCIONES LOGARÍTMICAS
        case "1/x": return "ln|x| + C";
        case "1/(2*x)": case "1/(2x)": return "(1/2)ln|x| + C";
        case "1/(x+1)": return "ln|x+1| + C";
        case "1/(x-1)": return "ln|x-1| + C";
        case "1/(2*x+1)": case "1/(2x+1)": return "(1/2)ln|2x+1| + C";
        
        // LOGARITMOS NATURALES
        case "ln(x)": return "x·ln(x) - x + C";
        case "log(x)": return "x·log(x) - x/ln(10) + C";
        
        // RAÍCES Y POTENCIAS FRACCIONARIAS
        case "sqrt(x)": case "x^(1/2)": return "(2/3)x^(3/2) + C";
        case "x^(1/3)": return "(3/4)x^(4/3) + C";
        case "x^(2/3)": return "(3/5)x^(5/3) + C";
        case "x^(3/2)": return "(2/5)x^(5/2) + C";
        case "1/sqrt(x)": case "x^(-1/2)": return "2√x + C";
        case "1/x^2": case "x^(-2)": return "-1/x + C";
        case "1/x^3": case "x^(-3)": return "-1/(2x²) + C";
        
        // FUNCIONES HIPERBÓLICAS
        case "sinh(x)": return "cosh(x) + C";
        case "cosh(x)": return "sinh(x) + C";
        case "tanh(x)": return "ln|cosh(x)| + C";
        
        // FUNCIONES ALGEBRAICAS COMPUESTAS
        case "(x+1)^2": return "(1/3)(x+1)³ + C";
        case "(x+2)^2": return "(1/3)(x+2)³ + C";
        case "(x-1)^2": return "(1/3)(x-1)³ + C";
        case "(2*x+1)^2": case "(2x+1)^2": return "(1/6)(2x+1)³ + C";
        
        // FUNCIONES RACIONALES
        case "1/(x^2+1)": return "arctan(x) + C";
        case "1/(x^2+4)": return "(1/2)arctan(x/2) + C";
        case "1/sqrt(1-x^2)": return "arcsin(x) + C";
        case "1/(1+x^2)": return "arctan(x) + C";
        case "1/(1-x^2)": return "arctanh(x) + C";
        
        // SUMAS DE FUNCIONES
        case "x+1": return "(1/2)x² + x + C";
        case "x+2": return "(1/2)x² + 2x + C";
        case "x+3": return "(1/2)x² + 3x + C";
        case "2*x+1": case "2x+1": return "x² + x + C";
        case "3*x+2": case "3x+2": return "(3/2)x² + 2x + C";
        
        // EXPRESIONES CON PARÉNTESIS
        case "(x+1)": return "(1/2)x² + x + C";
        case "(x+2)": return "(1/2)x² + 2x + C";
        case "(2*x+3)": case "(2x+3)": return "x² + 3x + C";
        case "(3*x+4)": case "(3x+4)": return "(3/2)x² + 4x + C";
            default: return "∫(" + funcion + ")dx + C";
        }
    }
    
    private String obtenerFuncionInversa(String funcion) {
        String expr = funcion.toLowerCase().replace(" ", "").replace("**", "^");
        
        switch (expr) {
            case "x": return "y";
            case "x^2": return "sqrt(y)";
            case "x^3": case "x3": return "y^(1/3)";
            case "x^4": case "x4": return "y^(1/4)";
            case "x^5": case "x5": return "y^(1/5)";
            case "2*x": case "2x": return "y/2";
            case "x/2": return "2*y";
            case "x+1": return "y-1";
            case "x-1": return "y+1";
            
            //RAICES
            case "sqrt(x)": case "x^(1/2)": return "y^2";
            case "x^(1/3)": return "y^3";
            case "x^(2/3)": return "y^(3/2)";
            case "x^(3/2)": return "y^(2/3)";
            
            //EXPONENCIALES
            case "e^x": case "exp(x)": return "ln(y)";
            case "e^(2*x)": case "e^(2x)": return "(1/2)ln(y)";
            case "e^(3*x)": case "e^(3x)": return "(1/3)ln(y)";
            case "2^x": return "log2(y)";
            case "3^x": return "log3(y)";
            case "10^x": return "log10(y)";
            
            //LOGARITMOS
            case "ln(x)": return "e^y";
            case "log(x)": return "10^y";
            
            //TRIGONOMETRICAS
            case "sin(x)": return "arcsin(y)";
            case "cos(x)": return "arccos(y)";
            case "tan(x)": return "arctan(y)";
            case "arcsin(x)": return "sin(y)";
            case "arccos(x)": return "cos(y)";
            case "arctan(x)": return "tan(y)";
            
            //HIPERBOLICAS
            case "sinh(x)": return "asinh(y)";
            case "cosh(x)": return "acosh(y)";
            case "tanh(x)": return "atanh(y)";
            
            //FUNCIONES RECIPROCAS
            case "1/x": return "1/y";
            case "1/x^2": case "x^(-2)": return "1/sqrt(y)";
            case "1/x^3": case "x^(-3)": return "1/y^(1/3)";
            case "1/sqrt(x)": case "x^(-1/2)": return "1/y^2";
            
            
            default:
                //Intentar analizar las expresiones
                return analizarExpresionCompleja(expr);
            
        }
    }
    //
    private String analizarExpresionCompleja(String expr) {
    // Intentar reconocer patrones más complejos
    
    // Funciones con coeficientes
    if (expr.matches("\\d+\\*?sin\\(x\\)")) {
        String coef = expr.split("\\*?sin\\(")[0].replace("*", "");
        return "arcsin(y/" + coef + ")";
    }
    
    if (expr.matches("\\d+\\*?cos\\(x\\)")) {
        String coef = expr.split("\\*?cos\\(")[0].replace("*", "");
        return "arccos(y/" + coef + ")";
    }
    
    if (expr.matches("\\d+\\*?e\\^x")) {
        String coef = expr.split("\\*?e\\^")[0].replace("*", "");
        return "ln(y/" + coef + ")";
    }
    
    // Funciones compuestas
    if (expr.matches("sin\\(\\d+\\*?x\\)")) {
        String coef = expr.replace("sin(", "").replace("x)", "").replace("*", "");
        return "(1/" + coef + ")arcsin(y)";
    }
    
    if (expr.matches("cos\\(\\d+\\*?x\\)")) {
        String coef = expr.replace("cos(", "").replace("x)", "").replace("*", "");
        return "(1/" + coef + ")arccos(y)";
    }
    
    // Por defecto, lanzar error
    throw new RuntimeException("Función no soportada para integración respecto a Y: " + expr);
}
    
    //
    
    private void limpiarCampos() {
        txtFuncion.setText("");
        areaResultado.setText("");
        cmbEje.setSelectedIndex(0);
        txtFuncion.requestFocus();
    }
    
    private void mostrarError(String mensaje) {
        areaResultado.setText("Error: " + mensaje);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntegralIndefinida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea areaResultado;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbEje;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEje;
    private javax.swing.JLabel lblFuncion;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtFuncion;
    // End of variables declaration                   
}