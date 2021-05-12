package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			// query Students
			List<Student> listOfStudents = session.createQuery("from Student").getResultList();

			// display the students

			printStudents(listOfStudents);
			System.out.println("**********");
			// query students: firstName = 'David'
			listOfStudents = session.createQuery("from Student s where s.firstName='David'").getResultList();
			printStudents(listOfStudents);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			factory.close();

		}
	}

	private static void printStudents(List<Student> listOfStudents) {
		for (Student student : listOfStudents) {
			System.out.println(student);
		}
	}
}
