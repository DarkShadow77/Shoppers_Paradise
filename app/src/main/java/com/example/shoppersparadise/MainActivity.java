 package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.shoppersparadise.Adapter.Featured;
import com.example.shoppersparadise.Adapter.FeaturedAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Animation left_anim, right_anim;

    private static int SPLASH_SCREEN = 2000;

    ImageView logo_1,logo_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        //Animations
        left_anim = AnimationUtils.loadAnimation(this,R.anim.left_animation);
        right_anim = AnimationUtils.loadAnimation(this,R.anim.right_animation);

        //Hooks
        logo_1 = findViewById(R.id.logo1);
        logo_2 = findViewById(R.id.logo2);

        logo_1.setAnimation(left_anim);
        logo_2.setAnimation(right_anim);


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this,After_splash.class);
            startActivity(intent);
            finish();
        },SPLASH_SCREEN);
    }


}