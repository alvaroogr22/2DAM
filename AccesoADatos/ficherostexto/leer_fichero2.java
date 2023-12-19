package ficherostexto;

import java.io.*;

public class leer_fichero2 {

/*
    Imprimir solo la primera línea del código
    */    
    
    
    public static void main(String[] args) {
        
        
 File archivo=null;
 FileReader fr=null;
 BufferedReader br=null;
 
 try
 {
     archivo=new File("c:/leer/fichero2.txt");
     fr=new FileReader(archivo);
     br=new BufferedReader(fr);
        String lineas;
     lineas=br.readLine();
     int cont=1;
     
     while(lineas!=null)
        {
        cont ++;
        if(cont>3)
            {
        System.out.println(lineas);
        break;
     
 
         }
        }
  }
 catch(Exception e)
 {
        
         System.out.println(e.getMessage());
         
        
        
     
 }finally{
 
            try
            {
                if(fr!=null)
                {
                fr.close();    
                } 
            }catch(Exception e2)
                {
                System.out.println(e2.getMessage());
                }
 
 }
        


    }
    
}
