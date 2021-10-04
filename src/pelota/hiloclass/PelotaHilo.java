/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelota.hiloclass;

import java.awt.Component;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class PelotaHilo implements Runnable {
    /*
     Atributos
     */

    private static int idS = 1;
    private Pelota pelota;
    private Component lamina;
    private String inicio;
    private String fin;
    private int id;

    //Constructor
    public PelotaHilo(Pelota pelota, Component lamina, String inicio, String fin) {
        this.pelota = pelota;
        this.lamina = lamina;
        this.inicio = inicio;
        this.fin = fin;
        id = idS++;
    }

    //Dentro de nuestro mètodo Run se realizara la tarea
    @Override
    public void run() {
        pelota.mueve_pelota(lamina.getBounds());
        lamina.paint(lamina.getGraphics());
        try {

            Thread.sleep(4);

        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(lamina, ex.getMessage(), "Error", 0);
        }
    }

    public Pelota getPelota() {
        return pelota;
    }

    public void setPelota(Pelota pelota) {
        this.pelota = pelota;
    }

    public Component getLamina() {
        return lamina;
    }

    public void setLamina(JPanel lamina) {
        this.lamina = lamina;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Thread " + id + "\nInicio Proceso: " + inicio + "\nFin Proceso: " + fin + "\n";
    }

}
