package demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="instructor")
public class InstructorMany {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String FirstName;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="email")
	private String email;
	
	//Joining to Courses and adding all cascading type
	@OneToMany(mappedBy="instructor", cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.REMOVE,CascadeType.REFRESH},targetEntity=Course.class)
	private List<Course> courses;
	
	//Joining to instructor details and adding all cascading type
	@OneToOne(targetEntity=InstructorDetailsMany.class,cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetailsMany InstructorDetailsMany;

	//constructors
	public InstructorMany(String firstName, String lastName, String email) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
	}
	public InstructorMany()
	{}
	
	//Getter and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public InstructorDetailsMany getInstructorDetailsMany() {
		return InstructorDetailsMany;
	}
	public void setInstructorDetailsMany(InstructorDetailsMany InstructorDetailsMany) {
		this.InstructorDetailsMany = InstructorDetailsMany;
	}
	
	
	//Overriding toString in order to print the object 
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", email=" + email
				+ "]";
	}
	
	//Method to establish a bidirectional Relationship between Constructor and Course 
	public void AddCourse(Course tempCourse)
	{
		if(courses == null)
		{
			courses = new ArrayList<Course>();
		}
		courses.add(tempCourse);
		tempCourse.setInstructor(this);
	}
	
}