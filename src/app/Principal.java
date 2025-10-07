/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import ui.VentanaInicio;
/**
 *
 * @author mucun
 */
public class Principal {
    
    public static void main(String[] arg){
        //Establecer el estilo del sistema (look and feel)
        try{
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e){
            System.out.println("No se pudo aplicar estilos del sistema." + e.getMessage());
        }
        //Mostrar la ventana principal
        java.awt.EventQueue.invokeLater(new Runnable(){
           @Override
           public void run(){
               new VentanaInicio().setVisible(true);
           }
        });
    }
}
