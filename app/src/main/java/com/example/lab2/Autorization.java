package com.example.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Autorization extends Activity {
    String myEmail = "Pasha123";
    String myPassword = "12345";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autorization);
        Toast.makeText(Autorization.this, "Create", Toast.LENGTH_SHORT).show();
        Button button_singIn = findViewById(R.id.button);
        EditText Email = findViewById(R.id.editTextTextEmailAddress);
        EditText Password = findViewById(R.id.editTextTextPassword);

        button_singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(/*Email.getText().toString().equals(myEmail) && Password.getText().toString().equals(myPassword)*/
                    true)
                {
                    Intent intent = new Intent(Autorization.this,MyList.class);
                    intent.putExtra("hello", "Hello from FirstActivity");
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(Autorization.this, "Start", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Autorization.this, "Resume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(Autorization.this, "Pause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(Autorization.this, "Stop", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(Autorization.this, "Destroy", Toast.LENGTH_SHORT).show();


    }

}
