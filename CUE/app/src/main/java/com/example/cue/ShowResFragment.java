package com.example.cue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ShowResFragment extends Fragment {

    Button gooth,rep,sear;
    public ShowResFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ShowResFragment newInstance() {
        ShowResFragment fragment = new ShowResFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);*/
        fragment.setArguments(null);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.activity_show_result, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        gooth = view.findViewById(R.id.showmorebtn);
        rep = view.findViewById(R.id.againTestbtn);
        sear= view.findViewById(R.id.searchtestbtn);
        gooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), otherTests.newInstance());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(),TestPageFragment.newInstance());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        sear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(),TestPageFragment.newInstance());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    }
