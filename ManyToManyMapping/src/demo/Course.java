package demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {
  //Define course parameters 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.DETACH,CascadeType.MERGE,
		CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name = "course_student",
			joinColumns =@JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="student_id")
			)
	private List<Student> students;
	
  //Define constructor
	
	public Course()
	{}

public Course(String title) {
	super();
	this.title = title;
}

// Define getters and setters
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}

//adding method to add a single student
public void addStudent(Student student)
{
	if(students == null)
	{
		students = new ArrayList<Student>();
	}
	students.add(student);
	}
//Define toString
@Override
public String toString() {
	return "Course [id=" + id + ", title=" + title + "]";
}
	

}
