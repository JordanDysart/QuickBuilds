package com.ogokilearning.libraryquickbuild;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jordandysart on 2018-01-23.
 *
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    String[] mCategories, mSymbols;
    Integer[] mIcons;

    private final CategoryClickListener mCategoryClickListener;

    public CategoryAdapter(CategoryClickListener categoryClickListener) {
        mCategoryClickListener =  categoryClickListener;
        mCategories = Dictionary.getGridCategories();
        mSymbols = Dictionary.getGridCategorySymbols();
        mIcons = Dictionary.getCategoryIcons();


    }

    public interface CategoryClickListener {
        void onItemClick(int clickedItemIndex);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mCategories[position]);
        holder.mSymbolView.setText(mSymbols[position]);
        holder.mIcon.setImageResource(mIcons[position]);

    }

    @Override
    public int getItemCount() {
        return mCategories.length;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);

        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        String TAG = ViewHolder.class.getName();
        public TextView mTextView, mSymbolView;
        public ImageView mIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mIcon = itemView.findViewById(R.id.imageview_category_icon);
            this.mTextView = itemView.findViewById(R.id.grid_item_text);
            this.mSymbolView = itemView.findViewById(R.id.syllabics_item_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick " + getAdapterPosition() );
            int clickedPosition = getAdapterPosition();
            mCategoryClickListener.onItemClick(clickedPosition);
        }

    }

}
