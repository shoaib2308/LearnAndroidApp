package simplycodinghub.learnandroidapp.AProjects.Home;

import android.os.Bundle;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import simplycodinghub.learnandroidapp.AProjects.Home.Adapters.FoodAdapter;
import simplycodinghub.learnandroidapp.AProjects.Home.Model.FoodModel;
import simplycodinghub.learnandroidapp.R;

public class HomeActivity extends AppCompatActivity {

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.app_images_diwali1, R.drawable.app_images_diwali4, R.drawable.app_images_diwali5, R.drawable.app_images_diwali2};

    private ArrayList<FoodModel> homeListModelClassArrayList;
    private RecyclerView recyclerView;
    private FoodAdapter mAdapter;
    Integer image[] = {R.drawable.cat_46, R.drawable.cat_46_blue, R.drawable.cat_46,  R.drawable.cat_46_blue,R.drawable.cat_46,R.drawable.cat_46_blue};
    String foodName[] = {"Fast Food", "Chineese", "Punjabi","Fast Food", "Chineese", "Punjabi"};
    String totalRest[] = {"74 Restaurant", "34 Restaurant", "65 Restaurant","74 Restaurant", "34 Restaurant", "65 Restaurant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        homeListModelClassArrayList = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            FoodModel beanClassForRecyclerView_contacts = new FoodModel(image[i],foodName[i],totalRest[i]);
            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
        }
        mAdapter = new FoodAdapter(HomeActivity.this,homeListModelClassArrayList);

        GridLayoutManager   mLayoutManager= new GridLayoutManager (HomeActivity.this,3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
