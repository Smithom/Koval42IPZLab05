package com.example.koval42ipzlab04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityChoice extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;

    RadioButton rb1;
    RadioButton rb2;

    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;
    String prof;
    String name;
    String lastName;
    String[] data = {"JavaScript", "Java", "Python", "C#", "С++"};
    int idSpiner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setSelection(2);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
              idSpiner = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        Bundle arguments = getIntent().getExtras();
         name = arguments.get("name").toString();
         lastName = arguments.get("lastName").toString();

        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);

        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);

        ch1 = (CheckBox) findViewById(R.id.checkBox);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        ch3 = (CheckBox) findViewById(R.id.checkBox3);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        text1.setText("Яку професію ти обираєш, "+name);




        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Ничего не выбрано",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton1:
                        Toast.makeText(getApplicationContext(), "Програміст",
                                Toast.LENGTH_SHORT).show();
                        prof = "Програміст";
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(getApplicationContext(), "Інформатик",
                                Toast.LENGTH_SHORT).show();
                        prof = "Інформатик";
                        break;

                }
            }
        });
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, FinalActivity.class);

        intent.putExtra("prof", prof);
        intent.putExtra("name", name);
        intent.putExtra("lastName", lastName);
        if(ch1.isChecked()) intent.putExtra("ch1", 1);
        else intent.putExtra("ch1", 0);
        if(ch2.isChecked()) intent.putExtra("ch2", 1);
        else intent.putExtra("ch2", 0);
        if(ch3.isChecked()) intent.putExtra("ch3", 1);
        else intent.putExtra("ch3", 0);
        intent.putExtra("program", data[idSpiner]);


        startActivity(intent);

    }
}