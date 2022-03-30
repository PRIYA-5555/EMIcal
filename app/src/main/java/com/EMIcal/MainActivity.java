package com.EMIcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  {

    Button submit;
    EditText amount,rate,year;
    TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.submit);
        amount = findViewById(R.id.amount);
        rate = findViewById(R.id.rate);
        year = findViewById(R.id.year);
        text_view = findViewById(R.id.text_view);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float p = Float.parseFloat(amount.getText().toString());
                float r = Float.parseFloat(rate.getText().toString());
                float y = Float.parseFloat(year.getText().toString());

                r = r/(12*100);

                float f_r = 1.0f;
                for (int i = 0; i < y; i++) {
                    f_r = f_r * (1+r);

                }
                Float emi = (Float) (p * r * (f_r/(f_r - 1)));

                Float t_amount = (Float) (emi*y);
                Float t_interest = (Float) (t_amount - p);
                text_view.setText("\nEMI : "+emi+"\nTotal interest :"+t_interest+"\nTotal Amount :"+t_amount);
            }
        });

    }

}