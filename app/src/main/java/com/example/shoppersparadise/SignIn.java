package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppersparadise.Database.DatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

public class SignIn extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    TextInputEditText email_field, password_field;
    Button login_btn;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        databaseHelper = new DatabaseHelper(this);
        email_field = findViewById(R.id.email);
        password_field = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);

        back = findViewById(R.id.back_button);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(SignIn.this,After_splash.class);
            startActivity(intent);
        });

        login_btn.setOnClickListener(v ->
        {
            String user_name = email_field.getText().toString();
            String password = password_field.getText().toString();

            Boolean check_login = databaseHelper.CheckLogin(user_name, password);

            if (user_name.equals("") || password.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter All Fields", Toast.LENGTH_SHORT).show();
            }

            if (check_login == true) {
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignIn.this, Home.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}