package com.ogokilearning.libraryquickbuild;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreditsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreditsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TITLE = "param1";
    private static final String DESCRIPTION = "param2";
    private static final String PICTURE =  "param3";

    // TODO: Rename and change types of parameters
    private Integer mPicture;
    private String mTitle;
    private String mDescription;

    private ImageView picture;
    private TextView title;
    private TextView description;


    private OnFragmentInteractionListener mListener;

    public CreditsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Parameter 1.
     * @param description Parameter 2.
     * @return A new instance of fragment CreditsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreditsFragment newInstance(String title, String description, Integer picture) {
        CreditsFragment fragment = new CreditsFragment();
        Bundle args = new Bundle();

        args.putInt(PICTURE, picture);
        args.putString(TITLE, title);
        args.putString(DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(TITLE);
            mDescription = getArguments().getString(DESCRIPTION);
            mPicture = getArguments().getInt(PICTURE);
        } else {
            mTitle = "About Us";
            mDescription = getContext().getString(R.string.credit_description);
            mPicture = R.drawable.green;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.credits_profile_layout, container, false);
        picture = view.findViewById(R.id.credits_profile_image_view);
        picture.setImageResource(mPicture);
        title = view.findViewById(R.id.credits_profile_title_view);
        title.setText(mTitle);
        description = view.findViewById(R.id.credits_profile_text_body);
        description.setText(mDescription);

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
