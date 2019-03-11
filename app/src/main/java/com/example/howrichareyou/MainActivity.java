package com.example.howrichareyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    TextView txtPercentage, txtEnterIncome, txtEnterSavings;
    EditText edtAnnualIncome, edtHomeEquity, edtPossesionsEquity, edtInvestments;
    Button btnHowRichAmI;

    Double totalPercentage = 0d;
    Double totalIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogic();
    }

    private void buttonLogic(){
        btnHowRichAmI = findViewById(R.id.buttonHowRichAmI);
        txtEnterIncome = findViewById(R.id.textViewEnterIncome);
        txtEnterSavings = findViewById(R.id.textViewEnterSavings);

        btnHowRichAmI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePercentage();
                dismissKeyboard();
            }
        });

        txtEnterIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissKeyboard();
            }
        });

        txtEnterSavings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissKeyboard();
            }
        });

    }

    private void calculatePercentage(){

        edtAnnualIncome = findViewById(R.id.editTextAnnualIncome);
        edtHomeEquity = findViewById(R.id.editTextHomeEquity);
        edtInvestments = findViewById(R.id.editTextInvestments);
        edtPossesionsEquity = findViewById(R.id.editTextPossesionsEquity);

        Double annualIncome = Double.parseDouble(edtAnnualIncome.getText().toString());
        Double homeEquity = Double.parseDouble(edtHomeEquity.getText().toString());
        Double possessions = Double.parseDouble(edtInvestments.getText().toString());
        Double investments = Double.parseDouble(edtPossesionsEquity.getText().toString());
        Double tempPercentage = 0d;

        totalIncome = annualIncome + homeEquity + possessions + investments + (annualIncome*2);



        if(totalIncome > 0){
            tempPercentage = 34000 / totalIncome;
            totalPercentage = 99 * (tempPercentage - 1);
        }

        if(totalIncome > 34000){
            tempPercentage = 100000 / totalIncome;
            totalPercentage = 0.8 * (tempPercentage - 1);
        }

        if(totalIncome > 100000){
            tempPercentage = 250000 / totalIncome;
            totalPercentage = 0.6 * (tempPercentage - 1);

        }
        if (totalIncome > 250000){
            tempPercentage = 500000 / totalIncome;
            totalPercentage = 0.4 * (tempPercentage - 1);

        }
        if (totalIncome > 500000){
            tempPercentage = 1000000 / totalIncome;
            totalPercentage = 0.2 * (tempPercentage - 1);

        }
        if (totalIncome > 1000000){
            tempPercentage = 10000000 / totalIncome;
            totalPercentage = 0.1 * (tempPercentage - 1);

        }
        else if(totalIncome > 10000000){
            totalPercentage = 0.00001;
        }






        printPercentage();
    }

    private void printPercentage(){
        txtPercentage = findViewById(R.id.textViewPercentage);

        String formatNumber = String.format("%1.2f", totalPercentage);

        txtPercentage.setText(formatNumber + "%");
    }

    public void onClick(View v){
        dismissKeyboard();
    }

    private void dismissKeyboard(){
        edtAnnualIncome = findViewById(R.id.editTextAnnualIncome);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtAnnualIncome.getWindowToken(),0);

    }


}
