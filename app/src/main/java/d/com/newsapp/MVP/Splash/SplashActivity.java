package d.com.newsapp.MVP.Splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import d.com.newsapp.MVP.Home.HomeActivity;
import d.com.newsapp.R;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread sleepThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    goToHomePage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        sleepThread.start();
    }

    private void goToHomePage() {
        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        finish();
    }
}
