package Ejercicio1;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import javax.xml.transform.OutputKeys;
import org.exist.xmldb.EXistResource;


public class QueryXml3 {


    // URI para conectarse a la base de datos XML existente en localhost en el puerto 8080
    private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/";
    
	// Nombre de la colección donde se encuentran los datos XML
	private static String COLLECTION = "libreria";

	// Nombre del recurso XML dentro de la colección
	private static String RESOURCE = "libros.xml";


    public static void main(String args[]) throws Exception {


        final String driver = "org.exist.xmldb.DatabaseImpl";


        // Inicializa el controlador de la base de datos
        Class cl = Class.forName(driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);


        Collection col = null;
        XMLResource res = null;
        try {
            // Obtiene la colección
            col = DatabaseManager.getCollection(URI + COLLECTION, "admin", "admin");
            
            // Configura la propiedad de salida para indentación
            col.setProperty(OutputKeys.INDENT, "no");
            
            // Obtiene el recurso XML de la colección
            res = (XMLResource)col.getResource(RESOURCE);


            // Verifica si el recurso existe
            if(res == null) {
                System.out.println("Base de datos no encontrada!");
            } else {
                // Ejecuta la consulta XPath
                XPathQueryService xpathService = (XPathQueryService)col.getService("XPathQueryService", "1.0");
                xpathService.setProperty("indent", "yes");
                String xquery = "/libreria/libro[anio > 1945]"; // Consulta para encontrar productos con precio menor a 50
                ResourceSet result = xpathService.query(xquery);
                
                // Imprime los resultados de la consulta
                ResourceIterator i = result.getIterator();
                while(i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println(r.getContent());
                }
            }
        } finally {
            // Limpieza de recursos
            
            if(res != null) {
                try { 
                    // Libera los recursos del recurso exist
                    ((EXistResource)res).freeResources(); 
                } catch(XMLDBException xe) {
                    xe.printStackTrace();
                }
            }


            if(col != null) {
                try { 
                    // Cierra la colección
                    col.close(); 
                } catch(XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
    }
}
