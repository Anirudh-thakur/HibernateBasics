package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndStudent {

	public static void main(String[] args) {
		
		//Creating session and factory methods 
				SessionFactory factory = new Configuration().configure().addAnnotatedClass(Course.class).addAnnotatedClass(Student.class).buildSessionFactory();
				Session session = factory.getCurrentSession();
				
				try
				{
					//Begin transaction
					session.beginTransaction();
					  int id = 4;
					    Student tempStudent = session.get(Student.class, id);
					    Course tempCourse = session.get(Course.class, id);
					    
					    System.out.println("Current Student:"+tempStudent);
					    System.out.println("Mapped Courses:"+tempStudent.getCourses());
					    
					    System.out.println("Current Course:"+tempCourse);
					    System.out.println("Mapped Student:"+tempCourse.getStudents());
					    
					
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
