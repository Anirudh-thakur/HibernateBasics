package demo;

import javax.persistence.*;

@Entity
@Table(name="instructor")
public class Instructor {

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
	
	//Joining to instructor details and adding all cascading type
	@OneToOne(cascade=CascadeType.ALL,targetEntity=InstructorDetails.class)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetails instructorDetails;

	//constructors
	public Instructor(String firstName, String lastName, String email) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
	}
	public Instructor()
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
	public InstructorDetails getInstructorDetails() {
		return instructorDetails;
	}
	public void setInstructorDetails(InstructorDetails instructorDetails) {
		this.instructorDetails = instructorDetails;
	}
	
	//Overriding toString in order to print the object 
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", email=" + email
				+ "]";
	}
	
	
	
}
