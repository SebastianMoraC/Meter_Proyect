package co.utp.meter.View;

import co.utp.meter.Control.Control_Meter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

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
    }
    public void render(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
     public void startComponents(){
        init();
        panels();
        buttons();
        render();
        labels("¿Qué consumo deseas saber?"); 
                      
    }
     
    public void panels(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY); //Set the color in the panel
        this.getContentPane().add(panel); //Insert the panel to the frame

    }
    public void labels(String Stlabel){
        JLabel label = new JLabel(Stlabel,SwingConstants.CENTER);
        label.setOpaque(false);
        label.setFont(new Font("Bernard MT Condensed",Font.BOLD,45));
        label.setBounds(30, 20, 600, 200);
        label.setForeground(Color.BLACK);
        panel.add(label);
    }
    
    public void buttons(){
        JButton energyButton = new JButton("energy");
        energyButton.setEnabled(true);
        energyButton.setBounds(100,300,200,200);
        energyButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonEnergy = new ImageIcon("electricidad.png"); //Get Image
        energyButton.setIcon(new ImageIcon(buttonEnergy.getImage().getScaledInstance(energyButton.getWidth(), energyButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        energyButton.setBackground(Color.lightGray);
        panel.add(energyButton);
        
        JButton waterButton = new JButton("agua");
        waterButton.setEnabled(true);
        waterButton.setBounds(400,300,200,200);
        waterButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonImage = new ImageIcon("agua.png"); //Get Image
        waterButton.setIcon(new ImageIcon(buttonImage.getImage().getScaledInstance(waterButton.getWidth(), waterButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        waterButton.setBackground(Color.lightGray);
        panel.add(waterButton);
                      
        eventaction(waterButton);
        eventaction(energyButton);

    }
    private void eventaction(JButton button){
        ActionListener actlistener = new ActionListener(){ //But when you go to use a interface you have to instancied acion listener
            @Override
            public void actionPerformed(ActionEvent e) {//You have to write hear that you want to happend whe you use the button
                String nameButton=(button.getActionCommand());
                Control_Meter control = new Control_Meter();
                control.secondWindow(nameButton);
            }
        };
        button.addActionListener(actlistener); //Add to act listener to the button
        
    }
    public void secondWindow(){
        ChoseWindow window = new ChoseWindow();
        window.startComponents();
    }
    public void closeWindow(){
        this.setVisible(false);

    }

}
