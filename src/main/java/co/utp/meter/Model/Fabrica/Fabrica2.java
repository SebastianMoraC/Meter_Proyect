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
public class Fabrica2 {
    public Conexion getConexion(String estado){
        if(estado.equalsIgnoreCase("energyFactoryMonth")){
                return new EnergyComercial();
            }         
        else if(estado.equalsIgnoreCase("energyFactoryWeek")){
                return new EnergyComercial();
        }
        else if(estado.equalsIgnoreCase("energyFactoryDay")){
                return new EnergyComercial();
        }
        else if(estado.equalsIgnoreCase("energyFactoryHour")){
                return new EnergyComercial();
        }
        else if(estado.equalsIgnoreCase("energyhouseMonth")){
               return new EnergyResidential();
        }
         else if(estado.equalsIgnoreCase("energyhouseWeek")){
               return new EnergyResidential();
        }
        else if(estado.equalsIgnoreCase("energyhouseDay")){
               return new EnergyResidential();
        }
        else if(estado.equalsIgnoreCase("energyhouseHour")){
               return new EnergyResidential();
        }
        
        else if(estado.equalsIgnoreCase("aguaFactoryMonth")){
                return new WaterComercial();
        }
        else if(estado.equalsIgnoreCase("aguaFactoryWeek")){
                return new WaterComercial();
        }
        else if(estado.equalsIgnoreCase("aguaFactoryDay")){
                return new WaterComercial();
        }
        else if(estado.equalsIgnoreCase("aguaFactoryHour")){
                return new WaterComercial();
        }
        else if(estado.equalsIgnoreCase("aguahouseMonth")){
                return new WaterResidential();
        }
         else if(estado.equalsIgnoreCase("aguahouseWeek")){
                return new WaterResidential();
        }
        else if(estado.equalsIgnoreCase("aguahouseDay")){
                return new WaterResidential();
        }
        else if(estado.equalsIgnoreCase("aguahouseHour")){
                return new WaterResidential();
        }
        return new VacioEstado();
    }
    
}
