package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReviews {

	public static void main(String[] args) {
		// Creating factory and session objects
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Review.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorMany.class).addAnnotatedClass(InstructorDetailsMany.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			//Getting course
			int id = 1;
			Course tempCourse = session.get(Course.class, id);
			//Creating reviews
			Review reviewOne = new Review("Best course ever");
			Review reviewTwo = new Review("Worst course ever");
			//Mappring courses with reviews
			tempCourse.AddReview(reviewTwo);
			tempCourse.AddReview(reviewOne);
			//Mapping reviews with courses
			reviewTwo.setCourse(tempCourse);
			reviewOne.setCourse(tempCourse);
			//Saving reviews
			session.save(reviewOne);
			session.save(reviewTwo);
			//saving courses
			session.save(tempCourse);
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
