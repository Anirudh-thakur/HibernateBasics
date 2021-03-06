package demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetailsMany {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	

	@Column(name="hobby")
	private String hobby;
	
	//Joining to instructor details and adding all cascading type
	@OneToOne(cascade=CascadeType.ALL,mappedBy="InstructorDetailsMany")
		private InstructorMany InstructorMany;

	//Constructors 

	public InstructorDetailsMany(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	public InstructorDetailsMany()
	{}
	
	//Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYoutubeChannel() {
		return youtubeChannel;
	}
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public InstructorMany getInstructorMany() {
		return InstructorMany;
	}
	public void setInstructorMany(InstructorMany InstructorMany) {
		this.InstructorMany = InstructorMany;
	}
	//To string 
	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
	
	
}
