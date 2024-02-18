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

public class EliminarRegistro {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		try {
			Session session = context.currentSession();

			session.beginTransaction();

			String selectHqlBeforeDelete = "FROM Alumno WHERE id = 12";
			Query selectQueryBeforeDelete = session.createQuery(selectHqlBeforeDelete, Alumno.class);
			List<Alumno> alumnosBeforeDelete = selectQueryBeforeDelete.list();

			System.out.println("Registros en la tabla fabricante antes de la eliminación:");
			for (Alumno a : alumnosBeforeDelete) {
				System.out.println(a.toString());
			}

			String deleteHql = "DELETE FROM Alumno WHERE id = 12";
			Query<?> deleteQuery = session.createQuery(deleteHql);
			deleteQuery.executeUpdate();

			String selectHqlAfterDelete = "FROM Alumno";
			Query selectQueryAfterDelete = session.createQuery(selectHqlAfterDelete, Alumno.class);
			List<Alumno> alumnosAfterDelete = selectQueryAfterDelete.list();

			System.out.println("Registros en la tabla fabricante después de la eliminación:");
			for (Alumno a : alumnosAfterDelete) {
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
