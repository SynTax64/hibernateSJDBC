package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			int studentId = 2;
			session.beginTransaction();

			Student student = session.get(Student.class, studentId);
//			session.delete(student);

			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			factory.close();

		}
	}
}
