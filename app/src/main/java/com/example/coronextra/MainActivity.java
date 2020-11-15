package com.example.coronextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// Toast - pop up message
// ToString grazina grazina zinute is objekto
// final sukurti pastovu kintamaji

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username=findViewById(R.id.username);
        final EditText email=findViewById(R.id.email);
        final EditText password=findViewById(R.id.password);

        Button register = findViewById(R.id.register);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, username.getText().toString(), Toast.LENGTH_SHORT).show();
                username.setError(null);

                if(!validation.isValidUsername(username.getText().toString())) {
                    username.setError("Error! Wrong username");
                    username.requestFocus();
                } else if(!validation.isValidPassword(password.getText().toString())) {
                    username.setError("Error! Wrong password");
                    username.requestFocus();
                } else { // jeigu username neteisingas
                    Intent goToSearchActivity = new Intent(MainActivity.this, Search.class);
                    startActivity(goToSearchActivity);
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregister();
            }
        });
    }
    public void openregister (){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}