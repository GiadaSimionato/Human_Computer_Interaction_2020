package com.example.cue;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FAQFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FAQFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Button got;
    RecyclerView recViewCategory;
    String cat[];

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FAQFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FAQFragment newInstance() {
        FAQFragment fragment = new FAQFragment();
        Bundle args = new Bundle();
        fragment.setArguments(null);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_faq, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recViewCategory = view.findViewById(R.id.viewCategory);
        cat = getResources().getStringArray(R.array.faqs);
        //got=view.findViewById(R.id.plusbutton);
        RvCatAdapter catAdapter = new RvCatAdapter(this.getActivity(), cat);
        recViewCategory.setAdapter(catAdapter);
        recViewCategory.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }

    @Override
    public void onResume(){
        super.onResume();

        this.getView().setFocusableInTouchMode(true);
        this.getView().requestFocus();
        this.getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {


                    // code back
                    return true;
                }
                return false;
            }
        });
    }

}