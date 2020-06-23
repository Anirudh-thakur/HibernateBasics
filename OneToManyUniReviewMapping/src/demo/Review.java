package demo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	//Mapping Courses
		@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST ,CascadeType.DETACH , CascadeType.MERGE 
				, CascadeType.REFRESH , CascadeType.REMOVE })
		@JoinColumn(name="course_id")
		private Course course;
        
		//Generating constructors
		public Review()
		{}
		public Review(String comment) {
		super();
		this.comment = comment;
	}
     
		//Generating getting setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}
		
		//Generating toString
		@Override
		public String toString() {
			return "Review [id=" + id + ", comment=" + comment + ", course=" + course + "]";
		}
		
		
}