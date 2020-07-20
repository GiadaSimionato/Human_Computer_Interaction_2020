package com.example.cue;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class fragmentQuestions extends Fragment {

    TextView mainTextQuestion;
    Button mainButtonQuestion,back;
    RecyclerView recyclerViewQuest;

    String data;
    String quest[];


    public fragmentQuestions() {
        // Required empty public constructor
    }

    public static fragmentQuestions newInstance(String[] dat, String da) {
        fragmentQuestions fragment = new fragmentQuestions();
        Bundle args = new Bundle();
        args.putStringArray(null,dat);
        args.putString(null,da);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_questions, null, false);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_questions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        back=view.findViewById(R.id.btnBackToCat);
        recyclerViewQuest = view.findViewById(R.id.rvQuest);
        quest = getResources().getStringArray(R.array.faqsquest);

        RvQuesAdapter quesAdapter = new RvQuesAdapter(this.getActivity(), quest);
        recyclerViewQuest.setAdapter(quesAdapter);
        recyclerViewQuest.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), FAQFragment.newInstance());

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    private void getData(){
        if(getActivity().getIntent().hasExtra("data")){
            data = getActivity().getIntent().getStringExtra("data");
        }else{
            Toast.makeText(this.getActivity(), "No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        mainTextQuestion.setText(data);
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
                    fragmentTransaction.replace(((ViewGroup) getView().getParent()).getId(), FAQFragment.newInstance());

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
    }



}
