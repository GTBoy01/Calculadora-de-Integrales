/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author macom
 */
public class DerivadaDefinidasY {
        private String funciony = "";
    // DJep es la clase encargada de la derivacion en su escencia
    DJep djep;
    Node nodoFunciony;
    Node nodoDerivaday;

 public  DerivadaDefinidasY (){
        //...
    }

    public void setFuncionADerivar(String funcion) {
        this.funciony = funcion;
    }

    public String getFuncionDerivada() {
        return this.funciony;
    }

    public void derivar() {

        try {

            this.djep = new DJep();
            // agrega funciones estandares cos(x), sin(x)
            this.djep.addStandardFunctions();

            // agrega constantes estandares, pi, e, etc
            this.djep.addStandardConstants();

            // por si existe algun numero complejo
            this.djep.addComplex();

            // permite variables no declarables
            this.djep.setAllowUndeclared(true);

            // permite asignaciones
            this.djep.setAllowAssignment(true);

            // regla de multiplicacion o para sustraccion y sumas
            this.djep.setImplicitMul(true);

            // regla de multiplicacion o para sustraccion y sumas
            this.djep.addStandardDiffRules();

            // coloca el nodo con una funcion preestablecida
            this.nodoFunciony = this.djep.parse(this.funciony);

            // deriva la funcion con respecto a y
            Node diff = this.djep.differentiate(nodoFunciony, "y");

            // Simplificamos la funcion con respecto a y
            this.nodoDerivaday = this.djep.simplify(diff);

            // Convertimos el valor simplificado en un String
            this.funciony = this.djep.toString(this.nodoDerivaday);

        } catch (ParseException e) {
            this.funciony = "NaN";
            System.out.println("Error: " + e.getErrorInfo());
        }

    }
    
        public double evaluar(double valorY) {
        try {
            // Crea un evaluador matemático
            JEP jep = new JEP();
            jep.addStandardFunctions();
            jep.addStandardConstants();

            // Define el valor de y (el que ingrese el usuario)
            jep.addVariable("y", valorY);

            // Analiza la función que tengas guardada en this.funcion
            jep.parseExpression(this.funciony);

            // Devuelve el resultado numérico
            return jep.getValue();

        } catch (Exception e) {
            System.out.println("Error evaluando función: " + e.getMessage());
            return Double.NaN;
        }
    }
}
