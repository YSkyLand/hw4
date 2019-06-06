package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class showActivity extends AppCompatActivity {

    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        textView3 = findViewById(R.id.textView3);
        showResults();
    }

    private void showResults(){
        NumberFormat numberFormat = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();

        int programming = bundle.getInt("programming");
        int dataStructure = bundle.getInt("dataStructure");
        int algorithm = bundle.getInt("algorithm");

        int sum = programming + dataStructure + algorithm;
        double average = sum/3.0;

        String text = "programming = " + programming + "\ndataStructure = " + dataStructure + "\nalgorithm = " + algorithm + "\nsum = " + sum + "\naverage = " + numberFormat.format(average);
        textView3.setText(text);
        alert(average);
    }

    private void alert(double average){
        String messager = new String();
        String title = new String();
        int picture = 0;

        if (average == 100){
            messager = "{[(100)]}";
            title = "pass";
            picture = R.drawable.oo;
        }

        else if (average >= 60){
            messager = "PASS la~~~~~";
            title = "pass";
            picture = R.drawable.oo;
        }

        else{
            messager = "QAQ";
            title = "fail";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(messager);
        builder.setTitle(title);
        builder.setIcon(picture);
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel",null);
        builder.setNeutralButton("Nothing",null);

        builder.show();
    }

    public void onBACKClick(View view){
        finish();
    }

}