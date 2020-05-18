/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utp.meter.Control.Fabrica;

/**
 *
 * @author Sebastian
 */
public class EstadoVacio implements Conexion {
    @Override
    public void residential(){
        System.out.println("No se ha detectado estado.");
    }
    @Override
    public void factory(){
        System.out.println("No se ha detectado estado.");
    
    }
}
