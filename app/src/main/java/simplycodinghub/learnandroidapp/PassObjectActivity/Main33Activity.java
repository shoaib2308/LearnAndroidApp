package simplycodinghub.learnandroidapp.PassObjectActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main33Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main33);

        Employee employee = (Employee) getIntent().getSerializableExtra("employeeData");

        TextView tv = findViewById(R.id.tv);

        tv.setText(
                employee.name + "\n"
                + employee.gender + "\n"
                + employee.qualification + "\n"
                + Arrays.toString(employee.hobbies)
        );
    }
}
