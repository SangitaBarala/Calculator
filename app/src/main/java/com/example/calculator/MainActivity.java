package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean operatorClicked = true;
    TextView tv;
    String oldNumber="";
    String selectedOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv =  (TextView)findViewById(R.id.tvDisplay1);
    }

    // Select the buttons using their IDs

     public void selectNumber(View v){
        if(operatorClicked == true){
            tv.setText("");
        }
        operatorClicked = false;
        TextView tv = (TextView)findViewById(R.id.tvDisplay1);
        String numbers = tv.getText().toString();
        switch (v.getId()){
            case R.id.btn0:
                numbers += "0";
                break;
            case R.id.btn1:
                numbers += "1";
                break;
            case R.id.btn2:
                numbers += "2";
                break;
            case R.id.btn3:
                numbers += "3";
                break;
            case R.id.btn4:
                numbers += "4";
                break;
            case R.id.btn5:
                numbers += "5";
                break;
            case R.id.btn6:
                numbers += "6";
                break;
            case R.id.btn7:
                numbers += "7";
                break;
            case R.id.btn8:
                numbers += "8";
                break;
            case R.id.btn9:
                numbers += "9";
                break;
            case R.id.btnC:
                numbers = "";
                break;
            case R.id.btnAddSub:
                if(numbers.charAt(0) == '-'){
                    numbers = numbers.substring(1);
                }else {
                    numbers = "-" + numbers;
                }
                break;
            case R.id.btnDel:
                String delNumbers = "";
                for(int i=0; i<numbers.length()-1; i++){
                    delNumbers += numbers.charAt(i);
                }
                numbers = delNumbers;
                break;
        }
        tv.setText(numbers);
    }

    // function to use the decimal point

    public void decimalPoint(View v) {
        switch (v.getId()){
            case R.id.btnDot:
                String str = String.format(tv.getText().toString().trim(), "%2f");
                if(str.length()>0){
                    tv.setText(str + ".");
                }else
                {
                    tv.setText("");
                }
        }
    }

    // function to access the operators using their IDs

     public void operatorEvent(View v){
       operatorClicked = true;
       oldNumber = tv.getText().toString();

       switch (v.getId()){
           case R.id.btnAdd:
               selectedOperator = "+";
               break;
           case R.id.btnSub:
               selectedOperator = "-";
               break;
           case R.id.btnMul:
               selectedOperator = "*";
               break;
           case R.id.btnDiv:
               selectedOperator = "/";
               break;
       }
     }

     // function to calculate the result based on the operator selection

     public void calculateResult(View v){
        String newNumber = tv.getText().toString();
        double result =0.0;
        switch (selectedOperator){
            case "+":
                result = Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
        }
        tv.setText(Double.toString(result));
     }
}