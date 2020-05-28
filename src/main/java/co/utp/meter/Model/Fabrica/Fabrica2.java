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
                return new EnergyComercial(744,"ConsumoEnergiaComercial.csv");
            }         
        else if(estado.equalsIgnoreCase("energyFactoryWeek")){
                return new EnergyComercial(168,"ConsumoEnergiaComercial.csv");
        }
        else if(estado.equalsIgnoreCase("energyFactoryDay")){
                return new EnergyComercial(24,"ConsumoEnergiaComercial.csv");
        }
        else if(estado.equalsIgnoreCase("energyFactoryHour")){
                return new EnergyComercial(1,"ConsumoEnergiaComercial.csv");
        }
        else if(estado.equalsIgnoreCase("energyhouseMonth")){
               return new EnergyResidential(744,"ConsumoEnergiaResidencial.csv");
        }
         else if(estado.equalsIgnoreCase("energyhouseWeek")){
               return new EnergyResidential(168,"ConsumoEnergiaResidencial.csv");
        }
        else if(estado.equalsIgnoreCase("energyhouseDay")){
               return new EnergyResidential(24,"ConsumoEnergiaResidencial.csv");
        }
        else if(estado.equalsIgnoreCase("energyhouseHour")){
               return new EnergyResidential(1,"ConsumoEnergiaResidencial.csv");
        }
        
        else if(estado.equalsIgnoreCase("aguaFactoryMonth")){
                return new WaterComercial(744,"ConsumoAguaComercial.csv");
        }
        else if(estado.equalsIgnoreCase("aguaFactoryWeek")){
                return new WaterComercial(168,"ConsumoAguaComercial.csv");
        }
        else if(estado.equalsIgnoreCase("aguaFactoryDay")){
                return new WaterComercial(24,"ConsumoAguaComercial.csv");
        }
        else if(estado.equalsIgnoreCase("aguaFactoryHour")){
                return new WaterComercial(1,"ConsumoAguaComercial.csv");
        }
        else if(estado.equalsIgnoreCase("aguahouseMonth")){
                return new WaterResidential(744,"ConsumoAguaResidencial.csv");
        }
         else if(estado.equalsIgnoreCase("aguahouseWeek")){
                return new WaterResidential(168,"ConsumoAguaResidencial.csv");
        }
        else if(estado.equalsIgnoreCase("aguahouseDay")){
                return new WaterResidential(24,"ConsumoAguaResidencial.csv");
        }
        else if(estado.equalsIgnoreCase("aguahouseHour")){
                return new WaterResidential(1,"ConsumoAguaResidencial.csv");
        }
        return new VacioEstado(0,"");
    }
    
}
