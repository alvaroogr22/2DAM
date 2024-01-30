package modelo;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

    public static void main(String[] args) {

        // Configurar la sesión de Hibernate
        SessionFactory sessionFactory = new Configuration()
                .configure()  // Llama al archivo de configuración hibernate.cfg.xml
                .buildSessionFactory(); // Construir la sesión de Hibernate

        // Configurar la sesión en el contexto actual
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
        	//FABRICANTE****************************************************
            // Crear objeto fabricante
           	Fabricante fabricante = new Fabricante("pc gaming3");

        	// Obtener la sesión actual
        	Session session = context.currentSession();

        	// Iniciar transacción
        	session.beginTransaction();

        	// Guardar objeto fabricante en la base de datos
        	session.save(fabricante);      	     	

        	// Hacer commit de la transacción
        	session.getTransaction().commit();
        	
        	//PRODUCTOS**********************************
        	// Crear objeto producto
        
        	Productos producto = new Productos("PORTATIL gaming3", 3000.00, fabricante);

        	// Obtener la sesión actual
        	Session session1 = context.currentSession();

        	// Iniciar transacción
        	session1.beginTransaction();

        	// Guardar objeto producto en la base de datos
        	session1.save(producto);

        	// Hacer commit de la transacción
        	session1.getTransaction().commit();
        	
        	//COMPRAS
        	
        	 // Crear objeto compras
           	Compra compra = new Compra(Date.valueOf("2024-01-03"),1,producto);

        	// Obtener la sesión actual
        	Session session2 = context.currentSession();

        	// Iniciar transacción
        	session2.beginTransaction();

        	// Guardar objeto fabricante en la base de datos
        	session2.save(compra);      	     	

        	// Hacer commit de la transacción
        	session2.getTransaction().commit();
        	System.out.println(compra.toString());
        	
        	System.out.println(producto.toString());
        	System.out.println(fabricante.toString());
        	

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Desligar la sesión del contexto
            ThreadLocalSessionContext.unbind(sessionFactory);
            // Cerrar la sesión de Hibernate
            sessionFactory.close();
        }
    }
}