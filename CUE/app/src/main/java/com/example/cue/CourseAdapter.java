package com.example.cue;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseVH> {

    private static final String TAG = "CourseAdapter";
    List<Course> courseList;

    public CourseAdapter(List<Course> courseList){ this.courseList = courseList;}

    @NonNull
    @Override
    public CourseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_row, parent, false);

        return new CourseVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseVH holder, int position){
        Course course = courseList.get(position);
        holder.nameTextView.setText(course.getName());
        holder.descTextView.setText(course.getDescription());
        holder.uniTextView.setText(course.getUni());
        holder.locTextView.setText(course.getLocation());

        boolean isTop = courseList.get(position).isTopuni();
        holder.topTextView.setVisibility(isTop ? View.VISIBLE : View.GONE);
        holder.topImageView.setVisibility(isTop ? View.VISIBLE : View.GONE);

        boolean isDis = courseList.get(position).isDis();
        holder.disTextView.setVisibility(isDis ? View.VISIBLE : View.GONE);
        holder.disImageView.setVisibility(isDis ? View.VISIBLE : View.GONE);

        boolean isScholar = courseList.get(position).isScholar();
        holder.scholarImageView.setVisibility(isScholar ? View.VISIBLE : View.GONE);
        holder.scholarTextView.setVisibility(isScholar ? View.VISIBLE : View.GONE);

        boolean isSaved = courseList.get(position).isSaved();
        holder.save.setText(isSaved?"Saved":"Save");
        holder.starButton.setBackgroundResource(isSaved ? R.drawable.ic_starfull_foreground : R.drawable.ic_starborder_foreground);

        boolean isExpanded = courseList.get(position).isExpanded();
        holder.expandButton.setText(isExpanded? "-" : "+");
        holder.expandableLayoutC.setVisibility(isExpanded ? View.VISIBLE : View.GONE);



        // [EDIT]
    }

    @Override
    public int getItemCount(){return courseList.size();}

    class CourseVH extends RecyclerView.ViewHolder{
        private static final String TAG="CourseVH";
        TextView nameTextView, descTextView, uniTextView, locTextView, topTextView, disTextView, scholarTextView,save;
        ConstraintLayout expandableLayoutC;
        // [EDIT]
        Button expandButton, starButton;
        ImageView topImageView, disImageView, scholarImageView;

        public CourseVH(@NonNull final View itemView){
            super(itemView);
            save=itemView.findViewById(R.id.textView15);
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
                    Course course = courseList.get(getAdapterPosition());

                    course.setExpanded(!course.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            starButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Course course = courseList.get(getAdapterPosition());

                    course.setSaved(!course.isSaved());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            /*nameTextView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Course course = courseList.get(getAdapterPosition());
                    course.setExpanded(!course.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });*/

        }
    }
}
