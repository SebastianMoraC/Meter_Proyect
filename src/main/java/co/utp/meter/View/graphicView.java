/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utp.meter.View;

import co.utp.meter.Model.Ventana;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Sebastian
 */
public class graphicView extends JFrame {
     private static graphicView instance=null;
    public graphicView(){}
    private  static void createInstance(
    )
    {
        graphicView instance = graphicView.instance;
        if(instance==null)
        {
            synchronized(graphicView.class){
                instance = graphicView.instance;
                if(instance==null) graphicView.instance= instance = new graphicView();
            }
        }
    }
    public static graphicView getInstance() 
    {
        return instance;
    }public static graphicView setInstance() 
    {
        if(instance == null) {
            createInstance();
            getInstance();
        }
        return getInstance();
    }

   

    public void initUI(String link, int tiempo) {
        Ventana window = new Ventana();
        ChartPanel panel = window.graficarXY(link,tiempo);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Color.white);
        add(panel);
        pack();
        setTitle("Consumo de Energía");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
