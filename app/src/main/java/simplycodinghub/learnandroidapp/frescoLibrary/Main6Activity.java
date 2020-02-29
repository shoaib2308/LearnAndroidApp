package simplycodinghub.learnandroidapp.frescoLibrary;

import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        Fresco.initialize(this); // Initialize

        setContentView(R.layout.activity_main);
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.compLogo);
        Uri imageUri = Uri.parse("https://cdn-images.cure.fit/www-curefit-com/image/upload/w_232,ar_0.8,fl_progressive,f_auto,q_auto/dpr_1/image/packs/cult/CULTPACK796/26_mag_web.jpg");

        draweeView.setImageURI(imageUri);

    }
}
