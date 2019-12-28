package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ElState turn = ElState.X;

    private void nextTurn() {
        turn = turn == ElState.X ? ElState.O : ElState.X;
    }

    private String getTurnText() {
        return turn == ElState.X ? "X" : "O";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Board newBoard = new Board();

//        newBoard.setElement(0, 1, ElState.X);
//        newBoard.setElement(1, 2, ElState.O);
//        newBoard.print();

        for (int i = 0; i < newBoard.boardSize; i++) {
            for (int j=0; j< newBoard.boardSize; j++) {
                final int indexI = i;
                final int indexJ = j;
                String buttonId = "button_" + indexI + "_" + indexJ;
//                System.out.println("buttonId " + buttonId);
                final Button button = findViewById(getResources().getIdentifier(buttonId, "id", this.getPackageName()));
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        newBoard.setElement(indexI,indexJ,turn);
                        newBoard.print();
                        button.setText(getTurnText());
                        nextTurn();
                        v.setClickable(false);
                        v.setEnabled(false);
                        resetFunc();
                    }
                });
            }
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
