package co.utp.meter;

import co.utp.meter.Model.Meter_Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class Main {
    public static void main(String[] args) {
       Meter_Model read = new Meter_Model(); //Create model Object
       read.readFile(); 
       
        
    }
}
