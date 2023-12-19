package ficherostexto;
import java.io.*;
import java.util.Scanner;


public class escribir_fichero3 {

    public static void main(String[] args) {

//Creamos un programa donde se pide por teclado un texto en mayúsculas, 
//y se escribe el texto en minúsculas en el fichero.
//El fichero no está creado y se llama: alumnos2.csv

//comenzamos creando el fichero
FileWriter mifichero=null;
PrintWriter escribir=null;

try
{
mifichero=new FileWriter("c:/ficheros2/alumnos2.txt");
escribir=new PrintWriter(mifichero);

//pedimos por pantalla
System.out.println("Introduce un texto en mayúsculas");
Scanner datosp=new Scanner(System.in);
String cadena=datosp.nextLine();

String textom=cadena.toUpperCase();

escribir.println(textom);

}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
try{
    if(mifichero!=null)
    {
    mifichero.close();
    }
    

}
catch(Exception e2)
{
    //Mostrar la excepción
    e2.printStackTrace();
}

}







    }
    
}
