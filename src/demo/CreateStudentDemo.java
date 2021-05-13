package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating a new Student object");
			Student theStudent1 = new Student("Joanna", "Temp1", "joanna@gmail.com");
			Student theStudent4 = new Student("Domen", "Temporary2", "domen@gmail.com");
			Student theStudent2 = new Student("Denis", "test123", "denis@gmail.com");
			Student theStudent3 = new Student("Levis", "levis", "levis@gmail.com");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
			session.save(theStudent4);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			factory.close();

		}
	}
}
