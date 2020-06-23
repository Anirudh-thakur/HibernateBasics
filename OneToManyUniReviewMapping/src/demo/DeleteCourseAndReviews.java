package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviews {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Course.class).addAnnotatedClass(InstructorMany.class).addAnnotatedClass(InstructorDetailsMany.class).addAnnotatedClass(Review.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			//Begin Transaction 
			session.beginTransaction();
			
			//Getting course
			int id = 1;
			Course tempCourse = session.get(Course.class, id);
			session.remove(tempCourse);
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
