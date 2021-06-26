package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class After_splash extends AppCompatActivity {

    //Variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView text1, text2, text3;
    Button signUp, signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_after_splash);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.splash_img);
        text1 = findViewById(R.id.splash_text1);
        text2 = findViewById(R.id.splash_text2);
        text3 = findViewById(R.id.splash_text3);
        signUp = findViewById(R.id.splash_signUp);
        signIn = findViewById(R.id.splash_signIn);

        image.setAnimation(topAnim);
        text1.setAnimation(topAnim);
        text2.setAnimation(topAnim);
        text3.setAnimation(bottomAnim);
        signUp.setAnimation(bottomAnim);
        signIn.setAnimation(bottomAnim);

        signUp.setOnClickListener(v -> {
            Intent intent1 = new Intent(After_splash.this,SignUp.class);
            startActivity(intent1);
        });

        signIn.setOnClickListener(v -> {
            Intent intent = new Intent(After_splash.this,SignIn.class);
            startActivity(intent);
        });


    }
}