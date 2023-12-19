package ficherostexto;

import java.io.*;

public class escribir_fichero {

    public static void main(String[] args) {

//comenzamos creando el fichero
FileWriter mifichero=null;
PrintWriter escribir=null;

//agregamos el código de la excepción por si hay algún error
try
{
    mifichero=new FileWriter("C:/ficheros2/ficheros2.txt");
    escribir=new PrintWriter(mifichero);

    //escribimos con un bucle varias líneas, son 10
    for(int i=0;i<10;i++)
    {
    escribir.println("Línea: " + i);
    }

}
catch(Exception e)
{
//mostrar el error    
e.printStackTrace();
}
finally
{
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