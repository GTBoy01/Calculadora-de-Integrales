/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;


/**
 *
 * @author macom
 */
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.JEP;
        //Variable que almacena las funciones a derivar



 public class DerivadaDefinidasX {
    private String funcionx = "";
    // DJep es la clase encargada de la derivacion en su escencia
    DJep djep;
    Node nodoFuncionx;
    Node nodoDerivadax;

 public  DerivadaDefinidasX (){
        //...
    }

    public void setFuncionADerivar(String funcion) {
        this.funcionx = funcion;
    }

    public String getFuncionDerivada() {
        return this.funcionx;
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
            this.nodoFuncionx = this.djep.parse(this.funcionx);

            // deriva la funcion con respecto a x
            Node diff = this.djep.differentiate(nodoFuncionx, "x");

            // Simplificamos la funcion con respecto a x
            this.nodoDerivadax = this.djep.simplify(diff);

            // Convertimos el valor simplificado en un String
            this.funcionx = this.djep.toString(this.nodoDerivadax);

        } catch (ParseException e) {
            this.funcionx = "NaN";
            System.out.println("Error: " + e.getErrorInfo());
        }

    }
    
        public double evaluar(double valorX) {
        try {
            // Crea un evaluador matemático
            JEP jep = new JEP();
            jep.addStandardFunctions();
            jep.addStandardConstants();

            // Define el valor de x (el que ingrese el usuario)
            jep.addVariable("x", valorX);

            // Analiza la función que tengas guardada en this.funcion
            jep.parseExpression(this.funcionx);

            // Devuelve el resultado numérico
            return jep.getValue();

        } catch (Exception e) {
            System.out.println("Error evaluando función: " + e.getMessage());
            return Double.NaN;
        }
    }
        

}


