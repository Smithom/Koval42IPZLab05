package com.example.koval42ipzlab04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName =(EditText)findViewById(R.id.editTextName);
        editTextLastName =(EditText)findViewById(R.id.editTextLastName);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ActivityChoice.class);

        String name = editTextName.getText().toString();
        String lastName = editTextLastName.getText().toString();

        intent.putExtra("name", name);
        intent.putExtra("lastName", lastName);
        startActivity(intent);

    }
}
