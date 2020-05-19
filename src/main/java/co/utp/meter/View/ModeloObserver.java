/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utp.meter.View;

/**
 *
 * @author Sebastian
 */
public interface ModeloObserver {
    
    /**
     * Metodo valorCambiado. Unico metodo de la interfaz pues solo nos interesa como observadores el valor "valor" para modificar nuestra vista.
     * 
     * @param valor : Notificación del nuevo valor que nos llega del modelo. El modelo notificará con este metodo a cada observador, el nuevo valor de la logica.
     */
    public void valorCambiado(String valor);

}