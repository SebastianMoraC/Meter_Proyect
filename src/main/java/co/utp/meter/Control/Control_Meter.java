package co.utp.meter.Control;

import co.utp.meter.Control.Fabrica.Conexion;
import co.utp.meter.Control.Fabrica.Fabrica;
import co.utp.meter.Model.Meter_Model;
import co.utp.meter.View.Meter_View;

public class Control_Meter {
    private static Control_Meter instance = null;
    private final Meter_View view;
    private Meter_Model model;
    
    public Control_Meter(){
        this.view = Meter_View.setInstance();
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
        Fabrica consumo = new Fabrica();
        Conexion opcion = consumo.GetConexion(button);
        this.view.closeWindow();
        this.view.secondWindow();
    }
    public void thirdWindow(String button){
        this.view.closeSecondWindow();
        this.view.thirdWindow();
    }
    
    
       
}
