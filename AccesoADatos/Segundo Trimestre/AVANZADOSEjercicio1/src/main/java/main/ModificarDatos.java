package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ModificarDatos {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		try {
			Session session = context.currentSession();

			session.beginTransaction();

			String updateHql = "UPDATE Alumno SET nombre = 'Monkey D. Luffy' WHERE id = 12";
			Query<?> updateQuery = session.createQuery(updateHql);
			updateQuery.executeUpdate();

			String selectHql = "FROM Alumno WHERE id = 12";
			Query selectQuery = session.createQuery(selectHql, Alumno.class);
			List <Alumno>alumnos = selectQuery.list();

// Imprimir resultados
			System.out.println("Registros en la tabla fabricante después de la actualización:");
			for (Alumno a : alumnos) {
				System.out.println(a.toString());
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.unbind(sessionFactory);
			sessionFactory.close();
		}
	}
}