package biDirectionalDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.Instructor;
import demo.InstructorDetails;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create factory and Session object 
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(InstructorBi.class).addAnnotatedClass(InstructorDetailsBi.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
		    // begin transaction 
			session.beginTransaction();
			
			//Fetch instructor details by using id 
			int id = 2;
			InstructorDetailsBi tempInstructor = session.get(InstructorDetailsBi.class, id);
			if(tempInstructor != null)
			{
				System.out.println("Instructor Details:"+tempInstructor);
				// Get the associated instructor
				System.out.println("Associated Instructor Details:"+tempInstructor.getInstructorBi());
				session.remove(tempInstructor);
				System.out.println("Instructor Deleted");
			}
			else 
			{
				System.out.println("Instructor not found");
			}
			//Commit transaction 
			session.getTransaction().commit();
		}
		catch(Exception e )
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