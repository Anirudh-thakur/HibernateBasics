package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchCourseFromInstructor {

	public static void main(String[] args) {
		//Session factory and session variable 
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Course.class).addAnnotatedClass(InstructorMany.class).addAnnotatedClass(InstructorDetailsMany.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			//Begin Transaction 
			session.beginTransaction();
			
			int id = 1;
			InstructorMany tempInstructor = session.get(InstructorMany.class, id);
			//Instructor 
			System.out.println(tempInstructor);
			//Instructor Details
			System.out.println(tempInstructor.getInstructorDetailsMany());
			//Courses
			System.out.println(tempInstructor.getCourses());
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			session.close();
			factory.close();
		}

	}

}
