/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamina.principalclass;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 04-oct-2021
 *
 */
public class LaminaPrincipal extends JPanel {
    /*
     Para la realizaciòn de la interfaz grafica se planifico en un MockUp
     */

    //Lamina Datos

    private JPanel laminaDatos;
    private JTextArea areaMensajes;

    public LaminaPrincipal() {
        //Asignando Layout Lamina Principal
        setLayout(new BorderLayout());
        //Instancias laminas
        laminaDatos = new JPanel();
        
        //------------------------------------------------Lamina datos
        areaMensajes=new JTextArea(laminaDatos.getWidth(), laminaDatos.getHeight());
        areaMensajes.setBackground(Color.yellow);
        laminaDatos.add(areaMensajes);
        
        
        
        
        
        //Agregando a la lamina principal
        add(laminaDatos,BorderLayout.EAST);
    }

}
