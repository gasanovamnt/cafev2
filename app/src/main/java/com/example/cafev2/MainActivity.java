package com.example.cafev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                if(userName.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.error_fields_empty,Toast.LENGTH_SHORT).show();
                }
                else {
                    launchMakeOrderActivity(userName);
                }
            }

        });
    }

    private void initViews(){
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
    }

    private void launchMakeOrderActivity(String userName){
        Intent intent = MakeOrderActivity.newIntent(this, userName);
        startActivity(intent);
    }
}