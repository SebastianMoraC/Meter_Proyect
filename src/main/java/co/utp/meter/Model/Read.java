package co.utp.meter.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Read {
    
    public void readFile() throws FileNotFoundException, IOException{ //Declarated Exceptions
        File archivo = new File("ejemplo_progra.txt"); //Read file, you have to write here the direction where you have the txt
        FileReader fr = new FileReader(archivo);
        BufferedReader bf = new BufferedReader(fr);
        String linea;
        while((linea = bf.readLine()) != null){ //Read line to line
            System.out.println(linea); 
        }
        
        
    }
    public void readFile2(){
        
        try { //Capture exception
            readFile();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Unknown File");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Exception of verification");
           
        }
        System.out.println("Finish"); //Finish when finish to read
    }
  
    
}
    

