package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating 3 new Student objects");
			Student theStudent1 = new Student("Joanne", "Test2", "joanne@test.com");
			Student theStudent2 = new Student("Nika", "Test3", "nika@test.com");
			Student theStudent3 = new Student("Eva", "Test4", "eva@test.com");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students...");
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);

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
