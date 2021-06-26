package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.shoppersparadise.Adapter.Featured;
import com.example.shoppersparadise.Adapter.FeaturedAdapter;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RecyclerView featuredRecycler, categoryRecycler, top_Deals_Recycler;
    RecyclerView.Adapter adapter;
    Dialog myDialog;

    ImageView menu_show;
    MenuBuilder menuBuilder;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myDialog = new Dialog(this);

        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();

        menu_show = findViewById(R.id.account_icon);

        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.popup_menu, menuBuilder);

        menu_show.setOnClickListener(v -> {
            MenuPopupHelper optionMenu = new MenuPopupHelper(Home.this,menuBuilder,v);
            optionMenu.setForceShowIcon(true);

            menuBuilder.setCallback(new MenuBuilder.Callback() {
                @Override
                public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.contact:
                            Intent intent = new Intent(Home.this,ContactUs.class);
                            startActivity(intent);
                            return true;

                        case R.id.feedback:
                            Intent intent1 = new Intent(Home.this,FeedbackPage.class);
                            startActivity(intent1);
                            return true;

                        case R.id.order_det:
                            Intent intent2 = new Intent(Home.this,OrderDetails.class);
                            startActivity(intent2);
                            return true;

                        case R.id.edit_account:
                            Intent intent3 = new Intent(Home.this,Profile.class);
                            startActivity(intent3);
                            return true;

                        case R.id.logout:
                            Intent intent4 = new Intent(Home.this,SignIn.class);
                            startActivity(intent4);
                            return true;

                        default:
                            return false;
                    }
                }

                @Override
                public void onMenuModeChange(MenuBuilder menu) {
                    //empty
                }
            });

            optionMenu.show();
        });

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottom_bar);

        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_home));
        bottomNavigation.show(1,true);

        bottomNavigation.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Home.class)));

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new GridLayoutManager(this,2));

        ArrayList<Featured> featuredLocation = new ArrayList<>();

        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));
        featuredLocation.add(new Featured(R.drawable.men1));
        featuredLocation.add(new Featured(R.drawable.men2));
        featuredLocation.add(new Featured(R.drawable.men3));

        adapter = new FeaturedAdapter(featuredLocation);
        featuredRecycler.setAdapter(adapter);

    }

    public void Product_Details_Popup(View v) {
        ImageView close;
        myDialog.setContentView(R.layout.activity_product__page);
        close = myDialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}