package simplycodinghub.learnandroidapp.AProjects.Home.Model;

/**
 * Created by wolfsoft1 on 27/2/18.
 */

public class FoodModel {
    Integer image ;

    public FoodModel(Integer image, String foodName, String totalRes) {
        this.image = image;
        this.foodName = foodName;
        this.totalRes = totalRes;
    }

    String foodName,totalRes;

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTotalRes() {
        return totalRes;
    }

    public void setTotalRes(String totalRes) {
        this.totalRes = totalRes;
    }
}
