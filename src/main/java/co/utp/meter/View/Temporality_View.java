package co.utp.meter.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Temporality_View extends JFrame{
    private static Temporality_View instance=null;
    public JPanel panel;
    
    public Temporality_View(){}
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
    
    public void init(){
        setTitle("WaE Meter Consumption.");
        setSize(700,600);
        setLocationRelativeTo(null);
        //buttonsArray  = new JButton[26];
        this.getContentPane().setBackground(Color.BLACK);
    }
    
    public void render(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void startComponents(){
        init();
        panels();
        buttons();
        render();
        labels("Elige la temporalidad"); 
                      
    }
    
    public void panels(){
        panel= new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);//agregar el panel a la ventana
    }
    
    public void labels(String Stlabel){
        JLabel label = new JLabel(Stlabel,SwingConstants.CENTER);
        label.setOpaque(false);
        label.setFont(new Font("Bernard MT Condensed",Font.BOLD,45));
        label.setBounds(30, 0, 600, 100);
        label.setForeground(Color.BLACK);
        panel.add(label);
    }
    
    public void buttons(){        
        JButton hourButton = new JButton("Hour");
        hourButton.setEnabled(true);
        hourButton.setBounds(120,120,185,185);
        hourButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonHour = new ImageIcon("hora.png"); //Get Image
        hourButton.setIcon(new ImageIcon(buttonHour.getImage().getScaledInstance(hourButton.getWidth(), hourButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        hourButton.setBackground(Color.WHITE);
        panel.add(hourButton);
        
        JButton dayButton = new JButton("Day");
        dayButton.setEnabled(true);
        dayButton.setBounds(400,120,185,185);
        dayButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonDay = new ImageIcon("dia.png"); //Get Image
        dayButton.setIcon(new ImageIcon(buttonDay.getImage().getScaledInstance(dayButton.getWidth(), dayButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        dayButton.setBackground(Color.WHITE);
        panel.add(dayButton);  
        
        JButton weekButton = new JButton("Week");
        weekButton.setEnabled(true);
        weekButton.setBounds(120,340,185,185);
        weekButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonWeek = new ImageIcon("week.png"); //Get Image
        weekButton.setIcon(new ImageIcon(buttonWeek.getImage().getScaledInstance(weekButton.getWidth(), weekButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        weekButton.setBackground(Color.WHITE);
        panel.add(weekButton);
        
        JButton monthButton = new JButton("Month");
        monthButton.setEnabled(true);
        monthButton.setBounds(400,340,195,195);
        monthButton.setBorder(BorderFactory.createEmptyBorder()); //Border of image
        ImageIcon buttonMonth = new ImageIcon("mes.png"); //Get Image
        monthButton.setIcon(new ImageIcon(buttonMonth.getImage().getScaledInstance(monthButton.getWidth(), monthButton.getHeight(),Image.SCALE_SMOOTH))); //Insert image in the button with the size of the button 
        monthButton.setBackground(Color.WHITE);
        panel.add(monthButton);
                        
        //eventaction(dayButton);
        //eventaction(hourButton);
        //eventaction(weekButton);
        //eventaction(monthButton);
    }
    
    
    
}
