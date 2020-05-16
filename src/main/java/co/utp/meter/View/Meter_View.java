package co.utp.meter.View;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Meter_View extends JFrame{
    private static volatile Meter_View instance = null;
    JPanel Panel;
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
    }
    public void initPanel(){
        Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(Panel);
    }
    public void render(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
