package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMappedStudentCourse {

	public static void main(String[] args) {
	  //Creating session and factory methods 
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Course.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			//Creating Student and course objects
			Student s1 = new Student("Anirudh","Thakur","anirudh.thakur");
			Student s2 = new Student("anchit","Thakur","anch.thakur");
			Student s3 = new Student("Chacha","Thakur","chacha.thakur");
			
			Course c1 = new Course("Spring");
			Course c2 = new Course("Hibernate");
			Course c3 = new Course("Guitar");
			
			//mapping courses to students
			c1.addStudent(s1);
			c1.addStudent(s2);
			c2.addStudent(s3);
			c3.addStudent(s2);
			
			//Mapping students to courses
//			s1.addCourse(c1);
//			s2.addCourse(c1);
//			s2.addCourse(c3);
//			s3.addCourse(c2);
			
			//Begin transaction 
			session.beginTransaction();
			
			//saving objects in database
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
			//Commiting transactions
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}

	}

}
