package com.example.cue;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class RvCatAdapter extends RecyclerView.Adapter<RvCatAdapter.MyViewHolder> {

    String data[];
    Context context;
    public RvCatAdapter(Context ct, String cat[]){
        context = ct;
        data = cat;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cat_row, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.myCat.setText(data[position]);

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FragmentManager fragmentManager =activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.atfaq, fragmentQuestions.newInstance(data,data[position]));

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button plus;
        TextView myCat;
        ConstraintLayout mainLayoutCat;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            plus=itemView.findViewById(R.id.plusbutton);
            myCat = itemView.findViewById(R.id.categoryText);
            mainLayoutCat = itemView.findViewById(R.id.mainLayoutCat);
        }
    }
}
