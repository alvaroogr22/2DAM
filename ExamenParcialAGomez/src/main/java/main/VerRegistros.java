package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerRegistros {
    public static void mostrarTodosLosPacientes() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();

            session.beginTransaction();

            // Obtener todos los pacientes
            String selectHql = "FROM Pacientes";
            Query<Pacientes> selectQuery = session.createQuery(selectHql, Pacientes.class);
            List<Pacientes> pacientes = selectQuery.list();

            // Imprimir la lista de pacientes
            System.out.println("------ Lista de Pacientes ------");
            for (Pacientes paciente : pacientes) {
                System.out.println(paciente.toString());
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.unbind(sessionFactory);
            sessionFactory.close();
        }
    }

    public static void mostrarTodosLosMedicos() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Session session = context.currentSession();

            session.beginTransaction();

            // Obtener todos los medicos
            String selectHql = "FROM Medicos";
            Query<Medicos> selectQuery = session.createQuery(selectHql, Medicos.class);
            List<Medicos> medicos = selectQuery.list();

            // Imprimir la lista de medicos
            System.out.println("------ Lista de Medicos ------");
            for (Medicos medico : medicos) {
                System.out.println(medico.toString());
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
