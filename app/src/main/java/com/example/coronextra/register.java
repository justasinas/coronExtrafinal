package com.example.coronextra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText username=findViewById(R.id.username);
        final EditText email=findViewById(R.id.email);
        final EditText password=findViewById(R.id.password);
        Button registruoju=findViewById(R.id.registration);

        registruoju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setError(null);
                if (!validation.isValidUsername(username.getText().toString())){//jeigu nevalidus
                    username.setError("Error! Wrong username");
                    username.requestFocus();
                }
                else if (!validation.isValidPassword(password.getText().toString())){
                    password.setError("Error! Wrong password");
                    password.requestFocus();

                }
                else if (!validation.isValidEmail(email.getText().toString())) {
                    email.setError("Error! Wrong email");
                    email.requestFocus();
                }
                else{//bus vykdomas kodas kai praeis sekmingai validacija
                    Intent goToLoginActivity = new Intent(register.this, MainActivity.class);
                    startActivity(goToLoginActivity);
                }
            }//baigiasi funkcija
        });//kad veiktu mygtukas kai paspaudi VIRSUJE
    }
}