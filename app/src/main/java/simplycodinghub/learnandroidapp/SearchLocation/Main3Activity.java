package simplycodinghub.learnandroidapp.SearchLocation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import simplycodinghub.learnandroidapp.R;

public class Main3Activity extends AppCompatActivity {
    public String TAG = "PLaceShoaib";
    private int request_code = 1001;

    LinearLayout lay_search;
    TextView txt_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Constants constants = new Constants();
        Places.initialize(getApplicationContext(), constants.GOOGLE_KEY);
        //Places.initialize(getApplicationContext(), "AIzaSyAVsW2uugTsjAFcZVG-SYvyic-kWIOZhwQ");

        lay_search = (LinearLayout) findViewById(R.id.lay_search);
        txt_search = (TextView) findViewById(R.id.txt_search);
        lay_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAutocompleteActivity();
            }
        });
        startAutocompleteActivity();
    }

    private void startAutocompleteActivity() {
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS);
        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, request_code);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == request_code) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                Log.i(TAG, "ManishPlace: " + place.getPhoneNumber());

                txt_search.setText(place.getName() + ",\n" +
                        place.getAddress() + "\n" + place.getPhoneNumber());
                String location = place.toString();

                System.out.println("manishshis" + location);
                if (location != null && !location.equals("")) {
                    //new MapsActivity.GeocoderTask().execute(place.toString());
                }

            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i(TAG, status.getStatusMessage());
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }


}
