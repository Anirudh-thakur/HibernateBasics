package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Creating session factory and session object
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
		// starting transaction 
			session.beginTransaction();
			
		//Getting the instructor object to be deleted by using id 
		int id = 1;
		Instructor tempInstructor = session.get(Instructor.class, id);
		System.out.println("Found Instructor:"+tempInstructor);
		
		//deleting current instructor
		if(tempInstructor != null)
		{	
		session.delete(tempInstructor);
		System.out.println("Object deleted");
		}
		
		//commiting transaction 
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
