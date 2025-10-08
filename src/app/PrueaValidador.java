/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import util.Validador;
import javax.swing.JOptionPane;

public class PrueaValidador {
    public static void main(String[] args) {
        String funcion = JOptionPane.showInputDialog("Ingrese una función:");
        String a = JOptionPane.showInputDialog("Ingrese límite inferior a:");
        String b = JOptionPane.showInputDialog("Ingrese límite superior b:");

        if (Validador.validarFuncion(funcion)
                && Validador.validarNumero(a, "Límite a")
                && Validador.validarNumero(b, "Límite b")) {
            JOptionPane.showMessageDialog(null, "¡Todo válido!");
        }
    }
}
