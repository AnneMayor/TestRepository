package exam05;

public class Music {
	private String name;
	private String title;
	//private String musicLink;
	private String image;
	
	public Music() {
		
	}
	public Music(String name, String title, String image) {
		this.name = name;
		this.title = title;
		//this.musicLink = musicLink;
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}