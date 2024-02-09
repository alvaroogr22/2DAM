package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

public class EliminarRegistros {

	public static void borrarPaciente(int pacienteId) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		try {
			Session session = context.currentSession();

			session.beginTransaction();

			// Borrar paciente con el ID del paciente proporcionado
			String deleteHql = "DELETE FROM Pacientes WHERE id = :pacienteId";
			Query<?> deleteQuery = session.createQuery(deleteHql);
			deleteQuery.setParameter("pacienteId", pacienteId);
			int affectedRows = deleteQuery.executeUpdate();

			if (affectedRows > 0) {
				System.out.println("Paciente con ID " + pacienteId + " eliminado correctamente.");
			} else {
				System.out.println("No se encontró un paciente con el ID " + pacienteId + ".");
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.unbind(sessionFactory);
			sessionFactory.close();
		}
	}

	public static void borrarMedico(int medicoId) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		try {
			Session session = context.currentSession();

			session.beginTransaction();

			// Borrar médico con el ID del médico proporcionado
			String deleteHql = "DELETE FROM Medicos WHERE id = :medicoId";
			Query<?> deleteQuery = session.createQuery(deleteHql);
			deleteQuery.setParameter("medicoId", medicoId);
			int affectedRows = deleteQuery.executeUpdate();

			if (affectedRows > 0) {
				System.out.println("Paciente con ID " + medicoId + " eliminado correctamente.");
			} else {
				System.out.println("No se encontró un paciente con el ID " + medicoId + ".");
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