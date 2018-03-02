package com.ogokilearning.libraryquickbuild;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageView;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/**
 * Created by jordandysart on 2018-02-06.
 */

public class ScalingImageView extends AppCompatImageView {
    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor = 1.f;


    public ScalingImageView(Context mContext){
        super(mContext);
        // View code goes here
        mScaleDetector = new ScaleGestureDetector(mContext, new ScaleListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Let the ScaleGestureDetector inspect all events.
        mScaleDetector.onTouchEvent(ev);
        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor);
        // onDraw() code goes here
        canvas.restore();
    }

    private class ScaleListener
            extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();

            // Don't let the object get too small or too large.
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));

            invalidate();
            return true;
        }
    }
}
