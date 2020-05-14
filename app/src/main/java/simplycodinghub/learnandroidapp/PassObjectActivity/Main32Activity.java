package simplycodinghub.learnandroidapp.PassObjectActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main32Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main32);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main33Activity.class);

                Employee emp = new Employee("koko", "Male",
                        "B.E",
                        new String[]{
                                "football",
                                "cricket",
                                "video game"
                        });

                i.putExtra("employeeData", emp);

                startActivity(i);
            }
        });
    }
}
