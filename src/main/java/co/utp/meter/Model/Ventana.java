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
    
    public String linea = "";
    public String ejex[];
    public String ejey[];
    public ArrayList<Float> y = new ArrayList();
    public ArrayList<String> x = new ArrayList();
    public String direccion;
    public File archivo;
    public FileReader archivoLector;

    public ChartPanel graficarXY(String link, int tempo,String name ) {
        
        try {
            int cont=0;
            if(tempo==744){
                cont=360;
            }
            
            direccion = link;
            archivo =new File(direccion);
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
                    ejeyacum = ejeyacum;
                    cont = 0;
                    y.add(ejeyacum);
                    if(tempo>1){
                        ejex[0] = ejex[0].substring(0,10);
                    }
                    if(tempo==744){
                        ejex[0] = ejex[0].substring(3,5);
                    }
                    x.add(ejex[0]);
                    ejeyacum = 0;
                }

            }
            

        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Unknown File");

        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < x.size(); i++) {
            dataset.setValue(y.get(i), "Consume",x.get(i));
        }
        
        JFreeChart barchart=barchart(name,dataset);
        ChartPanel panel = new ChartPanel(barchart);
        return panel;
    }
    public JFreeChart barchart(String name,DefaultCategoryDataset dataset){
        JFreeChart barchart;
        barchart = ChartFactory.createBarChart(name, "", "Consumo", dataset,PlotOrientation.VERTICAL,false,true,false);
        return barchart;
    }
   
}
