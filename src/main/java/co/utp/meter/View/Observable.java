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
/**
 * Interfaz obserbable. Esta interfaz se implementara a toda clase que quiera ser observable y notificar a observadores de lo que ocurra internamente en su clase.
 * @author fon
 */
public interface Observable <T>{
    /**
     * Añade observadores a nuestro observable
     * @param t : Observador a añadir. Es un genérico y acepta cualquier tipo de clase/interfaz.
     */
    public void addObservador(T t);
    
    /**
     * Borra observadores de nuestro observable
     * @param t : Observador a eliminar. Es un generico y acepta cualquier tipo de clase/interfaz.
     */
    public void removeObservador(T t);
}
