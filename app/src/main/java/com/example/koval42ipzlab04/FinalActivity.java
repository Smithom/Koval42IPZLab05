package com.example.koval42ipzlab04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Bundle arguments = getIntent().getExtras();
        String prof = arguments.get("prof").toString();
        String name = arguments.get("name").toString();
        String lastName = arguments.get("lastName").toString();
        String ch1 = arguments.get("ch1").toString();
        String ch2 = arguments.get("ch2").toString();
        String ch3 = arguments.get("ch3").toString();
        String program = arguments.get("program").toString();
        String act ="";
        if (ch1=="1") act = "лекції, ";
        if (ch2=="1") act = act  +  "практичні, ";
        if (ch3=="1") act = "лабораторні, ";
        if (act == "") act = " мінімуму зусиль ";
act = act +"ПРОГРАМУ ВИКОНАНО";
        TextView valText = (TextView)findViewById(R.id.textView);

        valText.setText("Студент: "+lastName+" "+name+" обрав спеціальність: "+prof+" Обрав активності: "+program + " .А також бажає виконувати"+act);
    }
}
