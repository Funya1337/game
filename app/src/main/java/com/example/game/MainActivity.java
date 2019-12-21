package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean checker = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checker = !checker;
                Log.d("message", String.valueOf(checker));
            }
        });
    }
}
