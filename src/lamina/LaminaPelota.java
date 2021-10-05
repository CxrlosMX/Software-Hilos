/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamina;

import pelotaclass.Pelota;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.ArrayList;

import javax.swing.JPanel;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 30-sep-2021
 *
 */
public class LaminaPelota extends JPanel {

    //Creamos un arrayList de objetos de la clase Pelota
    private ArrayList<Pelota> pelotas = new ArrayList<>();

    public void add(Pelota p) {
        pelotas.add(p);
    }

    @Override
    public void paintComponents(Graphics g) { //Sobreescribimos nuestro método paintComponents para poder dibujar
        super.paintComponent(g); //Llamamos al constructor del método
        Graphics2D g2 = (Graphics2D) g;  //Creamos un objeto de la clase Graphics2D que nos permitira dibujar figuras etc

        for (Pelota i : pelotas) {//Bucle para dibujar nuestras pelotas cada que se muevan
            /*
             Utilizamos el mètodo fill:
             Fills the interior of a Shape using the settings of the Graphics2D context.
             */
            g2.fill(i.getShape());
        }
    }
    /*
     Mètodo para agregar una pelota
     */

}
