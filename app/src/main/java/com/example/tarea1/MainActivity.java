package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvUserInput;
    private TextView tvResult;
    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUserInput = findViewById(R.id.tv_input);
        tvResult = findViewById(R.id.tv_result);

        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);
        Button btnDot = findViewById(R.id.btn_dot);
        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMultiply = findViewById(R.id.btn_multiply);
        Button btnDivide = findViewById(R.id.btn_divide);
        Button btnExponent = findViewById(R.id.btn_exponent);
        //Button btnFactorial = findViewById(R.id.btn_factorial);
        //Button btnFibonacci = findViewById(R.id.btn_fibonacci);
        Button btnClear = findViewById(R.id.btn_clear);
        Button btnDelete = findViewById(R.id.btn_delete);
        Button btnEquals = findViewById(R.id.btn_equals);

        btn0.setOnClickListener(v -> onButtonClick("0"));
        btn1.setOnClickListener(v -> onButtonClick("1"));
        btn2.setOnClickListener(v -> onButtonClick("2"));
        btn3.setOnClickListener(v -> onButtonClick("3"));
        btn4.setOnClickListener(v -> onButtonClick("4"));
        btn5.setOnClickListener(v -> onButtonClick("5"));
        btn6.setOnClickListener(v -> onButtonClick("6"));
        btn7.setOnClickListener(v -> onButtonClick("7"));
        btn8.setOnClickListener(v -> onButtonClick("8"));
        btn9.setOnClickListener(v -> onButtonClick("9"));
        btnDot.setOnClickListener(v -> onButtonClick("."));
        btnPlus.setOnClickListener(v -> onButtonClick("+"));
        btnMinus.setOnClickListener(v -> onButtonClick("−"));
        btnMultiply.setOnClickListener(v -> onButtonClick("×"));
        btnDivide.setOnClickListener(v -> onButtonClick("÷"));
        btnExponent.setOnClickListener(v -> onButtonClick("^"));
        //btnFactorial.setOnClickListener(v -> onButtonClick("!"));
        //btnFibonacci.setOnClickListener(v -> onFibonacciClick());
        btnClear.setOnClickListener(v -> onClearClick());
        btnDelete.setOnClickListener(v -> onDeleteClick());
        btnEquals.setOnClickListener(v -> onEqualsClick());
    }

    private void onButtonClick(String button) {
        String current = tvUserInput.getText().toString();
        tvUserInput.setText(current + button);
    }

    private void onFibonacciClick() {
        String current = tvUserInput.getText().toString();

        if (current.isEmpty()) {
            return;
        }

        tvUserInput.setText("fib(" + current + ")");
    }

    private void onClearClick() {
        tvUserInput.setText("");
        tvResult.setText("");
    }

    private void onDeleteClick() {
        String current = tvUserInput.getText().toString();

        if (current.isEmpty()) {
            return;
        }

        tvUserInput.setText(current.substring(0, current.length() - 1));
    }

    private void onEqualsClick() {
        String current = tvUserInput.getText().toString();

        if (current.isEmpty()) {
            tvUserInput.setText("");
            return;
        }

        handleOperation(current);
    }

    private void handleOperation(String operation) {
        //int intResult = -1;
        double doubleResult = Double.NaN;
        
        if (operation.contains("+")) {
            doubleResult = handleAddition(operation);
        } else if (operation.contains("−")) {
            doubleResult = handleSubtraction(operation);
        } else if (operation.contains("×")) {
            doubleResult = handleMultiplication(operation);
        } else if (operation.contains("÷")) {
            doubleResult = handleDivision(operation);
        } else if (operation.contains("^")) {
            doubleResult = handleExponent(operation);
        }

        if (Double.isNaN(doubleResult)) {
            tvResult.setText("Error");
        }

        tvResult.setText(String.valueOf(doubleResult));
    }

    private boolean matchBasicOperations(String operation) {
        return operation.matches("^[0-9]+(\\.[0-9]+)?[+−×÷^][0-9]+(\\.[0-9]+)?$");
    }

    private double handleAddition(String operation) {
        if (!matchBasicOperations(operation)) {
            return Double.NaN;
        }

        String[] numbers = operation.split("\\+");
        double num1 = Double.parseDouble(numbers[0]);
        double num2 = Double.parseDouble(numbers[1]);

        return calculator.add(num1, num2);
    }

    private double handleSubtraction(String operation) {
        if (!matchBasicOperations(operation)) {
            return Double.NaN;
        }

        String[] numbers = operation.split("−");
        double num1 = Double.parseDouble(numbers[0]);
        double num2 = Double.parseDouble(numbers[1]);

        return calculator.subtract(num1, num2);
    }

    private double handleMultiplication(String operation) {
        if (!matchBasicOperations(operation)) {
            return Double.NaN;
        }

        String[] numbers = operation.split("×");
        double num1 = Double.parseDouble(numbers[0]);
        double num2 = Double.parseDouble(numbers[1]);

        return calculator.multiply(num1, num2);
    }

    private double handleDivision(String operation) {
        if (!matchBasicOperations(operation)) {
            return Double.NaN;
        }

        String[] numbers = operation.split("÷");
        double num1 = Double.parseDouble(numbers[0]);
        double num2 = Double.parseDouble(numbers[1]);

        return calculator.divide(num1, num2);
    }

    private double handleExponent(String operation) {
        if (!matchBasicOperations(operation)) {
            return Double.NaN;
        }

        String[] numbers = operation.split("\\^");
        double num1 = Double.parseDouble(numbers[0]);
        double num2 = Double.parseDouble(numbers[1]);

        return calculator.exponent(num1, num2);
    }

    private boolean matchFactorialOperation(String operation) {
        return operation.matches("^[0-9]+!$");
    }

    private int handleFactorial(String operation) {
        if (!matchFactorialOperation(operation)) {
            return -1;
        }

        int num = Integer.parseInt(operation.substring(0, operation.length() - 1));
        return calculator.factorial(num);
    }

    private boolean matchFibonacciOperation(String operation) {
        return operation.matches("^fib\\([0-9]+\\)$");
    }

    private int handleFibonacci(String operation) {
        if (!matchFibonacciOperation(operation)) {
            return -1;
        }

        int num = Integer.parseInt(operation.substring(4, operation.length() - 1));
        return calculator.fibonacci(num);
    }
}
