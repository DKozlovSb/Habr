package com.example.danila.examapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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
        textView.setMovementMethod(new ScrollingMovementMethod());
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread thread = new Thread(new ThreadJob(), "Main job");
                thread.start();

            }
        });

    }

    void setTextView(final String s){

        runOnUiThread(new Runnable() {
            public void run() {
                textView.setText(s);
            }
        });
    }

    class ThreadJob implements Runnable{

        @Override
        public void run() {
            Test test = new Test();
            try {
                setTextView(test.run());
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }

        }
    }
    class t implements Runnable{
            @Override
            public void run() {

            }

    }

}



