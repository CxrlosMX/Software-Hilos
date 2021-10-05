/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelota.hiloclass;

import java.awt.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lamina.LaminaPelota;
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
    private LaminaPelota lamina;
    private String inicio;
    private String fin;
    private int id;

    //Constructor
    public PelotaHilo(Pelota pelota, LaminaPelota lamina, String inicio) {
        this.pelota = pelota;
        this.lamina = lamina;
        this.inicio = inicio;
        this.fin = null;
        id = idS++;
    }

    //Dentro de nuestro mètodo Run se realizara la tarea
    @Override
    public void run() {

        for (int i = 0; i < 3000; i++) {
            pelota.mueve_pelota(lamina.getBounds());
            lamina.paint(lamina.getGraphics());

            try {

                Thread.sleep(4);

            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(lamina, ex.getMessage(), "Error", 0);
            }
            if (Thread.interrupted()) {
                fin=dameHora();
            }

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

    /* public void setLamina(JPanel lamina) {
     this.lamina = lamina;
     }*/
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String dameHora() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Thread " + id + "\nInicio Proceso: " + inicio + "\nFin Proceso: " + fin + "\n";
    }


}