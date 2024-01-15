package modelo;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {

// Configurar la sesin de Hibernate
		SessionFactory sessionFactory = new Configuration().configure()// llama al fichero hibernate.cfg.xml

// .configure("hibernate.cfg.xml") // Ruta del archivo de configuracin de Hibernate
				.buildSessionFactory(); // Construir la sesin de Hibernate

// Configurar la sesin en el contexto actual
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		try {
// Crear objeto alumno
			Alumnos alumno = new Alumnos("Alberto", "Ruiz", "Rodriguez", Date.valueOf("1975-05-05"), "No", "33333");

// Obtener la sesión actual
			Session session = context.currentSession();

// Iniciar transacción
			session.beginTransaction();

// Guardar objeto en la base de datos
			session.save(alumno);

// Hacer commit de la transacción
			session.getTransaction().commit();

// Imprimir alumno guardado en la base de datos
			System.out.println("Alumno guardado: " + alumno);

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