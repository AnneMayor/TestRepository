package ch17.exam21;

// 기본적으로 클래스 필드는 private 접근 제한자를 쓴다!이거 활용 잘하자!
// 여기서 이 클래스는 plan object 클래스! 
public class Phone {

    private String image;
    private String name;
    private String contents;

    public Phone() {

    }

    public Phone(String image, String name, String contents) {
        this.image = image;
        this.name = name;
        this.contents = contents;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getContents() {
        return contents;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
