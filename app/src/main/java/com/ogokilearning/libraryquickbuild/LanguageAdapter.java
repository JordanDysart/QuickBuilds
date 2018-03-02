package com.ogokilearning.libraryquickbuild;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {

	private String[] englishCategory;
	private String[] secondaryLanguage;
	private Integer[] audio;

	private GridItemClickListener mGridItemClickListener;

	public LanguageAdapter(String category, GridItemClickListener gridItemClickListener) {
		this.englishCategory = Dictionary.getCategoryEnglish(category);
		this.secondaryLanguage = Dictionary.getSyllabic(category);
		this.audio = Dictionary.getAudioArray(category);
		this.mGridItemClickListener = gridItemClickListener;
	}

	public interface GridItemClickListener {
		void onListItemClick(int audio);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		Context context = parent.getContext();
		int layoutId = R.layout.dialog_grid_item;
		LayoutInflater inflater = LayoutInflater.from(context);
		boolean shouldAttachToParentImmediately = false;

		View view = inflater.inflate(layoutId, parent, shouldAttachToParentImmediately);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.mTextView.setText(englishCategory[position]);
		holder.mSymbolView.setText(secondaryLanguage[position]);
	}

	@Override
	public int getItemCount() {
		if (englishCategory != null) {
			return englishCategory.length;
		}
		return 0;
	}



	public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
		// each data item is just a string in this case
		String TAG = CategoryAdapter.ViewHolder.class.getName();
		public TextView mTextView, mSymbolView;

		public ViewHolder(View itemView) {
			super(itemView);
			this.mTextView = itemView.findViewById(R.id.secondary_word);
			this.mSymbolView = itemView.findViewById(R.id.primary_word);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			Log.d(TAG, "onClick " + getAdapterPosition() );
			int clickedPosition = getAdapterPosition();
			int rAddress = getAudio(clickedPosition);
			mGridItemClickListener.onListItemClick(rAddress);
		}

	}

	public int getAudio(int position) {
		return this.audio[position];
	}



	public static int findSpriteSize() {
		return 128;
	}

	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;
		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;
			// Calculate the largest inSampleSize value that is a power of 2 and keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) >= reqHeight
					&& (halfWidth / inSampleSize) >= reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}

	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);

	}

}
