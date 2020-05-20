package simplycodinghub.learnandroidapp.FullScreenPopUp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import simplycodinghub.learnandroidapp.R;

public class Main37Activity extends AppCompatActivity {
    final DialogFragment dialog = FullscreenDialog.newInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main37);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               /* ((FullscreenDialog) dialog).setCallback(new FullscreenDialog.Callback() {
                    @Override
                    public void onActionClick(String name) {
                        Toast.makeText(Main37Activity.this, name, Toast.LENGTH_SHORT).show();
                    }
                });*/
                dialog.show(getSupportFragmentManager(), "tag");

            }

        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                EditNameDialogFragment editNameDialogFragment = EditNameDialogFragment.newInstance("koko Title");
                editNameDialogFragment.show(fm, "title");
            }
        });

    }

}
