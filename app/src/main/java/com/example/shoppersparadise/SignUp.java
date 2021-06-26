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

public class SignUp extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    ImageView back;
    TextInputEditText name_field, email_field, password_field, confirm_password_field;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        databaseHelper = new DatabaseHelper(this);
        name_field = findViewById(R.id.signup_name);
        email_field = findViewById(R.id.signup_email);
        password_field = findViewById(R.id.signup_pass);
        confirm_password_field = findViewById(R.id.signup_cpass);

        back = findViewById(R.id.back_button);
        register = findViewById(R.id.create_btn);


        back.setOnClickListener(v -> {
            Intent intent = new Intent(SignUp.this,SignIn.class);
            startActivity(intent);
        });

        register.setOnClickListener(v ->
        {
            String username = name_field.getText().toString();
            String email = email_field.getText().toString();
            String password = password_field.getText().toString();
            String confirm_password = confirm_password_field.getText().toString();

            if(username.equals("")||email.equals("")||password.equals("")||confirm_password.equals("")){
                Toast.makeText(getApplicationContext(), "Please Enter All Fields", Toast.LENGTH_SHORT).show();
            }
            else{
                if(password.equals(confirm_password))
                {
                    Boolean  check_username = databaseHelper.CheckUsername(email);
                    if(check_username==true){
                        Boolean insert = databaseHelper.Insert(username,email,password);
                        if(insert == true){
                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                            name_field.setText("");
                            email_field.setText("");
                            password_field.setText("");
                            Intent intent = new Intent(SignUp.this, SignIn.class);
                            startActivity(intent);
                            finish();
                        }

                    } else{
                        Toast.makeText(getApplicationContext(), "Registration Not Successful, Username Already Taken", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Password Does Not Match", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}