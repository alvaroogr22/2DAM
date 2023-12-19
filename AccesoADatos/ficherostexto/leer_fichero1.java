package ficherostexto;

import java.io.*;

public class leer_fichero1 {

    public static void main(String[] args) {
    
     


        
      try{  
    //creamos fichero
    	  
        File archivo = new File("c:/prueba/ciudades.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br=new BufferedReader(fr);    

        //leemos el fichero
        String linea=br.readLine();
        //mientras el fichero tiene contenido
        
        
        while((linea=br.readLine()) !=null)
        {
        System.out.println(linea);
        
        }
            br.close();
      fr.close();
      }
      catch(Exception e)
              {
            System.out.println(e.getMessage());  
              }    
             
            }             
    }
    

