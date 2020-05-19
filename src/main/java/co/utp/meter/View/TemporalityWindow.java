package co.utp.meter.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TemporalityWindow extends JFrame implements Observable<ModeloObserver>{
    private static TemporalityWindow instance=null;
    public JPanel panel;
    private ArrayList<ModeloObserver> observadores;
    private String query;
    

    
    public TemporalityWindow(){}
    private  static void createInstance()
    {
        if(instance==null)
        {
            synchronized(TemporalityWindow.class){
                if(instance==null) instance= new TemporalityWindow();
            }
        }
    }
    public static TemporalityWindow getInstance() 
    {
        return instance;
    }
    public static TemporalityWindow setInstance() 
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
    public void initObserver(){
        query="";
        observadores = new ArrayList<ModeloObserver>();

    }
    public void startComponents(String button){
        query = button;
        init();
        panels();
        buttons();
        render();
        labels("Elige la temporalidad"); 
                      
    }
    
    public void panels(){
        panel= new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE); //Set the color in the panel
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
                        
        eventaction(dayButton);
        eventaction(hourButton);
        eventaction(weekButton);
        eventaction(monthButton);

    }
    private void eventaction(JButton button){
        ActionListener actlistener = new ActionListener(){ //But when you go to use a interface you have to instancied acion listener
            @Override
            public void actionPerformed(ActionEvent e) {//You have to write hear that you want to happend whe you use the button
                String nameButton=(button.getActionCommand());
                query = query + nameButton;
                notificarObservadores(query);
                
            }
        };
        button.addActionListener(actlistener); //Add to act listener to the button
        
    }
    
    
    
    @Override
    public void addObservador(ModeloObserver t) {
       
        //Añadimos el observador a nuestro arraylist
        observadores.add(t);
        
        //Notificamos el valor a nuestros observadores ya que tenemos un nuevo observador que necesita saber el valor.
        notificarObservadores(query);
    }

    /**
     * removeObservador: Borra observadores a nuestro modelo
     * @param t : observador que queramos borrar.
     */
    //**En realidad no vamos a emplear en nuestro ejemplo este metodo, pero es importante tenerlo en cuenta.
    @Override
    public void removeObservador(ModeloObserver t) {
        observadores.remove(t);
    }
    
    /**
     * Método que notifica a nuestros observadores los cambios que nos interese que sepan.
     * @param t : estado del valor del numero.
     */
    private void notificarObservadores(String  t) {
        //Nos recorremos el arraylist de los observadores
        for(ModeloObserver o : observadores){
            //Le a cada observador que el valor se ha cambiado al nuevo valor "t".
            //Recuerdo que para este caso, estamos notificando a cada vista que tengamos, el nuevo valor que tiene el numero, para que estas modifiquen su JLabel como output de la logica.
            o.valorCambiado(t);
        }
    }
   
}
