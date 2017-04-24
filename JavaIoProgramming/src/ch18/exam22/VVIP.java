package ch18.exam22;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class VVIP extends Person implements Serializable {

    private int memberShipNo;
    private String grade;

    public VVIP() {}
    
    public VVIP(int memberShipNo, String grade, String name, int age) {
        super(name);
        this.memberShipNo = memberShipNo;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setMemberShipNo(int memberShipNo) {
        this.memberShipNo = memberShipNo;
    }

    public int getMemberShipNo() {
        return memberShipNo;
    }
    
    // 밑의 메소드에는 Serializable을 구현하지 않은 부모 클래스에서 가져오고자 하는 필드값을 불러오기 위한 것!
    /*
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(getName());
        out.writeInt(getAge());
        out.defaultWriteObject(); // 자식 객체는 여기서 다 직렬화가 된다!
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        setName(in.readUTF());
        setAge(in.readInt());
        in.defaultReadObject();
    }
*/
    
}