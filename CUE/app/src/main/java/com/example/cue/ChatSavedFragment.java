package com.example.cue;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatSavedFragment extends Fragment {
    RecyclerView recyclerViewC;
    TextView nresTextView;
    List<Chat> chatList;
    public ChatSavedFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ChatSavedFragment newInstance() {
        ChatSavedFragment fragment = new ChatSavedFragment();

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.chat_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        recyclerViewC = view.findViewById(R.id.recyclerViewC);
        nresTextView = view.findViewById(R.id.nresTextView);

        initData();
        initRecyclerView();
        //String message = chatList.size() + " results for Engineering in Computer Science course";
        //nresTextView.setText(message);
    }

    public void editSearch(View view) {
        // Put HERE Intent to start new activity (Edit Search pressed)
    }

    private void initRecyclerView() {
        ListChatAdapter chatAdapter = new ListChatAdapter(chatList);
        recyclerViewC.setAdapter(chatAdapter);
    }

    private void initData() {
        chatList = new ArrayList<>();

        chatList.add(new Chat("Alejandra Ramirez", "Sapienza","Engineering in Computer Science","22/07/2020",false));
        // [EDIT]
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

                    return true;
                }
                return false;
            }
        });
    }



}

