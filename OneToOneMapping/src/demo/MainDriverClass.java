package demo;


import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDriverClass {

	public static void main(String[] arg)
	{
		//Creating instructor objects
		
		Instructor instructor = new Instructor("Anirudh","Thakur","anirudh.thakur94@gmail.com");
		InstructorDetails instructorDet = new InstructorDetails("AA Memes","Coding");
		
		//Associating 	
		instructor.setInstructorDetails(instructorDet);
		
		//Creating session and session factory objects to connect to hibernate 
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			//Starting transaction 
			session.beginTransaction();
			
			//Saving object in session(As cascading is applied so saving instructor will automatically save instructor details)
			session.save(instructor);
			
			//commiting the current transaction 
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
}