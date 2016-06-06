package diego.com.fabrictest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.Crashlytics;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Crashlytics.log("Step: Second Activity");
    }

    public void forceCrashInActivity(View view) {
        String string = null;
        String crash = string.toString();
    }

    public void forceCrashInOtherClass(View view) {
        HelperClass.crashWithNPE();
    }

    public void goToThirdActivity(View view) {
        Intent thirdActivity = new Intent(this, ThirdActivity.class);
        startActivity(thirdActivity);
    }
}
