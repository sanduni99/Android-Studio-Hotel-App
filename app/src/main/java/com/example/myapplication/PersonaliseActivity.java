package com.example.myapplication;

import static com.example.myapplication.R.id.editTextText3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

public class PersonaliseActivity extends AppCompatActivity {
    Calendar myCalender;
    EditText editText,editCheckout;
    EditText editTextText3,editTextTextEmailAddress,editTextPhone,editTextNumber;
    Spinner spinnerType;
    Button btnPreview;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);

        Intent i = getIntent();


        editTextText3 = findViewById(R.id.editTextText3);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextPhone =findViewById(R.id.editTextPhone);
        /*address = i.getStringExtra( name: "address");*/
        editTextNumber = findViewById(R.id.editTextNumber);
       btnSave.setOnClickListener(new View OnClickListener(){

           @Override
                   public void onClick(View view){
           Intent intent = new Intent(PersonaliseActivity.this, RoominfoActivity.class);
           i.putExtra(editTextText3.getText().toString(), "editTextText3";
            i.putExtra(R.id.editTextTextEmailAddress.getText().toString(), "editTextTextEmailAddress";
            i.putExtra(R.id.editTextPhone.getText().toString(), "editTextPhone";
            i.putExtra(editTextNumber.getText().toString(), "editTextNumber";
            startActivity(i);

        }

        /*myCalender = Calendar.getInstance();

        editText = (EditText) findViewById(R.id.edCheckin);
        edCheckout = (EditText) findViewById(R.id.edCheckout);
        spinnerType = findViewById(R.id.spinnerType);
        btnPreview = findViewById(R.id.btnPreview);*/


        DatePickerDialog.OnDateSetListener data;
        data = new DatePickerDialog.OnDateSetListener() {
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
                new DatePickerDialog(PersonaliseActivity.this,data,myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel(){
        String myFormat = "MM/DD/YY";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalender.getTime()));
    }

}
