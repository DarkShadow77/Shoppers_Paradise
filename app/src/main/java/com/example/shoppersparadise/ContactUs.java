package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class ContactUs extends AppCompatActivity {

    ImageView menu_show;
    MenuBuilder menuBuilder;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        menu_show = findViewById(R.id.account_icon);

        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.popup_menu, menuBuilder);

        menu_show.setOnClickListener(v -> {
            MenuPopupHelper optionMenu = new MenuPopupHelper(ContactUs.this,menuBuilder,v);
            optionMenu.setForceShowIcon(true);

            menuBuilder.setCallback(new MenuBuilder.Callback() {
                @Override
                public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.contact:
                            Intent intent = new Intent(ContactUs.this,ContactUs.class);
                            startActivity(intent);
                            return true;

                        case R.id.order_det:
                            Intent intent2 = new Intent(ContactUs.this,OrderDetails.class);
                            startActivity(intent2);
                            return true;

                        case R.id.edit_account:
                            Intent intent3 = new Intent(ContactUs.this,Profile.class);
                            startActivity(intent3);
                            return true;

                        case R.id.logout:
                            Intent intent4 = new Intent(ContactUs.this,SignIn.class);
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

        bottomNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactUs.this,Home.class);
                startActivity(intent);
            }
        });
    }
}