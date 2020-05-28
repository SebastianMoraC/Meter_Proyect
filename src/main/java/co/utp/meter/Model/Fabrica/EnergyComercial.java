/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utp.meter.Model.Fabrica;

/**
 *
 * @author Sebastian
 */
public class EnergyComercial implements Conexion{
    public int number;
    public String link;
    public EnergyComercial(int number, String link){
        this.number = number;
        this.link = link;
        
    }
    @Override
    public int tiempo(){
        return number;
    }
    @Override
    public String link(){
           return link;
    }
}
