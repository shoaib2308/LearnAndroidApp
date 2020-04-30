package simplycodinghub.learnandroidapp.LifecycleLearn;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import simplycodinghub.learnandroidapp.R;

public class Main7Activity extends BaseActivity implements View.OnClickListener {
Button button;
    LinearLayout li_oneway;
    LinearLayout li_roundtrip;
    TextView oneway;
    TextView roundtrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_one);

        this.li_oneway = (LinearLayout) findViewById(R.id.li_oneway);
        this.li_roundtrip = (LinearLayout) findViewById(R.id.li_roundtrip);
        this.oneway = (TextView) findViewById(R.id.oneway);
        this.roundtrip = (TextView) findViewById(R.id.roundtrip);
        this.li_oneway.setOnClickListener(this);
        this.li_roundtrip.setOnClickListener(this);

        Log.d("lifecycle2","onCreate() invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle2","onStart() invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle2","onResume() invoked");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle2","onPause() invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle2","onStop() invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle2","onRestart() invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle2","onDestroy() invoked");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.li_oneway /*2131296375*/:
                this.li_oneway.setBackgroundResource(R.drawable.rectangle_bluecornnor);
                this.li_roundtrip.setBackgroundResource(R.drawable.rectangle_whiterounded);
                this.oneway.setTextColor(Color.parseColor("#ffffff"));
                this.roundtrip.setTextColor(Color.parseColor("#919ca5"));
                return;
            case R.id.li_roundtrip /*2131296376*/:
                this.li_oneway.setBackgroundResource(R.drawable.rectangle_whiterounded);
                this.li_roundtrip.setBackgroundResource(R.drawable.rectangle_bluecornnor);
                this.oneway.setTextColor(Color.parseColor("#919ca5"));
                this.roundtrip.setTextColor(Color.parseColor("#ffffff"));
                return;
            default:
                return;
        }
    }
}
