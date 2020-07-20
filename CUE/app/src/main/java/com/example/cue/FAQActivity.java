package com.example.cue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FAQActivity extends AppCompatActivity {

    RecyclerView recViewCategory;
    String cat[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        recViewCategory = findViewById(R.id.viewCategory);
        cat = getResources().getStringArray(R.array.faqs);

        RvCatAdapter catAdapter = new RvCatAdapter(this, cat);
        recViewCategory.setAdapter(catAdapter);
        recViewCategory.setLayoutManager(new LinearLayoutManager(this));
    }

    public void gotoquest(View view){
        Intent intent = new Intent(this, fragmentQuestions.class);
        this.startActivity(intent);
    }
}
