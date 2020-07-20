package com.example.cue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeerAdapter extends RecyclerView.Adapter<PeerAdapter.PeerVH> {

    private static final String TAG = "PeerAdapter";
    List<Peer> peersList;

    public PeerAdapter(List<Peer> peersList) {
        //this.clickListner=listner;
        this.peersList = peersList;
    }

    @NonNull
    @Override
    public PeerAdapter.PeerVH onCreateViewHolder (@NonNull ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.peer_row, parent, false);
        return new PeerAdapter.PeerVH(view);
    }




    @Override
    public void onBindViewHolder(@NonNull PeerAdapter.PeerVH holder, int position) {
        Peer peer = peersList.get(position);
        holder.peerTextView.setText(peer.getDetails());
        holder.peerImageView.setImageDrawable(peer.getImg());
        holder.citImageView.setImageDrawable(peer.getCit());
        holder.namePeerTextView.setText(peer.getName());
        holder.peerRatingBar.setRating((float)peer.getRating());
        holder.peerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.peers_, ChatPeersFragment.newInstance());

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return peersList.size();
    }

    class PeerVH extends RecyclerView.ViewHolder {

        private static final String TAG = "PeerVH";

        TextView peerTextView, namePeerTextView;
        ImageView peerImageView, citImageView;
        Button peerBtn;
        RatingBar peerRatingBar;

        public PeerVH(@NonNull final View itemView) {
            super(itemView);
            peerTextView = itemView.findViewById(R.id.peerTextView);
            peerImageView = itemView.findViewById(R.id.peerImageView);
            citImageView = itemView.findViewById(R.id.citImageView);
            peerBtn = itemView.findViewById(R.id.peerBtn);
            namePeerTextView = itemView.findViewById(R.id.namePeerTextView);
            peerRatingBar = itemView.findViewById(R.id.peerRatingBar);

            peerBtn.setOnClickListener(new View.OnClickListener() {    // Added for button
                @Override
                public void onClick(View v) {
                    // Insert here Intent to open chat activity.
                }
            });

        }



    }

    public interface RecyclerViewClickListener {

        void onClick(View view, int position);
    }

}




