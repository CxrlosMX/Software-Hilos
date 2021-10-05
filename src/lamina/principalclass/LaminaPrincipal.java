/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamina.principalclass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import lamina.LaminaPelota;
import pelota.hiloclass.PelotaHilo;
import pelotaclass.Pelota;

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
    private String cadena;
    //Lamina Datos
    private JPanel laminaDatos;
    private JTextArea areaMensajes;
    //Botones
    private JPanel laminaBotones;
    private JButton bIniciar, bSalir;
    //Lamina Pelota
    private LaminaPelota laminaPelota;
    //Prueba
    private JPanel lamina;

    public LaminaPrincipal() {
        /*
         Evento
         */
        EventoInicio evento = new EventoInicio();

        cadena = "";
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
        //-------------Botones------------------------------------------------------
        bIniciar = new JButton("INICIAR PROCESO");
        bIniciar.addActionListener(evento);
        laminaBotones.add(bIniciar);
        //--------------------------------
        bSalir = new JButton("Salir");
        bSalir.addActionListener(evento);
        laminaBotones.add(bSalir);
        //-------------Lamina Pelota--------------------------------------
        laminaPelota = new LaminaPelota();
        laminaPelota.setBackground(new Color(3, 100, 100));

        //-----------------
        lamina = new JPanel();

        //Agregando a la lamina principal
        add(lamina, BorderLayout.EAST);
        add(laminaDatos, BorderLayout.EAST);
        add(laminaBotones, BorderLayout.SOUTH);
        add(laminaPelota, BorderLayout.CENTER);
    }

    /*
     Clase interna para el evento
     */
    private class EventoInicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == bIniciar) {
                Pelota p = new Pelota();
                laminaPelota.add(p);
                Runnable pelota = new PelotaHilo(p, laminaPelota, dameHora());
                Thread hilo = new Thread(pelota);
                cadena += pelota.toString();
                areaMensajes.setText(cadena);
                hilo.start();
            }
            if(e.getSource()==bSalir){
            System.exit(0);
            }

        }

    }


    /*
     Mètodo que nos devuelve la hora actual
     */
    private String dameHora() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

}
