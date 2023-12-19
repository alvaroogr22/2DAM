package ficherostexto;

import java.io.*;

public class ficheros3 {

    public static void main(String[] args) {

//creamos la instancia del objeto file

File miarchivo2=new File("c/archivos2/archivos2.txt");

System.out.println("El nombre del fichero es: " + miarchivo2.getName());

System.out.println("Ruta: " +miarchivo2.getPath());


//Comprobamos si es de lectura o escritura

if(miarchivo2.canWrite())
{
System.out.println("El fichero: " +miarchivo2.getName() + " se puede editar");
}
else
{
System.out.println("El fichero: " + miarchivo2.getName() + " no se puede editar");
}

if(miarchivo2.canRead())
{
System.out.println("El fichero: " + miarchivo2.getName() + " se puede leer");
}
else
{
System.out.println("El fichero: " + miarchivo2.getName() + " no se puede leer");
} 



    }
    
}
