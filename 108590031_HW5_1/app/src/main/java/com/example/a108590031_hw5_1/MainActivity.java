package com.example.a108590031_hw5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CalculatorActivity";
    private Calculator nCalculator;
    private EditText f_inOperator;
    private EditText t_inOperator;
    private TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nCalculator = new Calculator();
        f_inOperator = (EditText) findViewById(R.id.et1);
        t_inOperator = (EditText) findViewById(R.id.et2);
        total = (TextView) findViewById(R.id.textView);
    }

    public void onAdd(View view) {
        compute(Calculator.Operator.ADD);
    }

    /**
     * OnClick method called when the subtract Button is pressed.
     */
    public void onSub(View view) {
        compute(Calculator.Operator.SUB);
    }

    /**
     * OnClick method called when the divide Button is pressed.
     */
    public void onDiv(View view) {
        try {
            compute(Calculator.Operator.DIV);
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            total.setText("Error");
        }
    }

    /**
     * OnClick method called when the multiply Button is pressed.
     */
    public void onMul(View view) {
        compute(Calculator.Operator.MUL);
    }

    public void onPow(View view){ compute(Calculator.Operator.POW);}

    private void compute(Calculator.Operator operator) {
        double operandOne;
        double operandTwo;
        try {
            operandOne = Double.valueOf(f_inOperator.getText().toString()).doubleValue();
            operandTwo = Double.valueOf(t_inOperator.getText().toString()).doubleValue();
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            total.setText("Error");
            return;
        }

        String result;
        switch (operator) {
            case ADD:
                result = String.valueOf(
                        nCalculator.Add(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(
                        nCalculator.Sub(operandOne, operandTwo));
                break;
            case DIV:
                result = String.valueOf(
                        nCalculator.Div(operandOne, operandTwo));
                break;
            case MUL:
                result = String.valueOf(
                        nCalculator.Mul(operandOne, operandTwo));
                break;
            case POW:
                result = String.valueOf(
                        nCalculator.Pow(operandOne, operandTwo));
                break;
            default:
                result = "Error";
                break;
        }
        total.setText(result);
    }

    /**
     * @return the operand value entered in an EditText as double.
     */
    /*private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }*/

    /**
     * @return the operand text which was entered in an EditText.
     */
    private static String getOperandText(EditText operandEditText) {
        String operandText = operandEditText.getText().toString();
        if (TextUtils.isEmpty(operandText)) {
            throw new NumberFormatException("Operand cannot be empty!");
        }
        return operandText;
    }
}