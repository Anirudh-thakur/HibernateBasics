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
	
	//Mapping instructor
	@ManyToOne(cascade = {CascadeType.PERSIST ,CascadeType.DETACH , CascadeType.MERGE 
			, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private InstructorMany instructor;
	
	//Mapping Reviews
	@OneToMany(mappedBy="course", cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.REMOVE,CascadeType.REFRESH},targetEntity=Review.class)
	private List<Review> reviews;
	
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
public InstructorMany getInstructor() {
	return instructor;
}
public void setInstructor(InstructorMany instructor) {
	this.instructor = instructor;
}


public List<Review> getReviews() {
	return reviews;
}
public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}
//Define toString
@Override
public String toString() {
	return "Course [id=" + id + ", title=" + title + "]";
}
	
//Method to establish a bidirectional Relationship between Review and courses
	public void AddReview(Review tempReview)
	{
		if(reviews == null)
		{
			reviews = new ArrayList<Review>();
		}
		reviews.add(tempReview);
		tempReview.setCourse(this);
	}

}
