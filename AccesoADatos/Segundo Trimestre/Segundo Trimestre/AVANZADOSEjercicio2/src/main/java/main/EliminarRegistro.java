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

			String selectHqlBeforeDelete = "FROM Productos WHERE id = 5";
			Query selectQueryBeforeDelete = session.createQuery(selectHqlBeforeDelete, Productos.class);
			List<Productos> productosBeforeDelete = selectQueryBeforeDelete.list();

			System.out.println("Registros en la tabla fabricante antes de la eliminación:");
			for (Productos p : productosBeforeDelete) {
				System.out.println(p.toString());
			}

			String deleteHql = "DELETE FROM Productos WHERE id = 5";
			Query<?> deleteQuery = session.createQuery(deleteHql);
			deleteQuery.executeUpdate();

			String selectHqlAfterDelete = "FROM Productos";
			Query selectQueryAfterDelete = session.createQuery(selectHqlAfterDelete, Productos.class);
			List<Productos> productosAfterDelete = selectQueryAfterDelete.list();

			System.out.println("Registros en la tabla fabricante después de la eliminación:");
			for (Productos p : productosAfterDelete) {
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
