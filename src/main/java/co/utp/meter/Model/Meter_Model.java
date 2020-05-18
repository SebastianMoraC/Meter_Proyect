package co.utp.meter.Model;

public class Meter_Model {
    private static Meter_Model instance=null;
    
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
        
        public void readFile(){

        Read prueba = new Read();
        prueba.readFile2();
        }
}

    
