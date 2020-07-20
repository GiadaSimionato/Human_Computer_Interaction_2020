package com.example.cue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class TestPageFragment extends Fragment {

    int i = 0;
    String questionTitle[] = {"Would you like to advise organizations on how to meet their business goals?", "Would you like to analyze data using statistics?", "Would you like to create art for sale and exhibition?", "Would you like to direct the making of a movie?", "Wold you like to examine artifacts left behind by previous civilizations?", "Would you like to help elderly people complete their daily activities?", "Would you like to interpret results of medical tests?"};
    String answerA[] = {"Hate it", "Hate it", "Hate it", "Hate it", "Hate it", "Hate it", "Hate it"};
    String answerB[] = {"Dislike it", "Dislike it", "Dislike it", "Dislike it", "Dislike it", "Dislike it", "Dislike it"};
    String answerC[] = {"Like it", "Like it", "Like it", "Like it", "Like it", "Like it", "Like it"};
    String answerD[] = {"Love it", "Love it", "Love it", "Love it", "Love it", "Love it", "Love it"};
    int tot = questionTitle.length;

    TextView titleQuestion, numQuestion;
    Button ansA, ansB, ansC, ansD, backbtn, backtostart, showRes;
    ProgressBar proTest;

    public TestPageFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TestPageFragment newInstance() {
        TestPageFragment fragment = new TestPageFragment();
        Bundle args = new Bundle();

        fragment.setArguments(null);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_test_page_cue, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {



        titleQuestion = view.findViewById(R.id.txtQuestTV);
        numQuestion = view.findViewById(R.id.questTitleTV);
        ansA = view.findViewById(R.id.ansAbtn);
        ansB = view.findViewById(R.id.ansBbtn);
        ansC = view.findViewById(R.id.ansCbtn);
        ansD = view.findViewById(R.id.ansDbtn);
        proTest = view.findViewById(R.id.progressBarTest);
        backbtn = view.findViewById(R.id.backQuestbtn);
        backtostart = view.findViewById(R.id.backTostartbtn);
        showRes = view.findViewById(R.id.showResBtn);



        numQuestion.setText("Question " + (i+1));
        titleQuestion.setText(questionTitle[i]);
        ansA.setText(answerA[i]);
        ansB.setText(answerB[i]);
        ansC.setText(answerC[i]);
        ansD.setText(answerD[i]);
        proTest.setProgress((i/tot)*100);
        backtostart.setVisibility(View.GONE);
        backtostart.setEnabled(false);
        showRes.setVisibility(View.GONE);
        showRes.setEnabled(false);


        backtostart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i==0){
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), FAQFragment.newInstance());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    i--;
                    numQuestion.setText("Question " + (i + 1));
                    titleQuestion.setText(questionTitle[i]);
                    ansA.setText(answerA[i]);
                    ansB.setText(answerB[i]);
                    ansC.setText(answerC[i]);
                    ansD.setText(answerD[i]);
                    double p = (double) i / (double) tot;
                    proTest.setProgress((int) Math.round(p * 100));
                    showRes.setVisibility(View.GONE);
                    showRes.setEnabled(false);
                }

            }
        });

        backtostart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                numQuestion.setText("Question " + (i+1));
                titleQuestion.setText(questionTitle[i]);
                ansA.setText(answerA[i]);
                ansB.setText(answerB[i]);
                ansC.setText(answerC[i]);
                ansD.setText(answerD[i]);
                proTest.setProgress((i/tot)*100);
                backtostart.setVisibility(View.GONE);
                backtostart.setEnabled(false);
                showRes.setVisibility(View.GONE);
                showRes.setEnabled(false);
            }
        });

        showRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), ShowResFragment.newInstance());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), TestActivity.newInstance());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else{
                    i--;
                    numQuestion.setText("Question " + (i + 1));
                    titleQuestion.setText(questionTitle[i]);
                    ansA.setText(answerA[i]);
                    ansB.setText(answerB[i]);
                    ansC.setText(answerC[i]);
                    ansD.setText(answerD[i]);
                    double p = (double) i / (double) tot;
                    proTest.setProgress((int) Math.round(p * 100));
                    showRes.setVisibility(View.GONE);
                    showRes.setEnabled(false);
                }
            }
        });

        ansA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendQuest(v);
            }
        });

        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendQuest(v);
            }
        });
        ansC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendQuest(v);
            }
        });
        ansD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendQuest(v);
            }
        });

    }


    public void sendQuest(View view) {

        if(i<tot-1) {
            System.out.println("BUT");
            i++;
            numQuestion.setText("Question " + (i+1));
            titleQuestion.setText(questionTitle[i]);
            ansA.setText(answerA[i]);
            ansB.setText(answerB[i]);
            ansC.setText(answerC[i]);
            ansD.setText(answerD[i]);
            double p = (double) i / (double) tot;
            proTest.setProgress((int) Math.round(p * 100));
            System.out.println(i);
        }
        else{
            showRes.setVisibility(View.VISIBLE);
            showRes.setEnabled(true);
        }
        if(i>1 && backtostart.getVisibility()==View.GONE){
            backtostart.setVisibility(View.VISIBLE);
            backtostart.setEnabled(true);
        }
        if(i==0){
            backtostart.setVisibility(View.GONE);
            backtostart.setEnabled(false);
        }
    }

    public void goBack(View view) {

        if(i==0){
            Intent intent = new Intent(this.getActivity(), FAQFragment.class);
            this.startActivity(intent);
        }
        else{
            i--;
            numQuestion.setText("Question " + (i + 1));
            titleQuestion.setText(questionTitle[i]);
            ansA.setText(answerA[i]);
            ansB.setText(answerB[i]);
            ansC.setText(answerC[i]);
            ansD.setText(answerD[i]);
            double p = (double) i / (double) tot;
            proTest.setProgress((int) Math.round(p * 100));
            showRes.setVisibility(View.GONE);
            showRes.setEnabled(false);
        }
    }

    public void backToStart(View view) {

        i = 0;
        numQuestion.setText("Question " + (i+1));
        titleQuestion.setText(questionTitle[i]);
        ansA.setText(answerA[i]);
        ansB.setText(answerB[i]);
        ansC.setText(answerC[i]);
        ansD.setText(answerD[i]);
        proTest.setProgress((i/tot)*100);
        backtostart.setVisibility(View.GONE);
        backtostart.setEnabled(false);
        showRes.setVisibility(View.GONE);
        showRes.setEnabled(false);
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
                    fragmentTransaction.replace(((ViewGroup) getView().getParent()).getId(), CareerFragment.newInstance());

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
    }



    }





