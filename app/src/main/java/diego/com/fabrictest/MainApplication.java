package diego.com.fabrictest;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import java.util.Date;
import java.util.Random;

import io.fabric.sdk.android.Fabric;

/**
 * Created by diego on 03/06/16.
 */

public class MainApplication extends Application {

    private static MainApplication sInstance;

    public static MainApplication getInstance() {
        return sInstance;
    }

    public static int lastCrumb = 0;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        Fabric.with(this, new Crashlytics());

        Crashlytics.setUserIdentifier("100");
        Crashlytics.setUserEmail("default_user@mail.com");
        Crashlytics.setUserName("Usuario Default");


        Crashlytics.setString("custom_key_create_process_ts", new Date().toString());
    }

    public void setRandomUser() {
        Random r = new Random();
        int userId = r.nextInt(300 - 200) + 200;


        Crashlytics.setUserIdentifier(Integer.toString(userId));
        Crashlytics.setUserEmail("random_user_" + Integer.toString(userId) + "@mail.com");
        Crashlytics.setUserName("Usuario Random_" + Integer.toString(userId));

        //todo: persist random user for next run?
    }

    public int getNextCrumb() {
        lastCrumb++;
        return lastCrumb;
    }
}

