package com.ogokilearning.libraryquickbuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

    private boolean mIsBackButtonPressed;
    private static final int SPLASH_DURATION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Handler handler = new Handler();
        // Run a thread after 2 seconds to start the home screen
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                finish();

                if (!mIsBackButtonPressed) {

                    // start the home screen if the back button wasn't pressed already
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);

                    SplashScreen.this.startActivity(intent);

                }

            }

        }, SPLASH_DURATION);

    }


}
