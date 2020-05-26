package co.utp.meter;

import co.utp.meter.Control.Control_Meter;

public class Main {
    public static void main(String[] args) {
               
       Control_Meter meter = Control_Meter.setInstance();
       meter.build();
        
    }
}
