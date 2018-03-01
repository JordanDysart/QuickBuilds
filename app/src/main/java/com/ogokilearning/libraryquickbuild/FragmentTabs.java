package com.ogokilearning.libraryquickbuild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ogoki on 2018-03-01.
 *
 */

public class FragmentTabs extends Fragment {
    private FragmentTabHost mTabHost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mTabHost = new FragmentTabHost(getActivity());
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.fragment1);
        addTabs();

        return mTabHost;
    }

    private void addTabs() {
        mTabHost.addTab(mTabHost.newTabSpec("categories")
                .setIndicator("Categories"),
                CategoryFragment.class,
                null);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;

    }

}
