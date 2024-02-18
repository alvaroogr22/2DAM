package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class VerDatosFabricante {

	public static void main(String[] args) {
		// Configurar la sesión de Hibernate
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		try {

			// Obtener la sesión actual
			Session session = context.currentSession();
			// Iniciar transacción
			session.beginTransaction();
			
			// Crear consulta HQL para seleccionar todos los registros de la tabla fabricante
            String hql = "FROM Fabricante";
            Query<Fabricante> query = session.createQuery(hql, Fabricante.class);


            // Ejecutar consulta y obtener resultados
            List<Fabricante> fabricantes = query.list();


            // Imprimir resultados
            System.out.println("Registros en la tabla fabricante:");
            for (Fabricante f : fabricantes) {
                System.out.println(f.toString());
            }

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
