package com.example.cue;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class TextScolFra extends Fragment {

    public TextScolFra() {
        // Required empty public constructor
    }

    public static TextScolFra newInstance() {
        TextScolFra fragment = new TextScolFra();
        Bundle args = new Bundle();
        fragment.setArguments(null);
        return fragment;
    }




    View v;
    CoverFlow coverFlow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final Context cont=this.getContext();
        View view = inflater.inflate(R.layout.activity_statereg, null, false);
        v=view;



        return inflater.inflate(R.layout.activity_statereg, container, false);


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
                    fragmentTransaction.replace(((ViewGroup) getView().getParent()).getId(),StateFragment.newInstance());

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    
                    return true;
                }
                return false;
            }
        });
    }

    }


