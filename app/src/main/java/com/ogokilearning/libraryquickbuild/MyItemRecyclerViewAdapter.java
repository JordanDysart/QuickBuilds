package com.ogokilearning.libraryquickbuild;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link CreditItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {



    private final List<CreditInformation.CreditItem> mValues;
    private final CreditsListFragment.OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<CreditInformation.CreditItem> items, CreditsListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.credits_profile_button_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        // TODO change this background to handle a one pager on the end.
        holder.mImagView.setImageResource(R.drawable.background);
        holder.mContentView.setText(holder.mItem.title);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ImageView mImagView;
        public TextView mContentView;
        public CreditInformation.CreditItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImagView =  view.findViewById(R.id.credits_profile_button_image_view);
            mContentView = view.findViewById(R.id.credits_profile_button_text_view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
