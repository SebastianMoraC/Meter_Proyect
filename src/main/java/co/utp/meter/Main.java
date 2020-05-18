package co.utp.meter;

import co.utp.meter.Model.Meter_Model;
import co.utp.meter.Control.Control_Meter;

public class Main {
    public static void main(String[] args) {
        
       Meter_Model read =Meter_Model.setInstance(); //Create model Object
       read.readFile(); 
       
       Control_Meter meter = Control_Meter.setInstance();
       meter.build();
        
    }
}
