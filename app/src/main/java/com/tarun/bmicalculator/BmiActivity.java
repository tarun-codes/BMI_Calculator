package com.tarun.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {
    TextView bmiValue, bmiCategory,bmiTips;
    String category;
    String bmiValOutput;
    Button calculateAgainBtn;
    String[] bmiTipsArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        bmiValue = findViewById(R.id.bmi_value);
        bmiCategory = findViewById(R.id.bmi_category);
        bmiTips = findViewById(R.id.bmi_tips);
        bmiTipsArray = getResources().getStringArray(R.array.tips_array);
        calculateAgainBtn = findViewById(R.id.calculate_again_btn);
        bmiValOutput = getIntent().getStringExtra("bmiVal");
        bmiValue.setText(bmiValOutput);
        findCategory();
        categoryTips();
        calculateAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void categoryTips() {
        double result = Double.parseDouble(bmiValOutput);
        if(result < 15){
           bmiTips.setText(bmiTipsArray[0]);
        }
        else if(result >= 15 && result <= 16){
            bmiTips.setText(bmiTipsArray[0]);
        }
        else if(result >= 16 && result <= 18.5){
            bmiTips.setText(bmiTipsArray[1]);
        }
        else if(result >= 18.5 && result <= 25){
            bmiTips.setText(bmiTipsArray[2]);
        }
        else if(result >= 25 && result <= 30){
            bmiTips.setText(bmiTipsArray[3]);
        }
        else if(result >=30 && result <= 35){
            bmiTips.setText(bmiTipsArray[4]);
        }
        else if(result >= 35 && result <= 50){
            bmiTips.setText(bmiTipsArray[4]);
        }
        else
            bmiTips.setText(bmiTipsArray[4]);

    }

    private void findCategory() {
        double result = Double.parseDouble(bmiValOutput);
        if(result < 15){
            category = "Very Severely Underweight";
            bmiCategory.setText(category);
        }
        else if(result >= 15 && result <= 16){
            category = "Severely Underweight";
            bmiCategory.setText(category);
        }
        else if(result >= 16 && result <= 18.5){
            category = "Underweight";
            bmiCategory.setText(category);
        }
        else if(result >= 18.5 && result <= 25){
            category = "Normal (Healthy weight)";
            bmiCategory.setText(category);
        }
        else if(result >= 25 && result <= 30){
            category = "Overweight";
            bmiCategory.setText(category);
        }
        else if(result >=30 && result <= 35){
            category = "Moderately Obese";
            bmiCategory.setText(category);
        }
        else if(result >= 35 && result <= 50){
            bmiCategory.setText(category);
            category = "Severely Obese";
        }
        else
            category = "Very Severely Obese";
        bmiCategory.setText(category);

    }
}
