package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import java.sql.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		byte resultado;
		byte resultado2;
		byte resultado3;
		byte resultado4;

		// Creación del menú
		do {
			System.out.println("------ Menú ------");
			System.out.println("1. Gestionar pacientes");
			System.out.println("2. Gestionar médicos");
			System.out.println("3. Gestionar citas");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");

			resultado = Byte.parseByte(sc.nextLine());

			switch (resultado) {
			case 1:
				do {
					System.out.println("------ Menú Pacientes ------");
					System.out.println("1. Insertar paciente");
					System.out.println("2. Actualizar paciente");
					System.out.println("3. Mostrar lista de pacientes");
					System.out.println("4. Eliminar paciente");
					System.out.println("5. Volver al menú principal");
					System.out.print("Seleccione una opción: ");

					resultado2 = Byte.parseByte(sc.nextLine());

					switch (resultado2) {
					case 1:

						// Configurar la sesión de Hibernate

						System.out.println("Dime el nombre del paciente");
						String nombre = sc.nextLine();
						System.out.println("Dime el apellido del paciente");
						String apellido = sc.nextLine();
						System.out.println("Dime la ciudad del paciente");
						String ciudad = sc.nextLine();
						System.out.println("Dime la dirección del paciente");
						String direccion = sc.nextLine();
						System.out.println("Dime el telefono del paciente");
						String telefono = sc.nextLine();
						System.out.println("Dime la edad del paciente");
						byte edad = Byte.parseByte(sc.nextLine());
						System.out.println("Dime el historial del paciente");
						String historial = sc.nextLine();

						SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

						ThreadLocalSessionContext context = new ThreadLocalSessionContext(
								(SessionFactoryImplementor) sessionFactory);
						context.bind(sessionFactory.openSession());

						Pacientes p1 = new Pacientes(nombre, apellido, ciudad, direccion, telefono, edad, historial);
						// Obtener la sesión actual
						Session session = context.currentSession();
						// Iniciar transacción
						session.beginTransaction();
						// Guardar objeto en la base de datos
						session.save(p1);

						// Hacer commit de la transacción
						session.getTransaction().commit();

						// Imprimir fabricante guardado en la base de datos
						System.out.println("Paciente: " + p1);

						// Desligar la sesión del contexto
						ThreadLocalSessionContext.unbind(sessionFactory);

						// Cerrar la sesión del Hibernate
						sessionFactory.close();

						break;
					case 2:
						System.out.println("Dime el id del paciente");
						byte idPaciente = Byte.parseByte(sc.nextLine());
						System.out.println("Dime el nuevo nombre del paciente");
						String nuevoNombre = sc.nextLine();
						System.out.println("Dime el nuevo apellido del paciente");
						String nuevoApellido = sc.nextLine();
						ModificarDatos.modificarDatosPaciente(idPaciente, nuevoNombre, nuevoApellido);
						break;
					case 3:
						MostrarRegistros.mostrarTodosLosPacientes();
						break;
					case 4:
						System.out.println("Dime el id del paciente a borrar");
						byte idPaciente2 = Byte.parseByte(sc.nextLine());
						BorrarRegistros.borrarPaciente(idPaciente2);
						break;
					case 5:

						break;
					}
				} while (resultado2 != 5);

			case 2:
				do {
					System.out.println("------ Menú Médicos ------");
					System.out.println("1. Insertar médico");
					System.out.println("2. Actualizar médico");
					System.out.println("3. Mostrar lista de médicos");
					System.out.println("4. Eliminar médico");
					System.out.println("5. Volver al menú principal");
					System.out.print("Seleccione una opción: ");

					resultado3 = Byte.parseByte(sc.nextLine());

					switch (resultado3) {
					case 1:

						// Configurar la sesión de Hibernate

						System.out.println("Dime el nombre del médico");
						String nombre = sc.nextLine();
						System.out.println("Dime el apellido del médico");
						String apellido = sc.nextLine();
						System.out.println("Dime la especialidad del médico");
						String especialidad = sc.nextLine();
						

						SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

						ThreadLocalSessionContext context = new ThreadLocalSessionContext(
								(SessionFactoryImplementor) sessionFactory);
						context.bind(sessionFactory.openSession());

						Medicos m1=new Medicos(nombre, apellido, especialidad);
						// Obtener la sesión actual
						Session session = context.currentSession();
						// Iniciar transacción
						session.beginTransaction();
						// Guardar objeto en la base de datos
						session.save(m1);

						// Hacer commit de la transacción
						session.getTransaction().commit();

						// Imprimir fabricante guardado en la base de datos
						System.out.println("Médico: " + m1);

						// Desligar la sesión del contexto
						ThreadLocalSessionContext.unbind(sessionFactory);

						// Cerrar la sesión del Hibernate
						sessionFactory.close();

						break;
					case 2:
						System.out.println("Dime el id del médico");
						byte idPaciente = Byte.parseByte(sc.nextLine());
						System.out.println("Dime el nuevo nombre del médico");
						String nuevoNombre = sc.nextLine();
						System.out.println("Dime el nuevo apellido del médico");
						String nuevoApellido = sc.nextLine();
						ModificarDatos.modificarDatosMedico(idPaciente, nuevoNombre, nuevoApellido);
						break;
					case 3:
						MostrarRegistros.mostrarTodosLosMedicos();
						break;
					case 4:
						System.out.println("Dime el id del médico a borrar");
						byte idPaciente2 = Byte.parseByte(sc.nextLine());
						BorrarRegistros.borrarMedico(idPaciente2);
						break;
					case 5:

						break;
					}
				} while (resultado3 != 5);

				break;
			case 3:
				do {
					System.out.println("------ Menú Citas ------");
					System.out.println("1. Insertar cita");
					System.out.println("2. Actualizar cita");
					System.out.println("3. Volver al menú principal");
					System.out.print("Seleccione una opción: ");

					resultado4 = Byte.parseByte(sc.nextLine());

					switch (resultado4) {
					case 1:

						// Configurar la sesión de Hibernate

						System.out.println("Dime el id del paciente");
						int idPaciente=Integer.parseInt(sc.nextLine());
						System.out.println("Dime el id del médico");
						int idMedico=Integer.parseInt(sc.nextLine());
						System.out.println("Dime la fecha de la cita");
						String fecha = sc.nextLine();
						System.out.println("Dime la hora de la cita");
						String hora = sc.nextLine();
						

						SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

						ThreadLocalSessionContext context = new ThreadLocalSessionContext(
								(SessionFactoryImplementor) sessionFactory);
						context.bind(sessionFactory.openSession());

						Citas c1=new Citas(idPaciente, idMedico, fecha, hora);
						// Obtener la sesión actual
						Session session = context.currentSession();
						// Iniciar transacción
						session.beginTransaction();
						// Guardar objeto en la base de datos
						session.save(c1);

						// Hacer commit de la transacción
						session.getTransaction().commit();

						// Imprimir fabricante guardado en la base de datos
						System.out.println("Cita: " + c1);

						// Desligar la sesión del contexto
						ThreadLocalSessionContext.unbind(sessionFactory);

						// Cerrar la sesión del Hibernate
						sessionFactory.close();

						break;
					case 2:
						System.out.println("Dime el id de la cita");
						int idCita = Integer.parseInt(sc.nextLine());
						System.out.println("Dime la nueva fecha de la cita");
						String nuevaFecha = sc.nextLine();
						System.out.println("Dime la nueva hora de la cita");
						String nuevaHora = sc.nextLine();
						ModificarDatos.modificarDatosCita(idCita, nuevaFecha, nuevaHora);
						break;
					case 3:

						break;

					}
				} while (resultado4 != 3);
				break;
			case 4:
				System.out.println("Has salido del programa");
				sc.close();
				break;
			}
		} while (resultado != 4);

	}

}