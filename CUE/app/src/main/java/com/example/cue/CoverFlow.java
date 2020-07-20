package com.example.cue;



import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

@SuppressWarnings("ALL")
public class CoverFlow extends Gallery {
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    Context cont;
    int item;







    /**
     * Graphics Camera used for transforming the matrix of ImageViews
     */
    private Camera mCamera = new Camera();

    /**
     * The maximum angle the Child ImageView will be rotated by
     */
    private int mMaxRotationAngle = 60;

    /**
     * The maximum zoom on the centre Child
     */
    private int mMaxZoom = -120;

    /**
     * The Centre of the Coverflow
     */
    private int mCoveflowCenter;

    public CoverFlow(Context context) {
        super(context);
        this.cont=context;
        this.setStaticTransformationsEnabled(true);
    }

    public CoverFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setStaticTransformationsEnabled(true);
        this.cont=context;
    }

    public CoverFlow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setStaticTransformationsEnabled(true);
        this.cont=context;
    }

    /**
     * Get the max rotational angle of the image
     * @return the mMaxRotationAngle
     */
    public int getMaxRotationAngle() {
        return mMaxRotationAngle;
    }

    /**
     * Set the max rotational angle of each image
     * @param maxRotationAngle the mMaxRotationAngle to set
     */
    public void setMaxRotationAngle(int maxRotationAngle) {
        mMaxRotationAngle = maxRotationAngle;
    }

    /**
     * Get the Max zoom of the centre image
     * @return the mMaxZoom
     */
    public int getMaxZoom() {
        return mMaxZoom;
    }

    /**
     * Set the max zoom of the centre image
     * @param maxZoom the mMaxZoom to set
     */
    public void setMaxZoom(int maxZoom) {
        mMaxZoom = maxZoom;
    }
    public int getItid(){
        return item;
    }

    /**
     * Get the Centre of the Coverflow
     * @return The centre of this Coverflow.
     */
    private int getCenterOfCoverflow() {
        return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
    }

    /**
     * Get the Centre of the View
     * @return The centre of the given view.
     */
    private static int getCenterOfView(View view) {
        return (view.getLeft() + view.getRight()  ) /2;
    }
    /**
     * {@inheritDoc}
     *
     * @see #setStaticTransformationsEnabled(boolean)
     */
    @SuppressWarnings("deprecation")
    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        child.invalidate();

        final int childCenter = getCenterOfView(child);
        final int childWidth = child.getWidth() ;
        int rotationAngle = 0;

        t.clear();
        t.setTransformationType(Transformation.TYPE_MATRIX);

        if (childCenter == mCoveflowCenter) {


            transformImageBitmap((ImageView) child, t, 0);






        } else {
            rotationAngle = (int) (((float) (mCoveflowCenter - childCenter)/ childWidth) *  mMaxRotationAngle);
            if (Math.abs(rotationAngle) >= mMaxRotationAngle) {
                rotationAngle = (rotationAngle < 0) ? -mMaxRotationAngle : mMaxRotationAngle;
            }
            transformImageBitmap((ImageView) child, t, rotationAngle);


        }

        if (Build.VERSION.SDK_INT >= 16) child.invalidate();



        return true;
    }

    /**
     * This is called during layout when the size of this view has changed. If
     * you were just added to the view hierarchy, you're called with the old
     * values of 0.
     *
     * @param w Current width of this view.
     * @param h Current height of this view.
     * @param oldw Old width of this view.
     * @param oldh Old height of this view.
     */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCoveflowCenter = getCenterOfCoverflow();
        super.onSizeChanged(w, h, oldw, oldh);
    }


    private void transformImageBitmap(View child, Transformation t, int rotationAngle) {
        mCamera.save();
        final Matrix imageMatrix = t.getMatrix();;
        final int imageHeight = child.getLayoutParams().height;;
        final int imageWidth = child.getLayoutParams().width;
        final int rotation = Math.abs(rotationAngle);

        mCamera.translate(0.0f, 0.0f, 100.0f);

        //As the angle of the view gets less, zoom in
        if ( rotation < mMaxRotationAngle ) {
            float zoomAmount = (float) (mMaxZoom +  (rotation * 1.5));
            mCamera.translate(0.0f, 0.0f, zoomAmount);
        }

        mCamera.rotateY(rotationAngle);
        mCamera.getMatrix(imageMatrix);
        imageMatrix.preTranslate(-(imageWidth/2), -(imageHeight/2));
        imageMatrix.postTranslate((imageWidth/2), (imageHeight/2));
        mCamera.restore();
    }
}

