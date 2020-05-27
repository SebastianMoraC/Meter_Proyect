package co.utp.meter.Model;

import co.utp.meter.Model.Fabrica.Conexion;
import co.utp.meter.Model.Fabrica.Fabrica2;
import co.utp.meter.View.ModeloObserver;
import co.utp.meter.View.Observable;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;

public class Meter_Model implements ModeloObserver{
    private static Meter_Model instance=null;
    private String texto;
    
    private Meter_Model(){}
    private  static void createInstance()
    {
        if(instance==null)
        {
            synchronized(Meter_Model.class){
                if(instance==null) instance= new Meter_Model();
            }
        }
    }
    public static Meter_Model getInstance() 
    {
        return instance;
    }
    public static Meter_Model setInstance() 
    {
        if(instance == null) {
            createInstance();
            getInstance();
        }
        return getInstance();
    }
        
    
    @Override
    public void valorCambiado(String temporality) {
        //Nos llega el valor cambiado del modelo, que es el estado que nos interesa para cambiar la vista.
        //Actuamos en consecuencia de ese valor que nos ha llegado del modelo, actualizando el texto(JLabel) de nuestra vista.
        texto = temporality;
        System.out.println(temporality );
    }
    public void graph(){
        Fabrica2 grafica = new Fabrica2();
        Conexion opcion = grafica.getConexion(texto);
        
    }
            
           
    
}

    
