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

			String updateHql = "UPDATE Productos SET nombre = 'Fruta del Diablo' WHERE id = 5";
			Query<?> updateQuery = session.createQuery(updateHql);
			updateQuery.executeUpdate();

			String selectHql = "FROM Productos WHERE id = 5";
			Query selectQuery = session.createQuery(selectHql, Productos.class);
			List <Productos>productos = selectQuery.list();

// Imprimir resultados
			System.out.println("Registros en la tabla fabricante después de la actualización:");
			for (Productos p : productos) {
				System.out.println(p.toString());
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