package com.example.progressbar_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    ProgressBar prog_Bar;
    Button btnStart;

    int progress = 0;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        prog_Bar = findViewById(R.id.progressBar);
        btnStart = findViewById(R.id.button);

        btnStart.setOnClickListener(v -> {
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (prog_Bar.getProgress() < 100) {
                        prog_Bar.setProgress(progress);
                        progress++;
                        handler.postDelayed(this,100);
                        txt.setText("Wait...");
                    }
                    else txt.setText("Finished");
                }
            }, 100);
        });
    }
}