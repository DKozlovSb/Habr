package com.example.danila.examapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.URISyntaxException;


public class MainActivity extends AppCompatActivity  {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Test test = new Test();
                try {
                    test.run();
                    textView.setText(test.toString());
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}



