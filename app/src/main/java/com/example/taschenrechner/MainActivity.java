package com.example.taschenrechner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    public static final String CALCULATION_KEY = "calculationKey";
    public static final String SOLUTION_KEY = "solutionKey";

    private String calculationString = "";
    private String solutionString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Kontextmenu
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.more_operations, menu);
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculationString);
        TextView solution = findViewById(R.id.textSolution);
        solution.setText(solutionString);
        return true;
    }

    //Speichern der Werte
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        TextView calculation = findViewById(R.id.textCalculation);
        TextView solution = findViewById(R.id.textSolution);
        outState.putString(CALCULATION_KEY, calculation.getText().toString());
        outState.putString(SOLUTION_KEY, solution.getText().toString());
        super.onSaveInstanceState(outState);
    }

    //Wiederherstellen der Daten beim Wechsel der View
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.calculationString = savedInstanceState.getString(CALCULATION_KEY);
        this.solutionString = savedInstanceState.getString(SOLUTION_KEY);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        TextView calculation = findViewById(R.id.textCalculation);
        switch (menuItem.getItemId()){
            case R.id.sinus:
                calculation.setText(calculation.getText()+"sin");
                return true;
            case R.id.cosinus:
                calculation.setText(calculation.getText()+"cos");
                return true;
            case R.id.tangent:
                calculation.setText(calculation.getText()+"tan");
                return true;
            case R.id.squareroot:
                calculation.setText(calculation.getText()+"sqrt");
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
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
        //Verhindert, dass Error-Message in Calculation landet
        if(solution.getText().toString().equals("Error")) {
            calculation.setText("");
        } else {
            calculation.setText(solution.getText());
        }
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

    public void onClickBtnSinus(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"sin");
    }

    public void onClickBtnCosinus(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"cos");
    }

    public void onClickBtnTangent(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"tan");
    }

    public void onClickBtnSquareroot(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        calculation.setText(calculation.getText()+"sqrt");
    }

    public void calculate(View view) {
        TextView calculation = findViewById(R.id.textCalculation);
        Expression e = new ExpressionBuilder(calculation.getText().toString()).build();
        TextView solution = findViewById(R.id.textSolution);
        try {
            double result = e.evaluate();
            String resultString = Double.toString(result);
            //Test, ob Ergebnis ganze Zahl ist
            if(resultString.split("\\.")[1].equals("0")){
                solution.setText(resultString.split("\\.")[0]);
            } else {
                solution.setText(resultString);
            }
        } catch (Exception ae){solution.setText("Error");}
    }

}