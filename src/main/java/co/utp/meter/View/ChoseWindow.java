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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ChoseWindow extends JFrame{
    private static volatile ChoseWindow instance = null;

    public JPanel panel;    

    public ChoseWindow(){}

    
    private  static void createInstance()
    {
        ChoseWindow instance = ChoseWindow.instance;
        if(instance==null)
        {
            synchronized(ChoseWindow.class){
                instance = ChoseWindow.instance;
                if(instance==null) ChoseWindow.instance= instance = new ChoseWindow();
            }
        }
    }
    public static ChoseWindow getInstance() 
    {
        return instance;
    }public static ChoseWindow setInstance() 
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
        labels("¿Desea escoger residencia o empresa?"); 
                      
    } 
    public void panels(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE); //Set the color in the panel
        this.getContentPane().add(panel); //Insert the panel to the frame

    }
    public void labels(String Stlabel){
        JLabel label = new JLabel(Stlabel,SwingConstants.CENTER);
        label.setOpaque(false);
        label.setFont(new Font("Bernard MT Condensed",Font.BOLD,35));
        label.setBounds(25, 10, 600, 200);
        label.setForeground(Color.BLACK);
        panel.add(label);
    }
    
    public void buttons(){
        JButton houseButton = new JButton("house");
        houseButton.setEnabled(true);
        houseButton.setBounds(100,280,240,240);
        houseButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonEnergy = new ImageIcon("casa.png"); //Get Image
        houseButton.setIcon(new ImageIcon(buttonEnergy.getImage().getScaledInstance(houseButton.getWidth(), houseButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        houseButton.setBackground(Color.WHITE);
        panel.add(houseButton);
        
        JButton factoryButton = new JButton("Factory");
        factoryButton.setEnabled(true);
        factoryButton.setBounds(400,280,240,240);
        factoryButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonImage = new ImageIcon("fabrica.png"); //Get Image
        factoryButton.setIcon(new ImageIcon(buttonImage.getImage().getScaledInstance(factoryButton.getWidth(), factoryButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        factoryButton.setBackground(Color.WHITE);
        panel.add(factoryButton);
                      
        eventaction(factoryButton);
        eventaction(houseButton);

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

}
