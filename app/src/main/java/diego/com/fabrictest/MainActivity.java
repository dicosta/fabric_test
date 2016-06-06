package diego.com.fabrictest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.StartCheckoutEvent;
import com.crashlytics.android.core.CrashlyticsListener;

import java.math.BigDecimal;
import java.util.Currency;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Crashlytics.log("Step: Main Activity");
    }

    public void forceCrashInActivity(View view) {
        String string = null;
        String crash = string.toString();
    }

    public void forceCrashInOtherClass(View view) {
        HelperClass.crashWithNPE();
    }

    public void forceCrashInAndroid(View view) {
        //String string = getString(2345342);
    }

    public void randomizeUserInfo(View view) {
        MainApplication.getInstance().setRandomUser();
    }

    public void feedBreadCrumb(View view) {
        Crashlytics.log("Crumb Feed: " + Integer.toString(MainApplication.getInstance().getNextCrumb()));
    }

    public void goToSecondActivity(View view) {
        Intent secondActivity = new Intent(this, SecondActivity.class);
        startActivity(secondActivity);
    }

    public void startCheckout(View view) {
        Answers.getInstance().logStartCheckout(new StartCheckoutEvent()
                .putTotalPrice(BigDecimal.valueOf(123.50))
                .putCurrency(Currency.getInstance("USD"))
                .putItemCount(3));
    }
}
