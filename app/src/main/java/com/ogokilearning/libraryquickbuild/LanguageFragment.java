package com.ogokilearning.libraryquickbuild;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnCategoryInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LanguageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LanguageFragment extends BaseFragment implements LanguageAdapter.GridItemClickListener{

    private static final String curCategory = "category";

    private RecyclerView rvLanguage;
    private TextView titleView;
    private String category;


    public static boolean sClicked = false;


    private int mCurrentPosition;

    private OnCategoryInteractionListener mListener;

    public LanguageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param category Let's pass this parameter to create the .
     * @return A new instance of fragment LanguageFragment.
     */
    public static LanguageFragment newInstance(int category) {
        LanguageFragment fragment = new LanguageFragment();
        Bundle args = new Bundle();
        args.putInt(curCategory, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCurrentPosition = getArguments().getInt(curCategory);
            category = Dictionary.getGridCategories()[mCurrentPosition];


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(curCategory);
        }

        View view = inflater.inflate(R.layout.fragment_language_category, container, false);

        rvLanguage = view.findViewById(R.id.gridView_sub);
        Context context = getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        AutofitLayoutManager layoutManager = new AutofitLayoutManager(getActivity(), 364);

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;

        int span = 2;
        if (width > 800) {
            span = 4;
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, span);

        LanguageAdapter languageAdapter = new LanguageAdapter(category,this);
        rvLanguage.setLayoutManager(layoutManager);
        rvLanguage.setAdapter(languageAdapter);

        titleView = getActivity().findViewById(R.id.topbar_title);
        titleView.setText(category);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        fragmentTabActivity.setTitleView("Categories");
        Music.OFF = false;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnCategoryInteractionListener {
        void onCategoryInteraction(String category);
    }

    @Override
    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    @Override
    public void onListItemClick(int audio) {
        Music.playFile(audio);
    }


}
