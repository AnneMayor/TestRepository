package ch18.exam19;

import java.io.Serializable;

public class Member implements Serializable { // Serializable: 객체가 가도 된다고 하는 허가사항(이 객체를 파일로 저장해도 상관없고 네트워크로 보내도 문제없다는 내용)
    // Field
    private String id;
    private String name;
    private int age;
    
    // Constructor
     public Member(String name, int age) {
        this.name = name;
        this.age = age;
     }
     
    // Method

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

   
    }
