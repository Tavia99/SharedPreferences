package com.example.kuis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText user, pass;
    Button mBtn_login;

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        user = findViewById(R.id.edit_user);
        mBtn_login = findViewById(R.id.btn_login);
        pass = findViewById(R.id.edit_pass);
        sharedPref = new SharedPref(this);


        login();
    }


    public void login() {
        mBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = user.getText().toString();
                String e = pass.getText().toString();
                if (n.equals("admin") && e.equals("admin123")){
                    Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                    sharedPref.setName(SharedPref.SP_NAMA, n);

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Username dan Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
