package practice_exam20;

public class Food {
    private String foodName;
    private String image;
    private int score;
    private String description;
    
    public Food() {
        
    }

    public Food(String foodName, String image, int score, String description) {
        this.foodName = foodName;
        this.image = image;
        this.score = score;
        this.description = description;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getImage() {
        return image;
    }

    public int getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}