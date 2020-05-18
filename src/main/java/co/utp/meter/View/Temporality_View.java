package co.utp.meter.View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Temporality_View extends JFrame{
    private static Temporality_View instance=null;
    public JPanel panel;
    
    private Temporality_View(){
        setTitle("Temporalidad.");
        setSize(700,600);
        setLocationRelativeTo(null);
        //buttonsArray  = new JButton[26];
        this.getContentPane().setBackground(Color.BLACK);
    }
    private  static void createInstance()
    {
        if(instance==null)
        {
            synchronized(Temporality_View.class){
                if(instance==null) instance= new Temporality_View();
            }
        }
    }
    public static Temporality_View getInstance() 
    {
        return instance;
    }
    public static Temporality_View setInstance() 
    {
        if(instance == null) {
            createInstance();
            getInstance();
        }
        return getInstance();
    }
    public void tempVisible(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void tempPanels(){
        panel= new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);//agregar el panel a la ventana
    }
    
    
    
}
