package co.utp.meter.Control;

import co.utp.meter.Control.Fabrica.Conexion;
import co.utp.meter.Control.Fabrica.Fabrica;
import co.utp.meter.Model.Fabrica.Fabrica2;
import co.utp.meter.Model.Meter_Model;
import co.utp.meter.View.Meter_View;
import co.utp.meter.View.TemporalityWindow;
import java.awt.EventQueue;

public class Control_Meter {
    private static Control_Meter instance = null;
    private final Meter_View view;
    public Meter_Model model;
    public String query;
    
    public Control_Meter(){
        this.view = Meter_View.setInstance();
        this.model = Meter_Model.setInstance();

    }
    private  static void createInstance()
    {
        if(instance==null)
        {
            synchronized(Control_Meter.class){
                if(instance==null) instance= new Control_Meter();
            }
        }
    }
    public static Control_Meter getInstance() 
    {
        return instance;
    }
    public static Control_Meter setInstance() 
    {
        if(instance == null) {
            createInstance();
            getInstance();
        }
        return getInstance();
    }
    public void build(){
        
        this.view.startComponents();
    }
    public void secondWindow(String button){
        query = button;
        Fabrica consumo = new Fabrica();
        Conexion opcion = consumo.GetConexion(button);
        this.view.closeWindow();
        this.view.secondWindow(button);
    }
    public void thirdWindow(String button){
        TemporalityWindow window = TemporalityWindow.setInstance();
        window.initObserver();
        window.addObservador(model);
        this.view.closeSecondWindow();
        window.startComponents(button);
    }
    public void modelo(){
         view.closeThirdWindow();
   
         model.graph();
                
    }
    public void graph(String link, int tiempo, String name){
       
        view.graphicView(link, tiempo,name);   
    }         
}
