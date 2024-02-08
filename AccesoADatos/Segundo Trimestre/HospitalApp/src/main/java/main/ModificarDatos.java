package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

public class ModificarDatos {
	public static void modificarDatosPaciente(int pacienteId, String nuevoNombre, String nuevosApellidos) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		try {
			Session session = context.currentSession();

			session.beginTransaction();

			// Modificar datos del paciente con el ID proporcionado
			String updateHql = "UPDATE Pacientes SET nombre = :nuevoNombre, apellidos = :nuevosApellidos WHERE id = :id";
			Query<?> updateQuery = session.createQuery(updateHql);
			updateQuery.setParameter("id", pacienteId);
			updateQuery.setParameter("nuevoNombre", nuevoNombre);
			updateQuery.setParameter("nuevosApellidos", nuevosApellidos);
			int affectedRows = updateQuery.executeUpdate();

			if (affectedRows > 0) {
				System.out.println("Datos del paciente con ID " + pacienteId + " modificados correctamente.");
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
	public static void modificarDatosMedico(int pacienteId, String nuevoNombre, String nuevosApellidos) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		try {
			Session session = context.currentSession();

			session.beginTransaction();

			// Modificar datos del paciente con el ID proporcionado
			String updateHql = "UPDATE Medicos SET nombre = :nuevoNombre, apellidos = :nuevosApellidos WHERE id = :id";
			Query<?> updateQuery = session.createQuery(updateHql);
			updateQuery.setParameter("id", pacienteId);
			updateQuery.setParameter("nuevoNombre", nuevoNombre);
			updateQuery.setParameter("nuevosApellidos", nuevosApellidos);
			int affectedRows = updateQuery.executeUpdate();

			if (affectedRows > 0) {
				System.out.println("Datos del medico con ID " + pacienteId + " modificados correctamente.");
			} else {
				System.out.println("No se encontró un medico con el ID " + pacienteId + ".");
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.unbind(sessionFactory);
			sessionFactory.close();
		}
	}
	 public static void modificarDatosCita(int citaId, String nuevaFecha, String nuevaHora) {
	        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
	        context.bind(sessionFactory.openSession());

	        try {
	            Session session = context.currentSession();

	            session.beginTransaction();

	            // Modificar datos de la cita con el ID proporcionado
	            String updateHql = "UPDATE Citas SET fecha = :nuevaFecha, hora = :nuevaHora WHERE id = :citaId";
	            Query<?> updateQuery = session.createQuery(updateHql);
	            updateQuery.setParameter("citaId", citaId);
	            updateQuery.setParameter("nuevaFecha", nuevaFecha);
	            updateQuery.setParameter("nuevaHora", nuevaHora);
	            int affectedRows = updateQuery.executeUpdate();

	            if (affectedRows > 0) {
	                System.out.println("Datos de la cita con ID " + citaId + " modificados correctamente.");
	            } else {
	                System.out.println("No se encontró una cita con el ID " + citaId + ".");
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
