/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utp.meter.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


 

/**
 *
 * @author Sebastian
 */
public class Ventana {
    
    static String linea = "";
    static String ejex[];
    static String ejey[];
    static ArrayList<Integer> y = new ArrayList();
    static ArrayList<String> x = new ArrayList();
    static int cont=0;
    static File archivo = new File("E:\\Desktop\\UNIVERSIDAD\\2020 -1\\ConsumoEnergiaComercial.csv");
    static FileReader archivoLector;
    public ChartPanel graficarXY(){
        try{
            archivoLector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(archivoLector);
            while(buffer.ready())
            {
                if(!(linea=buffer.readLine()).equals("\000")){ //
                    ejex = linea.split(",");
                    ejey = linea.split(",");
                   
                    y.add(Integer.parseInt(ejey[1]));
                    x.add(ejex[0]);
                    cont++;
                    } 
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Unknown File");

        }
        var dataset = new DefaultCategoryDataset();
        for (int i = 0; i < x.size(); i++) {
            dataset.setValue(y.get(i), "Consume",x.get(i));
        }
        
        JFreeChart barchart = ChartFactory.createBarChart("Consumo Energia Comercial en Horas", "", "Consumo", dataset,PlotOrientation.VERTICAL,false,true,false);
        ChartPanel panel = new ChartPanel(barchart);
        return panel;
    }
   
}
