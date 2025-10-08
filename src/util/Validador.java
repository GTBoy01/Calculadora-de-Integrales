package util;
import javax.swing.JOptionPane;

 /**
     * Clase Validador
     * -----------------
     * Se encarga de verificar que los campos ingresados por el usuario sean válidos
     * antes de ejecutar los cálculos.
     * 
     * Usamoe try/catch para capturar errores y mostrar mensajes amigables y no se rompa el programa.
     * 
     */

public class Validador {
    /** Verificar que un campo de texto no esté vacío 
     * @param texto El texto que el usuario ingresó.
     * @param nombreCampo El nombre de campo (para mostrar en el mensaje).
     * @return true si es válido, false si está vacío.
     */
    public static boolean validarCampoVacio(String texto, String nombreCampo){
        try {
            if(texto == null || texto.trim().isEmpty()){
                throw new Exception("El campo '" + nombreCampo + "' no puede estar vacío.");
            }
            return true; //Si no esta vacío se considera válido
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación.", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    /** 
     * Verificar que un texto contenga números válido (por ejemplo para límites a y b)
     * @param texto El texto que el usuario ingresó.
     * @param nombreCampo El nombre de campo (para mostrar en el mensaje).
     * @return true si es válido, false si está vacío.
     */
    public static boolean validarNumero(String texto, String nombreCampo){
        try{
            if(texto == null || texto.trim().isEmpty()){
                throw new Exception("Debe ingresar un valor en '" + nombreCampo + "'.");
            }
            //Intenta convertir el texto a número
            Double.parseDouble(texto);
            return true;
        }catch(NumberFormatException e){
            //Capturamos cuando el texto no es número
            JOptionPane.showMessageDialog(null, "El valor ingresado en '" + nombreCampo + "' debe ser numérico.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }catch(Exception e){
            //Capturando errores generales
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     * Verifica que una función matemática tenga contenido (por ejemplo "3x^2 + 2x - 5").
     * @param funcion Texto ingresado en el campo Función.
     * @return true si es válido, false si está vacío.
     */
    public static boolean validarFuncion(String funcion){
        try{
            if(funcion == null || funcion.trim().isEmpty()){
                throw new Exception("Debe ingresar una función para calcular.");
            }
            
            //Válidar que solo contenga letras, números y símbolos matemáticos comunes
            if(!funcion.matches("[0-9a-zA-ZxXyY+\\-*/^().\\s]+")){
                throw new Exception("La función contiene caracteres no válidos");
            }
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error en la función", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
