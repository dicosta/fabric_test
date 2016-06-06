package diego.com.fabrictest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.Crashlytics;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setTitle("Third Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Crashlytics.log("Step: Third Activity");
    }

    public void forceCrashInActivity(View view) {
        String string = null;
        String crash = string.toString();
    }

    public void forceCrashInOtherClass(View view) {
        HelperClass.crashWithNPE();
    }
}
