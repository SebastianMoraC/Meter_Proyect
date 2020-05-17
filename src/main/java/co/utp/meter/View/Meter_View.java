package co.utp.meter.View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Meter_View extends JFrame{
    private static volatile Meter_View instance = null;
    public JPanel panel;

    private Meter_View(){}

    
    private  static void createInstance()
    {
        Meter_View instance = Meter_View.instance;
        if(instance==null)
        {
            synchronized(Meter_View.class){
                instance = Meter_View.instance;
                if(instance==null) Meter_View.instance= instance = new Meter_View();
            }
        }
    }
    public static Meter_View getInstance() 
    {
        return instance;
    }public static Meter_View setInstance() 
    {
        if(instance == null) {
            createInstance();
            getInstance();
        }
        return getInstance();
    }
    public void init(){
        this.setSize(700,600);
        this.setLocationRelativeTo(null); //Centra la ventana en la pantalla
        this.setTitle("WaE Meter Consumption");
        this.setMinimumSize(new Dimension(700,600)); //Set a minimum size to the frame

        startComponents();
    }
    public void render(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
     public void startComponents(){
        panels();
    }
     
    public void panels(){
        panel = new JPanel();
        panel.setBackground(Color.gray); //Set the color in the panel
        this.getContentPane().add(panel); //Insert the panel to the frame

    }
}
