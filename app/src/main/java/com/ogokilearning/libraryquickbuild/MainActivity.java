package com.ogokilearning.libraryquickbuild;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTitleView;
    private ImageView mBackgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBackgroundImage = findViewById(R.id.background_image);
        mTitleView = findViewById(R.id.topbar_title);

    }

    public void setBackground(final String category) {
        AsyncTask<Void, Void, TransitionDrawable> task = new AsyncTask<Void, Void, TransitionDrawable>() {

            @Override
            protected TransitionDrawable doInBackground(Void... params) {
                Bitmap bitmap = Utils.scaleDown(R.drawable.blue, Utils.screenWidth(), Utils.screenHeight());
                Bitmap backgroundImage = Dictionary.getBackgroundImage(category);
                backgroundImage = Utils.crop(backgroundImage, Utils.screenHeight(), Utils.screenWidth());
                Drawable backgrounds[] = new Drawable[2];
                backgrounds[0] = new BitmapDrawable(Shared.context.getResources(), bitmap);
                backgrounds[1] = new BitmapDrawable(Shared.context.getResources(), backgroundImage);
                TransitionDrawable crossfader = new TransitionDrawable(backgrounds);
                return crossfader;
            }

            @Override
            protected void onPostExecute(TransitionDrawable result) {
                super.onPostExecute(result);
                mBackgroundImage.setImageDrawable(result);
                result.startTransition(2000);

            }
        };

        task.execute();
    }

    public void addFragments(String tabName, Fragment fragment,
                             boolean animate, boolean add) {
        if (add) {
//            this.mLastTab.secondFragment = fragment;

        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (animate) {
//            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        ft.replace(android.R.id.tabcontent, fragment);
        ft.commit();
    }

    public void setTitleView(String title) {
        mTitleView.setText(title);
    }

}
