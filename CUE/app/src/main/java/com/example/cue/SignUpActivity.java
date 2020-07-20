package com.example.cue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {
    private Button signup;
    //private Button google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       // google = (Button) findViewById(R.id.google);
        signup = (Button) findViewById(R.id.login); //non so perchè non mi fa cambiare il nome

       /*google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleActivity();
            }
        });*/
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });
    }
   /*public void openGoogleActivity() {
        Intent intent = new Intent(this, GoogleActivity.class);
        startActivity(intent);
    }*/

    public void openSignUpActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}