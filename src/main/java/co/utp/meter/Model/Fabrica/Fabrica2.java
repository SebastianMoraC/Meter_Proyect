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
                return new EnergyComercial(744,"ConsumoEnergiaComercial.csv","Consumo de Energia Comercial Mensual");
            }         
        else if(estado.equalsIgnoreCase("energyFactoryWeek")){
                return new EnergyComercial(168,"ConsumoEnergiaComercial.csv", "Consumo de Energia Comercial Semanal");
        }
        else if(estado.equalsIgnoreCase("energyFactoryDay")){
                return new EnergyComercial(24,"ConsumoEnergiaComercial.csv","Consumo de Energia Comercial Diario");
        }
        else if(estado.equalsIgnoreCase("energyFactoryHour")){
                return new EnergyComercial(1,"ConsumoEnergiaComercial.csv", "Consumo de Energia Comercial Horario");
        }
        else if(estado.equalsIgnoreCase("energyhouseMonth")){
               return new EnergyResidential(744,"ConsumoEnergiaResidencial.csv","Consumo de Energia Residencial Mensual");
        }
         else if(estado.equalsIgnoreCase("energyhouseWeek")){
               return new EnergyResidential(168,"ConsumoEnergiaResidencial.csv","Consumo de Energia Residencial Semanal");
        }
        else if(estado.equalsIgnoreCase("energyhouseDay")){
               return new EnergyResidential(24,"ConsumoEnergiaResidencial.csv","Consumo de Energia Residencial Diario");
        }
        else if(estado.equalsIgnoreCase("energyhouseHour")){
               return new EnergyResidential(1,"ConsumoEnergiaResidencial.csv","Consumo de Energia Residencial Horario");
        }
        
        else if(estado.equalsIgnoreCase("aguaFactoryMonth")){
                return new WaterComercial(744,"ConsumoAguaComercial.csv","Consumo de Agua Comercial Mensual");
        }
        else if(estado.equalsIgnoreCase("aguaFactoryWeek")){
                return new WaterComercial(168,"ConsumoAguaComercial.csv","Consumo de Agua Comercial Semanal");
        }
        else if(estado.equalsIgnoreCase("aguaFactoryDay")){
                return new WaterComercial(24,"ConsumoAguaComercial.csv","Consumo de Agua Comercial Diario");
        }
        else if(estado.equalsIgnoreCase("aguaFactoryHour")){
                return new WaterComercial(1,"ConsumoAguaComercial.csv","Consumo de Agua Comercial Horario");
        }
        else if(estado.equalsIgnoreCase("aguahouseMonth")){
                return new WaterResidential(744,"ConsumoAguaResidencial.csv","Consumo de Agua Residencial Mensual");
        }
         else if(estado.equalsIgnoreCase("aguahouseWeek")){
                return new WaterResidential(168,"ConsumoAguaResidencial.csv","Consumo de Agua Residencial Semanal");
        }
        else if(estado.equalsIgnoreCase("aguahouseDay")){
                return new WaterResidential(24,"ConsumoAguaResidencial.csv","Consumo de Agua Residencial Diario");
        }
        else if(estado.equalsIgnoreCase("aguahouseHour")){
                return new WaterResidential(1,"ConsumoAguaResidencial.csv","Consumo de Agua Residencial Horario");
        }
        return new VacioEstado(0,"");
    }
    
}
