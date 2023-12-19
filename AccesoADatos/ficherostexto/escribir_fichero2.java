package ficherostexto;

import java.io.*;
import java.util.Scanner;

public class escribir_fichero2 {

    public static void main(String[] args) {

//sin crear el fichero, se guardan los datos, en un fichero dentro de la carpeta
//ficheros2. Pedir por pantalla el número de veces, que queremos imprimir tu 
//nombre completo, y esto se guarda en el fichero 

//comenzamos a crear los objetos para el fichero y para leer
FileWriter mifichero=null;
PrintWriter escribir=null;
try
{
//agregar el fichero al metodo filewriter
    mifichero=new FileWriter("C:/ficheros2/alumnos.txt");
    escribir=new PrintWriter(mifichero);
    
    //escribir, primero pedimos por pantalla el nombre
    System.out.println("Introduce tu nombre completo: ");
    Scanner datosp=new Scanner(System.in);
    
    String nombrec=datosp.nextLine();
    
    //Pedimos por pantalla el número de veces que queremos imprimir el nombre
    System.out.println("Introduce el número de veces a imprimir: ");
    int veces=datosp.nextInt();
    
    //utilizamos un bucle para imprimir los datos
        for(int i=0;i<veces;i++)
        {
        escribir.println(nombrec);
        }
    
}
catch(Exception e)
        {
        //mostramos el nombre de la excepción si hay un error con fichero    
        e.printStackTrace();
        }

finally 
{
     //cerrar el fichero
    try
    {
        if(mifichero!=null)
            {
            mifichero.close();
            }
    
    }
    catch(Exception e2)
        {
        //mostrar la excepción    
        e2.printStackTrace();
        }

}





    }
    
}
