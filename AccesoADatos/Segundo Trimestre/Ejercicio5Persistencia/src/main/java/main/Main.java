package main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {
		// Configurar la sesión de Hibernate
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		try {
			// Crear objeto fabricante
			Productos p1=new Productos("Asterix y Obelix en Hispania", "Un emocionante libro para los amantes de la lectura", 29.99, "Editorial ABC", 50);
			Productos p2=new Productos("Dune", "El mejor libro de Ciencia Ficción", 15.50, "Editorial Minotauro", 100);
			Productos p3=new Productos("La Iliada", "Un clásico para regalar", 50.00, "Editorial Homero", 30);
			Productos p4=new Productos("Risk El Señor de los Anillos", "Juego de estrategia para divertirse en familia", 39.99, "Mattel", 20);
			Productos p5=new Productos("Portatil Omnio", "Portatil con 1TB de capacidad", 1200.99, "HP", 20);

			// Obtener la sesión actual
			Session session = context.currentSession();
			// Iniciar transacción
			session.beginTransaction();
			// Guardar objeto en la base de datos
			session.save(p1);
			session.save(p2);
			session.save(p3);
			session.save(p4);
			session.save(p5);

			// Hacer commit de la transacción
			session.getTransaction().commit();

			// Imprimir fabricante guardado en la base de datos
			System.out.println("Producto: " + p1+p2+p3+p4+p5);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Desligar la sesión del contexto
			ThreadLocalSessionContext.unbind(sessionFactory);

			// Cerrar la sesión del Hibernate
			sessionFactory.close();
		}
	}
}
