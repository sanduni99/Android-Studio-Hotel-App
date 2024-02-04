package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RoominfoActivity extends AppCompatActivity {
    Calendar myCalender;
    EditText editText,edCheckout;
    EditText editTextText3,editTextTextEmailAddress,editTextPhone,editTextNumber;
    Spinner spinnerType;
    Button btnPreview;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();


        editTextText3 = findViewById(R.id.editTextText3);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextPhone =findViewById(R.id.editTextPhone);
        /*address = i.getStringExtra( name: "address");*/
        editTextNumber = findViewById(R.id.editTextNumber);



        myCalender = Calendar.getInstance();

        editText = (EditText) findViewById(R.id.edCheckin);
        edCheckout = (EditText) findViewById(R.id.edCheckout);
        spinnerType = findViewById(R.id.spinnerType);
        btnPreview = findViewById(R.id.btnPreview);

        DatePickerDialog.OnDateSetListener data = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //
                myCalender.set(Calendar.YEAR,year);
                myCalender.set(Calendar.MONTH,monthOfYear);
                myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabel();
            }
        };
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RoominfoActivity.this,data,myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/DD/YY";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editText.setText(sdf.format(myCalender.getTime()));
    }