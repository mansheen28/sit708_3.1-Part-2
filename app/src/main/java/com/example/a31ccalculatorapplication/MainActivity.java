package com.example.a31ccalculatorapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText val1, val2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        val1 = findViewById(R.id.et_1);
        val2 = findViewById(R.id.et_2);
        result = findViewById(R.id.textView2);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidations()) {
                    int v1 = Integer.parseInt(val1.getText().toString());
                    int v2 = Integer.parseInt(val2.getText().toString());
                    result.setText("Operation result: " + (v1 + v2));
                }
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidations()) {
                    int v1 = Integer.parseInt(val1.getText().toString());
                    int v2 = Integer.parseInt(val2.getText().toString());
                    result.setText("Operation result: " + (v1 - v2));
                }
            }
        });
    }

    public boolean checkValidations() {
        String v1 = val1.getText().toString();
        String v2 = val2.getText().toString();
        if(v1.isEmpty() || v2.isEmpty()) {
            Toast.makeText(this, "Please fill all values", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            Integer.parseInt(v1);
            Integer.parseInt(v2);
        }catch(Exception e) {
            Toast.makeText(this, "Only Integer values are allowed", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}