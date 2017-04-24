package ch15.exam04;

public class Student {
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		if( obj instanceof Student) {
			Student student = (Student)obj;
			return (this.name.equals(student.name)) && (this.sno == student.sno); 
		} else
			return false;
	}
	
	public int hashCode() {
		return name.hashCode() + sno;
	}
}
