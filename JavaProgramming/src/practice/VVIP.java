
package practice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class VVIP extends Person implements Serializable {
	private int memberShipNo;
	private String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public VVIP() {
	}

	public VVIP(int memberShipNo, String grade, String name, int age) {
		super(name, age);
		this.memberShipNo = memberShipNo;
		this.grade = grade;
	}

	public int getMemberShipNo() {
		return memberShipNo;
	}

	public void setMemberShipNo(int memberShipNo) {
		this.memberShipNo = memberShipNo;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeObject(getAge());
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.readObject();
		in.defaultReadObject();
	}
}