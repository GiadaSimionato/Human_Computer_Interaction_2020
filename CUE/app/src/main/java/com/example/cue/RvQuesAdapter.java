package com.example.cue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvQuesAdapter extends RecyclerView.Adapter<RvQuesAdapter.MyViewHolderQ> {
    String dataQ[];
    Context context;
    public RvQuesAdapter(Context ct, String quest[]){
        context = ct;
        dataQ = quest;
    }
    @NonNull
    @Override
    public MyViewHolderQ onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.quest_row, parent, false);
        return new MyViewHolderQ(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderQ holder, int position) {
        holder.TextQuest.setText(dataQ[position]);
    }

    @Override
    public int getItemCount() {
        return dataQ.length;
    }

    public class MyViewHolderQ extends RecyclerView.ViewHolder{
        TextView TextQuest;

        public MyViewHolderQ(@NonNull View itemView) {
            super(itemView);
            TextQuest = itemView.findViewById(R.id.rowQtxt);
        }
    }
}
