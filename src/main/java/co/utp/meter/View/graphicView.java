/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utp.meter.View;

import co.utp.meter.Control.Control_Meter;
import co.utp.meter.Main;
import co.utp.meter.Model.Ventana;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
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

   

    public void initUI(String link, int tiempo,String name) {
        Ventana window = new Ventana();
        ChartPanel panel = window.graficarXY(link,tiempo,name);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Color.white);
        this.add(panel);
        this.pack();
        this.setTitle(name);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
	@Override
	public void windowClosing(WindowEvent e) {
               
               Control_Meter meter = new Control_Meter();
               meter.build();
	}
        });
    }
}
