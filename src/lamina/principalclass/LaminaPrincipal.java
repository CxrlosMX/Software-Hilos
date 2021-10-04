/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamina.principalclass;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import lamina.LaminaPelotas;

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
    //Botones
    private JPanel laminaBotones;
    private JButton bIniciar;
    //Lamina Pelota
    private LaminaPelotas laminaPelota;
    
    public LaminaPrincipal() {
        //Asignando Layout Lamina Principal
        setLayout(new BorderLayout());
        //Instancias laminas
        laminaDatos = new JPanel();
        laminaBotones = new JPanel();
        //------------------------------------------------Lamina datos
        laminaDatos.setLayout(new BorderLayout());
        areaMensajes = new JTextArea(5, 20);
        areaMensajes.setLineWrap(true);//Salto de lineas automatico
        areaMensajes.setBackground(Color.DARK_GRAY.brighter().brighter().brighter());
        JLabel t = new JLabel("DATOS");
        laminaDatos.add(t, BorderLayout.NORTH);
        laminaDatos.add(areaMensajes, BorderLayout.CENTER);
        //-------------Boton------------------------------------------------------
        bIniciar = new JButton("INICIAR PROCESO");
        laminaBotones.add(bIniciar);
        //-------------Lamina Pelota--------------------------------------
        laminaPelota=new LaminaPelotas();
        laminaPelota.setBackground(new Color(3, 100, 100));
        //Agregando a la lamina principal
        add(laminaDatos, BorderLayout.WEST);
        add(laminaBotones, BorderLayout.SOUTH);
        add(laminaPelota,BorderLayout.CENTER);
    }
    
    /*
    Clase interna para el evento
    */
   

}
