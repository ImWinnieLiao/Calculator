package com.example.calculatortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,number.class);
                startActivity(intent);
            }
        });

    }

    public void numberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp = false;
        String number =  ed1.getText().toString();
        switch (view.getId()){
            case R.id.button1:
                number += "1";
                break;
            case R.id.button2:
                number += "2";
                break;
            case R.id.button3:
                number += "3";
                break;
            case R.id.button4:
                number += "4";
                break;
            case R.id.button5:
                number += "5";
                break;
            case R.id.button6:
                number += "6";
                break;
            case R.id.button7:
                number += "7";
                break;
            case R.id.button8:
                number += "8";
                break;
            case R.id.button9:
                number += "9";
                break;
            case R.id.button0:
                number += "0";
                break;
            case R.id.buttonPoint:
                number += ".";
                break;
            case R.id.buttonPlusMinus:
                number += "-"+number;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        switch (view.getId()){
            case R.id.buttonDivide: op = "/"; break;
            case R.id.buttonMulti: op = "*"; break;
            case R.id.buttonPlus: op = "+"; break;
            case R.id.buttonMinus: op = "-"; break;
            case R.id.buttonPre: op = "%"; break;
            case R.id.buttonFac: op = "!"; break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "%":
                result = (Double.parseDouble(oldNumber) / 100) * Double.parseDouble(newNumber);
                break;
            case "!":
                int a = 1;
                for(int i= 1;i<=Double.parseDouble(oldNumber);i++){
                    a*=i;
                }
                result = a;
                break;
        }
        ed1.setText(result+"");
    }

    public void deleteEvent(View view) {
        ed1.setText("");
        isNewOp = true;
    }
}