package com.example.cue;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatPeersFragment extends Fragment {
    List<MessageChatModel> messageChatModelList =  new ArrayList<>();
    RecyclerView recyclerView;
    MessageChatAdapter adapter ;

    EditText messageET;
    ImageView sendBtn;

    public  ChatPeersFragment(){

    }

    public static ChatPeersFragment newInstance() {
        ChatPeersFragment fragment = new ChatPeersFragment();

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
        View view = inflater.inflate(R.layout.activity_chat, null, false);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        messageET = (EditText) view.findViewById(R.id.messageET);
        sendBtn = (ImageView) view.findViewById(R.id.sendBtn);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        MessageChatModel model1 = new MessageChatModel(
                "Hello. I'm sorry to bother you,I would like to ask something. May I?",
                "10:00 PM",
                0
        );
        MessageChatModel model2 = new MessageChatModel(
                "Hi! Nice to meet you! I'm Alexandra,Sure, you can ask me whatever you want, I'm here for you!",
                "10:00 PM",
                1
        );
        MessageChatModel model3 = new MessageChatModel(
                "Sweet! So, what do you wanna do today?",
                "10:00 PM",
                0
        );
        MessageChatModel model4 = new MessageChatModel(
                "Nah, I dunno. Play soccer.. or learn more coding perhaps?",
                "10:00 PM",
                1
        );


        messageChatModelList.add(model1);
        messageChatModelList.add(model2);
        //messageChatModelList.add(model3);
        //messageChatModelList.add(model4);
        //messageChatModelList.add(model1);
        //messageChatModelList.add(model2);
        //messageChatModelList.add(model3);
        //messageChatModelList.add(model4);
        // messageChatModelList.add(model1);
        //messageChatModelList.add(model2);
        //messageChatModelList.add(model3);
        //messageChatModelList.add(model4);

        recyclerView.smoothScrollToPosition(messageChatModelList.size());
        adapter = new MessageChatAdapter(messageChatModelList, this.getActivity());
        recyclerView.setAdapter(adapter);

//ho toccato da qui
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = messageET.getText().toString();

                MessageChatModel model = new MessageChatModel(
                        msg,
                        "10:00 PM",
                        0
                );
                messageChatModelList.add(model);
                recyclerView.smoothScrollToPosition(messageChatModelList.size());
                adapter.notifyDataSetChanged();
                messageET.setText("");


            }
        });
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
                        fragmentTransaction.replace(((ViewGroup) getView().getParent()).getId(), ListPeersFragment.newInstance());

                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                    }
                    return false;
                }
            });
        }





    }

