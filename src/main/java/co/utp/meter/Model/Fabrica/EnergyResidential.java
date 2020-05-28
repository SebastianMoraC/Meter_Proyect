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
public class EnergyResidential implements Conexion{
    public int number;
    public String link;
    public String name;
    public EnergyResidential(int number, String link, String name){
        this.number = number;
        this.link = link;
        this.name = name;
    }
    @Override
    public int tiempo(){
        return number;
    }
    @Override
    public String link(){
           return link;
    }
    @Override
    public String name(){
           return name;
    }
}
