package com.ogokilearning.libraryquickbuild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;


/**
 * Created by ogoki on 2016-12-06.
 */
public class BaseFragment extends Fragment {

    protected MainActivity fragmentTabActivity;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentTabActivity = (MainActivity) this.getActivity();
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
