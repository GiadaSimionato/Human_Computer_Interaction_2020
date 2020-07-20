package com.example.cue;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressWarnings("ALL")
public class CourseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayAdapter<String> listviewAdapter;
    private ArrayAdapter<String> spinnerAdapter;
    private Button bt = null;
    private ImageButton bt1 = null;
    Spinner classSpinner, divSpinner;
    // string variable to store selected values
    String selectedClass, selectedDiv;
    Spinner classSpinner1, divSpinner1;
    // string variable to store selected values
    String selectedClass1, selectedDiv1;
    TextView title;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CourseFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CourseFragment newInstance() {
        CourseFragment fragment = new CourseFragment();

        fragment.setArguments(null);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_slider_first, null, false);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_slider_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView t=(TextView)view.findViewById(R.id.textView_) ;

        final CoverFlow coverFlow;
        title=view.findViewById(R.id.slidettitle);
        title.setText("Find a course");
         TextView subtitle=view.findViewById(R.id.sub);
         subtitle.setText("Please, select the level of education:");

        coverFlow = view.findViewById(R.id.coverflow);

        coverFlow.setAdapter(new ImageAdapter(this.getActivity()));

        ImageAdapter coverImageAdapter =  new ImageAdapter(this.getActivity());
        final Button explore=(Button)view.findViewById(R.id.button);

        //coverImageAdapter.createReflectedImages();

        coverFlow.setAdapter(coverImageAdapter);

        coverFlow.setSpacing(-25);
        coverFlow.setSelection(1, true);
        coverFlow.setAnimationDuration(1000);
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View v, int position,
                                    long rowID) {
                //Toast.makeText(v.getContext(), "clicked " + position , 1000).show();
            }
        });

        LinearLayout sliderDotspanel = (LinearLayout)view.findViewById(R.id.SliderDots);
        final int dotscount=coverFlow.getCount();
        final ImageView[] dots;
        dots=new ImageView[dotscount];

        for(int i=0; i<dotscount;i++){
            dots[i]=new ImageView(this.getActivity());
            dots[i].setImageDrawable(
                    ContextCompat.getDrawable(this.getActivity(), R.drawable.nonactive_dots)
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
                ContextCompat.getDrawable(this.getActivity(), R.drawable.active_dots)
        );


        t.setText(" ");
        final Context cont=this.getActivity();
        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), SearchFragment.newInstance());

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });*/
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(cont, search.class);
                //startActivity(intent);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), SearchFragment.newInstance());

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        coverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                for(int i=0; i<dotscount;i++){

                    dots[i].setImageDrawable(
                            ContextCompat.getDrawable(cont, R.drawable.nonactive_dots)
                    );}
                dots[position].setImageDrawable( ContextCompat.getDrawable(cont, R.drawable.active_dots));

                if(position==0){t.setText(" ");
                    /*view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), SearchFragment.newInstance());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });*/
                    explore.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), SearchFragment.newInstance());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });}
                if(position==1){t.setText(" ");
                   /*view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), SearchFragment.newInstance());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });*/
                    explore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), SearchFragment.newInstance());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });}
                if(position==2){t.setText(" ");
                    /*view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), SearchFragment.newInstance());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });*/
                    explore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), SearchFragment.newInstance());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });}



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });



        CoverFlow c=view.findViewById(R.id.coverflow);

        c=coverFlow;





    }

    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;

        private FileInputStream fis;

        private Integer[] mImageIds = {
                com.example.cue.R.drawable.im3,
                com.example.cue.R.drawable.im2,
                com.example.cue.R.drawable.im1,


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
                        , (height + height / 2), Bitmap.Config.ARGB_8888);

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
                        Shader.TileMode.CLAMP);
                //Set the paint to use this shader (linear gradient)
                paint.setShader(shader);
                //Set the Transfer mode to be porter duff and destination in
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                //Draw a rectangle using the paint with our linear gradient
                canvas.drawRect(0, height, width,
                        bitmapWithReflection.getHeight() + reflectionGap, paint);

                ImageView imageView = new ImageView(mContext);
                imageView.setImageBitmap(bitmapWithReflection);
                imageView.setLayoutParams(new CoverFlow.LayoutParams(120, 120));
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
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
            i.setLayoutParams(new CoverFlow.LayoutParams(830, 930));//parametri per grandezza immagini
            i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

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

    @Override
    //Pressed return button - returns to the results menu
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    //your code
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(((ViewGroup) getView().getParent()).getId(), MainPageFragment.newInstance());

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
    }

}