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
public class Fabrica {
    public Conexion GetConexion(String estado){
                   
            if(estado.equalsIgnoreCase("agua")){
                return new Water();
            }
            
            else if(estado.equalsIgnoreCase("energy")){
               return new Energy();
            }
        return new EstadoVacio();
    }
}
