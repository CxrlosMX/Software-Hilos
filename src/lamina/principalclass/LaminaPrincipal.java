/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamina.principalclass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
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

    public LaminaPrincipal() {
        setLayout(new BorderLayout());
        lamina = new LaminaPelota();
        lamina.setBackground(Color.PINK);
        add(lamina, BorderLayout.CENTER);
        cadena="";
        JPanel laminaBotones = new JPanel();
        laminaE = new JPanel();
        laminaE.setBackground(Color.yellow);
        /*
         -------------------
         */
        laminaDatos = new JPanel();
        laminaDatos.setBackground(Color.BLUE);
        laminaDatos.setLayout(new BorderLayout());
        areaMensajes = new JTextArea(5, 20);
        areaMensajes.setLineWrap(true);//Salto de lineas automatico
        areaMensajes.setBackground(Color.DARK_GRAY.brighter().brighter().brighter());
        JLabel t = new JLabel("DATOS");
        laminaDatos.add(t, BorderLayout.NORTH);
        laminaDatos.add(areaMensajes, BorderLayout.CENTER);
        ///-----------------

        //---
        ponerBoton(laminaBotones, "Dale!", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                comienza_el_juego();
            }

        });

        ponerBoton(laminaBotones, "Salir", new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                System.exit(0);

            }

        });

        add(laminaBotones, BorderLayout.SOUTH);
        add(laminaDatos, BorderLayout.EAST);
        // add(laminaE,BorderLayout.EAST);
    }

    //Ponemos botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente) {

        JButton boton = new JButton(titulo);

        c.add(boton);

        boton.addActionListener(oyente);

    }

    //Añade pelota y la bota 1000 veces
    public void comienza_el_juego() {

        Pelota p = new Pelota();

        lamina.add(p);

        PelotaHilo r = new PelotaHilo(p, lamina, dameHora());
        cadena += r.toString();
        areaMensajes.setText(cadena);
        Thread hilo = new Thread(r);
        hilo.start();
       

    }

    private String dameHora() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    private LaminaPelota lamina;
    private JPanel laminaDatos;
    private JTextArea areaMensajes;
    private JPanel laminaE;
    private static String cadena;
}
