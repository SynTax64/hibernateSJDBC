package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating a new Student object");
			Student theStudent = new Student("David", "Test", "david@test.com");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(theStudent);

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
