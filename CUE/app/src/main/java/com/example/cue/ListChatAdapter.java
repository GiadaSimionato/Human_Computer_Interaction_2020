package com.example.cue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListChatAdapter extends RecyclerView.Adapter<ListChatAdapter.ChatVH> {
    private static final String TAG = "ChatAdapter";
    List<Chat> chatList;

    public ListChatAdapter(List<Chat> chatList){ this.chatList = chatList;}

    @NonNull
    @Override
    public ListChatAdapter.ChatVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_row, parent, false);
        return new ListChatAdapter.ChatVH(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ListChatAdapter.ChatVH holder, int position){
        Chat chat = chatList.get(position);
        holder.nameTextView.setText(chat.getName());
        holder.descTextView.setText(chat.getCourse());
        holder.uniTextView.setText(chat.getUni());
        holder.locTextView.setText(chat.getData());
        holder.expandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.chat_, ChatPeersFragment1.newInstance());

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public int getItemCount(){return chatList.size();}

    class ChatVH extends RecyclerView.ViewHolder{
        private static final String TAG="ChatVH";
        TextView nameTextView, descTextView, uniTextView, locTextView, topTextView, disTextView, scholarTextView;
        ConstraintLayout expandableLayoutC;
        // [EDIT]
        Button expandButton, starButton;
        ImageView topImageView, disImageView, scholarImageView;

        public ChatVH(@NonNull final View itemView){
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            descTextView = itemView.findViewById(R.id.descTextView);
            expandableLayoutC = itemView.findViewById(R.id.expandableLayoutC);
            // [EDIT]
            expandButton = itemView.findViewById(R.id.expandButton);
            uniTextView = itemView.findViewById(R.id.uniTextView);
            locTextView = itemView.findViewById(R.id.locTextView);
            topTextView = itemView.findViewById(R.id.topTextView);
            disTextView = itemView.findViewById(R.id.disTextView);
            scholarTextView = itemView.findViewById(R.id.scholarTextView);
            starButton = itemView.findViewById(R.id.starButton);

            topImageView = itemView.findViewById(R.id.topImageView);
            disImageView = itemView.findViewById(R.id.disImageView);
            scholarImageView = itemView.findViewById(R.id.scholarImageView);

            expandButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Chat chat = chatList.get(getAdapterPosition());

                    chat.setExpanded(!chat.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });





        }
    }
}
