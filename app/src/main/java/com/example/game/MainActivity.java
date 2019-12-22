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
        for (int i = 1; i <= 9; i++) {
            final Button button = (Button) findViewById(getResources().getIdentifier("button_" + i, "id",
                    this.getPackageName()));
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    checker = !checker;
                    if (checker == true) {
                        button.setText("X");
                    } else {
                        button.setText("0");
                    }
                    Log.d("message", String.valueOf(checker));
                    v.setClickable(false);
                    v.setEnabled(false);
                }
            });
        }
    }
}
