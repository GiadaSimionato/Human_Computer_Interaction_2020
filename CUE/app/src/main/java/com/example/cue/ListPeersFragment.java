package com.example.cue;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListPeersFragment  extends Fragment {
    RecyclerView recyclerViewPeers;
    List<Peer> peersList;


    public static ListPeersFragment newInstance() {
        ListPeersFragment fragment = new ListPeersFragment();

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
        View view = inflater.inflate(R.layout.activity_peers, null, false);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_peers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewPeers = view.findViewById(R.id.recyclerViewPeers);
        recyclerViewPeers.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false));
        initData();
        initRecyclerView();
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

                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(((ViewGroup) getView().getParent()).getId(), PeersFragment.newInstance());

                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        // code back
                        return true;
                    }
                    return false;
                }
            });
        }




    private void initRecyclerView(){

        PeerAdapter peerAdapter = new PeerAdapter(peersList);
        recyclerViewPeers.setAdapter(peerAdapter);



    }

    private void initData(){
        peersList = new ArrayList<>();
        peersList.add(new Peer(getResources().getDrawable(R.drawable.stu4), getResources().getDrawable(R.drawable.cit), "Hello! I'm a student of the second year of the Master in Engineering in Computer Science at University La Sapienza of Rome. I'm 24 and I'm from Rome. I love cooking and studying. ", "Jessica Fletcher", 5));
        peersList.add(new Peer(getResources().getDrawable(R.drawable.stu5), getResources().getDrawable(R.drawable.cit), "Hi! How are you? I'm a student of the first year of the Master in Engineering in Computer Science at University La Sapienza of Rome. I'm 23 and I'm from Naples. I love playing basketball and riding a bike.", "Jack McConnor", 4.5));
        peersList.add(new Peer(getResources().getDrawable(R.drawable.stu2), getResources().getDrawable(R.drawable.cit), "Hi guys! I'm an Erasmus student from Spain, I've been a student of this course for the second semester of the first year! I'm 23 and I'm from Madrid. I love dancing and going to the beach.", "Alejandra Ramirez",4));
        peersList.add(new Peer(getResources().getDrawable(R.drawable.stu1), getResources().getDrawable(R.drawable.cit), "Hello!! I'm a student of the first year of the Master in Engineering in Computer Science at University La Sapienza of Rome. I'm 25 and I'm from Turin. I love exploring Rome and walking with my dog. ", "Joseph Smith", 3.5));
        peersList.add(new Peer(getResources().getDrawable(R.drawable.stu3), getResources().getDrawable(R.drawable.cit), "Hello, I'm a part-time student of the second year of the Master in Engineering in Computer Science at University La Sapienza of Rome. I'm 31 and I'm from Cagliari. I love programming and watching tv series.", "Davide Collaneri", 3));
        peersList.add(new Peer(getResources().getDrawable(R.drawable.stu4), getResources().getDrawable(R.drawable.cit), "Hello! I'm a student of the second year of the Master in Engineering in Computer Science at University La Sapienza of Rome. I'm 24 and I'm from Rome. I love cooking and studying. ", "Giulia De Rossi", 2.5));
        peersList.add(new Peer(getResources().getDrawable(R.drawable.stu5), getResources().getDrawable(R.drawable.cit), "Hi! How are you? I'm a student of the first year of the Master in Engineering in Computer Science at University La Sapienza of Rome. I'm 23 and I'm from Naples. I love playing basketball and riding a bike.", "Stefano Ferrari", 2));
        peersList.add(new Peer(getResources().getDrawable(R.drawable.stu2), getResources().getDrawable(R.drawable.cit), "Hi guys! I'm an Erasmus student from Spain, I've been a student of this course for the second semester of the first year! I'm 23 and I'm from Madrid. I love dancing and going to the beach.", "Santana Diaz", 1.5));
        peersList.add(new Peer(getResources().getDrawable(R.drawable.stu1), getResources().getDrawable(R.drawable.cit), "Hello!! I'm a student of the first year of the Master in Engineering in Computer Science at University La Sapienza of Rome. I'm 25 and I'm from Turin. I love exploring Rome and walking with my dog.", "Noah DeVitto", 1));

    }

    public void editSearch(View view) {
        // Inserisci qui l'Intent per tornare indietro e modificare la ricerca
    }
}
