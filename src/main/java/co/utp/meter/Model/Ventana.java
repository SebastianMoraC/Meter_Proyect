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
    static ArrayList<Float> y = new ArrayList();
    static ArrayList<String> x = new ArrayList();
    static String direccion;
    static File archivo;
    static FileReader archivoLector;

    public ChartPanel graficarXY(String link, int tempo,String name ) {
        
        try {
            direccion = link;
            archivo =new File(direccion);
            int cont = 0;
            float ejeyacum = 0;
            archivoLector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(archivoLector);
            while (buffer.ready()) {
                
                if (!(linea = buffer.readLine()).equals("\000") && (cont+1)<=tempo) {

                    ejex = linea.split(",");
                    ejey = linea.split(",");
                    cont++;
                    ejeyacum = Float.parseFloat(ejey[1]) + ejeyacum;
                } else  {
                    System.out.println(cont);
                    ejeyacum = ejeyacum / tempo;
                    cont = 0;
                    y.add(ejeyacum);
                    ejex[0] = ejex[0].substring(0,10);
                    x.add(ejex[0]);
                    ejeyacum = 0;
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
        
        JFreeChart barchart = ChartFactory.createBarChart(name, "", "Consumo", dataset,PlotOrientation.VERTICAL,false,true,false);
        ChartPanel panel = new ChartPanel(barchart);
        return panel;
    }
   
}
