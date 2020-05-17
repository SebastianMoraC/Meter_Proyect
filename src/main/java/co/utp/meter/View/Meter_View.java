package co.utp.meter.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
        buttons();
    }
     
    public void panels(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY); //Set the color in the panel
        this.getContentPane().add(panel); //Insert the panel to the frame

    }
    public void buttons(){
        JButton energyButton = new JButton();
        energyButton.setEnabled(true);
        energyButton.setBounds(100,300,200,200);
        energyButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonEnergy = new ImageIcon("electricidad.png"); //Get Image
        energyButton.setIcon(new ImageIcon(buttonEnergy.getImage().getScaledInstance(energyButton.getWidth(), energyButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        energyButton.setBackground(Color.lightGray);
        panel.add(energyButton);
        
        JButton waterButton = new JButton();
        waterButton.setEnabled(true);
        waterButton.setBounds(400,300,200,200);
        waterButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonImage = new ImageIcon("agua.png"); //Get Image
        waterButton.setIcon(new ImageIcon(buttonImage.getImage().getScaledInstance(waterButton.getWidth(), waterButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        waterButton.setBackground(Color.lightGray);
        panel.add(waterButton);
        
        
        
    }

    private void setMaximumSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
