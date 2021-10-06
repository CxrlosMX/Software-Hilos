/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marcoclass;

import javax.swing.JFrame;
import lamina.LaminaPelota;
import lamina.principalclass.LaminaPrincipal;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 30-sep-2021
 *
 */
/*
 Creamos nuestra clase marco
 */
public class Marco extends JFrame {

    public Marco() {
        setVisible(true);
        setResizable(false);
        setSize(600, 800);
        setLocation(500, 200);
        setTitle("Hilos Software");
        LaminaPrincipal lamina = new LaminaPrincipal(); //Instancia 
        add(lamina); //Add laminaPelotas a nuestro marco

    }
}
