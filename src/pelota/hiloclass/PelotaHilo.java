/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelota.hiloclass;

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
    private JPanel lamina;
    private Date inicio;
    private Date fin;
    private int id;

    //Constructor
    public PelotaHilo(Pelota pelota, JPanel lamina, Date inicio, Date fin) {
        this.pelota = pelota;
        this.lamina = lamina;
        this.inicio = inicio;
        this.fin = fin;
        id = idS++;
    }

    //Dentro de nuestro mètodo Run se realizara la tarea
    @Override
    public void run() {
        try {
            Thread.sleep(4);
            pelota.mueve_pelota(lamina.getBounds());
            lamina.print(lamina.getGraphics());
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

    public JPanel getLamina() {
        return lamina;
    }

    public void setLamina(JPanel lamina) {
        this.lamina = lamina;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Thread " + id + "\nInicio Proceso: " + inicio + "\nFin Proceso: " + fin + "\n";
    }

}
