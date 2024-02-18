package modelo;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Main {

	public static void main(String[] args) {
		// Configurar la sesión de Hibernate
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		try {
			// Crear objeto fabricante
			Fabricante f2=new Fabricante("Apple");

			// Obtener la sesión actual
			Session session = context.currentSession();
			// Iniciar transacción
			session.beginTransaction();
			// Guardar objeto en la base de datos
			session.save(f2);


			// Hacer commit de la transacción
			session.getTransaction().commit();


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
