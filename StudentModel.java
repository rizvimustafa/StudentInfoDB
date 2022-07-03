package Model;

public class StudentModel {
	private int ID;
	private String name;
	private String course;
	private int fee;
	
	public int getID() {
		return ID;
	}
	public void setID(int studentID) {
		ID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
}
