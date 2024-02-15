package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class FibonacciActivity extends AppCompatActivity {
    private TextView tvUserInput;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

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
        Button btnClear = findViewById(R.id.btn_clear);
        Button btnDelete = findViewById(R.id.btn_delete);
        Button btnEquals = findViewById(R.id.btn_equals);
        ImageButton btnBack = findViewById(R.id.btn_back);

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
        btnClear.setOnClickListener(v -> onClearClick());
        btnDelete.setOnClickListener(v -> onDeleteClick());
        btnEquals.setOnClickListener(v -> onEqualsClick());
        btnBack.setOnClickListener(v -> finish());
    }

    private void onButtonClick(String button) {
        String current = tvUserInput.getText().toString();
        String subStr = current.isEmpty() ? "" : current.substring(4, current.length() - 1);
        tvUserInput.setText("fib(" + subStr + button + ")");
    }

    private void onClearClick() {
        tvUserInput.setText("");
        tvResult.setText("");
    }

    private void onDeleteClick() {
        String current = tvUserInput.getText().toString();
        String userInputNumber = current.substring(4, current.length() - 1);

        if (current.isEmpty()) {
            return;
        }

        if (userInputNumber.length() == 1) {
            tvUserInput.setText("");
        } else {
            tvUserInput.setText("fib(" + userInputNumber.substring(0, userInputNumber.length() - 1) + ")");
        }
    }

    private void onEqualsClick() {
        String current = tvUserInput.getText().toString();
        int result = handleFibonacci(current);

        if (current.isEmpty()) {
            tvResult.setText("");
            return;
        }

        if (result == -1) {
            tvResult.setText("Error");
            return;
        }

        tvResult.setText(String.valueOf(result));
    }

    private boolean matchFibonacciOperation(String operation) {
        return operation.matches("^fib\\([0-9]+\\)$");
    }

    private int handleFibonacci(String operation) {
        if (!matchFibonacciOperation(operation)) {
            return -1;
        }

        int num = Integer.parseInt(operation.substring(4, operation.length() - 1));
        return Fibonacci.fibonacci(num);
    }
}
