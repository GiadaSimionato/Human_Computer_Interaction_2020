package com.example.cue;



import java.io.FileInputStream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;


import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

@SuppressWarnings("ALL")
public class CoverActivityFirst extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.cue.R.layout.activity_main);
        final Context cont=this.getApplicationContext();

        final TextView t=(TextView)findViewById(R.id.textView_) ;

        final CoverFlow coverFlow;
        coverFlow = findViewById(R.id.coverflow);

        coverFlow.setAdapter(new ImageAdapter(getApplication()));
        Button explore=(Button)findViewById(R.id.button);



        ImageAdapter coverImageAdapter =  new ImageAdapter(this);

        //coverImageAdapter.createReflectedImages();

        coverFlow.setAdapter(coverImageAdapter);

        coverFlow.setSpacing(-25);
        coverFlow.setSelection(1, true);
        coverFlow.setAnimationDuration(1000);
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View v, int position,
                                    long rowID) {
                Toast.makeText(v.getContext(), "clicked " + position , 1000).show();
            }
        });

        LinearLayout sliderDotspanel = (LinearLayout)findViewById(R.id.SliderDots);
        final int dotscount=coverFlow.getCount();
        final ImageView[] dots;
        dots=new ImageView[dotscount];

        for(int i=0; i<dotscount;i++){
            dots[i]=new ImageView(this);
            dots[i].setImageDrawable(
                    ContextCompat.getDrawable(this, R.drawable.nonactive_dots)
            );
            LinearLayout.LayoutParams param= new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            param.setMargins(0,0,0,0);
            if(sliderDotspanel!=null ){
                sliderDotspanel.addView(dots[i], param);
            }

        }
        final int medio= dotscount/2;
        dots[medio].setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.active_dots)
        );
        t.setText("This section shows you the Uni-accomodations");
         /*explore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(cont, NOMEATTIVITA.class);
                        startActivity(intent);
                    }
                });*/


        coverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                for(int i=0; i<dotscount;i++){

                    dots[i].setImageDrawable(
                            ContextCompat.getDrawable(cont, R.drawable.nonactive_dots)
                    );}
                dots[position].setImageDrawable( ContextCompat.getDrawable(cont, R.drawable.active_dots));

                if(position==0){t.setText("This section shows you cafe insiede Uni");
                  /*explore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(cont, NOMEATTIVITA.class);
                        startActivity(intent);
                    }
                });*/}
                if(position==1){t.setText("This section shows you the Uni-accomodations");
                  /*explore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(cont, NOMEATTIVITA'.class);
                        startActivity(intent);
                    }
                });*/}
                if(position==2){t.setText("This section is explains the Disability services");
                  /*explore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(cont, NOMEATTIVITA'.class);
                        startActivity(intent);
                    }
                });*/}




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });



        CoverFlow c=findViewById(R.id.coverflow);

        c=coverFlow;





    }

    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;

        private FileInputStream fis;

        private Integer[] mImageIds = {
                R.drawable.cafe,
                R.drawable.accomodations,
                R.drawable.disability,


        };

        private ImageView[] mImages;

        public ImageAdapter(Context c) {
            mContext = c;
            mImages = new ImageView[mImageIds.length];
        }

        public boolean createReflectedImages() {
            //The gap we want between the reflection and the original image
            final int reflectionGap = 4;


            int index = 0;
            for (int imageId : mImageIds) {
                Bitmap originalImage = BitmapFactory.decodeResource(getResources(),
                        imageId);
                int width = originalImage.getWidth();
                int height = originalImage.getHeight();


                //This will not scale but will flip on the Y axis
                Matrix matrix = new Matrix();
                matrix.preScale(1, -1);

                //Create a Bitmap with the flip matrix applied to it.
                //We only want the bottom half of the image
                Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, height / 2, width, height / 2, matrix, false);


                //Create a new bitmap with same width but taller to fit reflection
                Bitmap bitmapWithReflection = Bitmap.createBitmap(width
                        , (height + height / 2), Config.ARGB_8888);

                //Create a new Canvas with the bitmap that's big enough for
                //the image plus gap plus reflection
                Canvas canvas = new Canvas(bitmapWithReflection);
                //Draw in the original image
                canvas.drawBitmap(originalImage, 0, 0, null);
                //Draw in the gap
                Paint deafaultPaint = new Paint();
                canvas.drawRect(0, height, width, height + reflectionGap, deafaultPaint);
                //Draw in the reflection
                canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

                //Create a shader that is a linear gradient that covers the reflection
                Paint paint = new Paint();
                LinearGradient shader = new LinearGradient(0, originalImage.getHeight(), 0,
                        bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff, 0x00ffffff,
                        TileMode.CLAMP);
                //Set the paint to use this shader (linear gradient)
                paint.setShader(shader);
                //Set the Transfer mode to be porter duff and destination in
                paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                //Draw a rectangle using the paint with our linear gradient
                canvas.drawRect(0, height, width,
                        bitmapWithReflection.getHeight() + reflectionGap, paint);

                ImageView imageView = new ImageView(mContext);
                imageView.setImageBitmap(bitmapWithReflection);
                imageView.setLayoutParams(new CoverFlow.LayoutParams(120, 120));
                imageView.setScaleType(ScaleType.MATRIX);
                mImages[index++] = imageView;

            }
            return true;
        }

        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            //Use this code if you want to load from resources
            ImageView i = new ImageView(mContext);
            i.setImageResource(mImageIds[position]);
            i.setLayoutParams(new CoverFlow.LayoutParams(630, 630));//parametri per grandezza immagini
            i.setScaleType(ScaleType.CENTER_INSIDE);

            //Make sure we set anti-aliasing otherwise we get jaggies
            BitmapDrawable drawable = (BitmapDrawable) i.getDrawable();
            drawable.setAntiAlias(true);
            //vie.addView(i);
            return i;

            //return mImages[position];
        }




        public float getScale(boolean focused, int offset) {
            /* Formula: 1 / (2 ^ offset) */
            return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
        }

    }




}
