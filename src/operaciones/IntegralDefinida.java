/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package operaciones;

import org.mariuszgromada.math.mxparser.*;

/**
 *
 * @author GTBOY
 */
public class IntegralDefinida extends javax.swing.JFrame {

    public IntegralDefinida() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Integrales Definidas");
        // Configurar valores por defecto
        txtFuncion.setText("x^2");
        txtLimiteA.setText("0");
        txtLimiteB.setText("1");
        txtFuncion.selectAll();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblFuncion = new javax.swing.JLabel();
        txtFuncion = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cmbEje = new javax.swing.JComboBox<>();
        lblEje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaResultado = new javax.swing.JTextArea();
        lblResultado = new javax.swing.JLabel();
        lblLimites = new javax.swing.JLabel();
        txtLimiteA = new javax.swing.JTextField();
        lblA = new javax.swing.JLabel();
        txtLimiteB = new javax.swing.JTextField();
        btnGraficar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Integrales Definidas");

        lblFuncion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFuncion.setText("Función f(x):");

        txtFuncion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFuncion.setText("x^2");
        txtFuncion.setToolTipText("Ejemplos: x^2, sin(x), 2*x+1, e^x");
        txtFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuncionActionPerformed(evt);
            }
        });

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCalcular.setText("Calcular Integral");
        btnCalcular.setToolTipText("Calcular la integral definida");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
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
        //Declaramos las 2 opciones del menú desplegable
        cmbEje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X", "Y" }));
        cmbEje.setToolTipText("Integrar respecto al eje X o Y");

        lblEje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEje.setText("Eje:");

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

        lblLimites.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLimites.setText("Límites:");

        txtLimiteA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLimiteA.setText("0");
        txtLimiteA.setToolTipText("Límite inferior");
        txtLimiteA.setPreferredSize(new java.awt.Dimension(60, 30));

        lblA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblA.setText("a");

        txtLimiteB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLimiteB.setText("1");
        txtLimiteB.setToolTipText("Límite superior");
        txtLimiteB.setPreferredSize(new java.awt.Dimension(60, 30));

        btnGraficar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGraficar.setText("Graficar");
        btnGraficar.setToolTipText("Graficar la función y el área");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuncion)
                            .addComponent(lblEje)
                            .addComponent(lblLimites))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFuncion)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbEje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLimiteA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLimiteB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                        .addComponent(btnGraficar)))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblResultado)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLimites)
                    .addComponent(txtLimiteA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblA)
                    .addComponent(txtLimiteB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGraficar))
                .addGap(18, 18, 18)
                .addComponent(lblResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
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
        new ui.VentanaInicio().setVisible(true); //Regresamos a la ventana principal
            dispose(); // Cierra esta ventana
    }                                         

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        graficarIntegral();
    }                                           

    private void calcularIntegral() {
        try {
            String funcion = txtFuncion.getText().trim();
            double limiteA = Double.parseDouble(txtLimiteA.getText().trim());
            double limiteB = Double.parseDouble(txtLimiteB.getText().trim());
            String eje = (String) cmbEje.getSelectedItem();
            
            if (funcion.isEmpty()) {
                mostrarError("Ingresa una función.");
                return;
            }
            
            if (limiteA >= limiteB) {
                mostrarError("El límite A debe ser menor que B.");
                return;
            }
            
            double resultado = calcularIntegralDefinida(funcion, limiteA, limiteB, eje);
            
            String mensaje = String.format(
                "══════════════════════════════════════\n" +
                "         INTEGRAL DEFINIDA           \n" +
                "══════════════════════════════════════\n" +
                " Función: %-26s \n" +
                " Límites: [%-5.2f, %-5.2f] %-10s \n" +
                " Eje: %-30s \n" +
                "══════════════════════════════════════\n" +
                " Resultado: %-24.6f \n" +
                "══════════════════════════════════════",
                (eje.equals("X") ? "f(x) = " + funcion : "x = f(y) = " + funcion),
                limiteA, limiteB, "", eje, resultado
            );
            
            areaResultado.setText(mensaje);
            
        } catch (NumberFormatException e) {
            mostrarError("Los límites deben ser números válidos.");
        } catch (Exception e) {
            mostrarError("Error: " + e.getMessage());
        }
    }
    
    private double calcularIntegralDefinida(String funcion, double a, double b, String eje) {
        try {
            if (eje.equalsIgnoreCase("Y")) {
                return integralRespectoY(funcion, a, b);
            } else {
                return integralRespectoX(funcion, a, b);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error en cálculo: " + e.getMessage());
        }
    }
    
    private double integralRespectoX(String funcion, double a, double b) {
        //Crea un objeto usando la libreria MXParser
        Function f = new Function("f(x) = " + funcion);
        if (!f.checkSyntax()) { //Chequeamos la sintaxis de la función
            throw new RuntimeException(f.getErrorMessage());
        }
        
        int n = 1000; //Numero de subdivisiones del intervalo (a,b)
        if (n % 2 != 0) n++; //Se necesita que n sea par, si no se aumenta +1
        //h es el ancho de cada subintervalo
        double h = (b - a) / n;
        //Evalua la funcion en los limtes
        double suma = f.calculate(a) + f.calculate(b);
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            double fx = f.calculate(x); //Evalua la funcion en este punto
            suma += (i % 2 == 0) ? 2 * fx : 4 * fx;
        }
        
        return suma * h / 3;
    }
    
    private double integralRespectoY(String funcion, double c, double d) {
        try {
            String funcionInversa = obtenerFuncionInversa(funcion);
            Function f = new Function("f(y) = " + funcionInversa);
            
            if (!f.checkSyntax()) {
                throw new RuntimeException(f.getErrorMessage());
            }
            
            int n = 1000;
            if (n % 2 != 0) n++;
            
            double h = (d - c) / n;
            double suma = f.calculate(c) + f.calculate(d);
            
            for (int i = 1; i < n; i++) {
                double y = c + i * h;
                double fy = f.calculate(y);
                suma += (i % 2 == 0) ? 2 * fy : 4 * fy;
            }
            
            return suma * h / 3;
            
        } catch (Exception e) {
            throw new RuntimeException("No se pudo calcular respecto a Y: " + e.getMessage());
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
    
    private void graficarIntegral() {
        String funcion = txtFuncion.getText().trim();
        if (funcion.isEmpty()) {
            mostrarError("Ingresa una función para graficar.");
            return;
        }
        
        try {
            double limiteA = Double.parseDouble(txtLimiteA.getText().trim());
            double limiteB = Double.parseDouble(txtLimiteB.getText().trim());
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
                "Límites: [" + limiteA + ", " + limiteB + "]\n" +
                "Eje: " + eje,
                "Graficar Integral", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            mostrarError("Error al preparar gráfico: " + e.getMessage());
        }
    }
    
    private void limpiarCampos() {
        txtFuncion.setText("");
        txtLimiteA.setText("0");
        txtLimiteB.setText("1");
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
                new IntegralDefinida().setVisible(true);
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
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblEje;
    private javax.swing.JLabel lblFuncion;
    private javax.swing.JLabel lblLimites;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtFuncion;
    private javax.swing.JTextField txtLimiteA;
    private javax.swing.JTextField txtLimiteB;
    // End of variables declaration                   
}