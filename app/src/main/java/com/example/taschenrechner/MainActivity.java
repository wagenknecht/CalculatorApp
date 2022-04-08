package com.example.taschenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView calculation = findViewById(R.id.textCalculation);
    }

    public void onClickBtn0(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"0");
        calculate(view);
    }

    public void onClickBtn1(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"1");
        calculate(view);
    }

    public void onClickBtn2(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"2");
        calculate(view);
    }

    public void onClickBtn3(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"3");
        calculate(view);
    }

    public void onClickBtn4(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"4");
        calculate(view);
    }

    public void onClickBtn5(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"5");
        calculate(view);
    }

    public void onClickBtn6(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"6");
        calculate(view);
    }

    public void onClickBtn7(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"7");
        calculate(view);
    }

    public void onClickBtn8(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"8");
        calculate(view);
    }

    public void onClickBtn9(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"9");
        calculate(view);
    }

    public void onClickBtnPlus(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"+");
    }

    public void onClickBtnMinus(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"-");
    }

    public void onClickBtnMultiply(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"*");
    }

    public void onClickBtnDivide(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"/");
    }

    public void onClickBtnComma(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+".");
    }

    public void onClickBtnSolve(View view) {
        TextView solution = findViewById(R.id.textSolution);
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(solution.getText());
        solution.setText("");
    }

    public void onClickBtnCE(View view) {
        TextView solution = findViewById(R.id.textSolution);
        TextView calculation = findViewById(R.id.textCalculation);
        if(calculation.length() < 1){
           solution.setText("");
        } else {
           calculation.setText(calculation.getText().toString().substring(0, calculation.length() - 1));
           if(calculation.length() > 0){
               calculate(view);
           } else {
              solution.setText("");
           }
        }
    }

    public void onClickBtnC(View view) {
        TextView solution = findViewById(R.id.textSolution);
        TextView calculation = findViewById(R.id.textCalculation);
        solution.setText("");
        calculation.setText("");
    }

    public void calculate(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        Expression e = new ExpressionBuilder(calculation.getText().toString()).build();
        TextView solution = findViewById(R.id.textSolution);
        try {
            double result = e.evaluate();
            solution.setText(Double.toString(result));
        } catch (Exception ae){solution.setText("Nicht ausführbare Rechnung");}

    }

}