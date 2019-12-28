package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean checker = false;
    int[][] board = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Board newBoard = new Board();

//        newBoard.setElement(0, 1, ElState.X);
//        newBoard.setElement(1, 2, ElState.O);
//        newBoard.print();

        for (int i = 1; i <= 9; i++) {
            final Button button = (Button) findViewById(getResources().getIdentifier("button_" + i, "id",
                    this.getPackageName()));
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    checker = !checker;
                    Log.d("msg", String.valueOf(button));
                    if (checker == true) {
                        button.setText("X");

                    } else {
                        button.setText("0");
                    }
                    Log.d("message", String.valueOf(checker));
                    v.setClickable(false);
                    v.setEnabled(false);
                    resetFunc();
                }
            });
        }
    }
    public void resetFunc() {
        Button button = (Button) findViewById(R.id.button_reset);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }
}
