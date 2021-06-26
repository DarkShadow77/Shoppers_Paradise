package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.shoppersparadise.Adapter.Featured;
import com.example.shoppersparadise.Adapter.FeaturedAdapter;
import com.example.shoppersparadise.Adapter.OrderDetail;
import com.example.shoppersparadise.Adapter.OrderDetailsAdapter;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {
    RecyclerView orderRecycler;
    RecyclerView.Adapter adapter;

    ImageView menu_show;
    MenuBuilder menuBuilder;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        orderRecycler = findViewById(R.id.order_recycler);
        orderRecycler();

        menu_show = findViewById(R.id.account_icon);

        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.popup_menu, menuBuilder);

        menu_show.setOnClickListener(v -> {
            MenuPopupHelper optionMenu = new MenuPopupHelper(OrderDetails.this,menuBuilder,v);
            optionMenu.setForceShowIcon(true);

            menuBuilder.setCallback(new MenuBuilder.Callback() {
                @Override
                public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.contact:
                            Intent intent = new Intent(OrderDetails.this,ContactUs.class);
                            startActivity(intent);
                            return true;

                        case R.id.feedback:
                            Intent intent1 = new Intent(OrderDetails.this,FeedbackPage.class);
                            startActivity(intent1);
                            return true;

                        case R.id.order_det:
                            Intent intent2 = new Intent(OrderDetails.this,OrderDetails.class);
                            startActivity(intent2);
                            return true;

                        case R.id.edit_account:
                            Intent intent3 = new Intent(OrderDetails.this,Profile.class);
                            startActivity(intent3);
                            return true;

                        case R.id.logout:
                            Intent intent4 = new Intent(OrderDetails.this,SignIn.class);
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
                Intent intent = new Intent(OrderDetails.this,Home.class);
                startActivity(intent);
            }
        });

    }


    private void orderRecycler() {

        orderRecycler.setHasFixedSize(true);
        orderRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        ArrayList<OrderDetail> order = new ArrayList<>();

        order.add(new OrderDetail(R.drawable.men1,"Pampers Promo Twin Pack","Size: Giant Pack Pack","$ 150.00","Quantity: 2"));
        order.add(new OrderDetail(R.drawable.men2,"Jacket","Size: Large","$ 45.00","Quantity: 1"));

        adapter = new OrderDetailsAdapter(order);
        orderRecycler.setAdapter(adapter);

    }
}