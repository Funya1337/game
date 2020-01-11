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
    final Board newBoard = new Board();

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

        for (int i = 0; i < newBoard.boardSize; i++) {
            for (int j=0; j< newBoard.boardSize; j++) {
                final int indexI = i;
                final int indexJ = j;
                String buttonId = "button_" + indexI + "_" + indexJ;
                final Button button = findViewById(getResources().getIdentifier(buttonId, "id", this.getPackageName()));
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        newBoard.setElement(indexI, indexJ, turn);
                        newBoard.checkRowsForWin(indexI, indexJ, turn);
                        newBoard.checkColForWin(indexI, indexJ, turn);
                        newBoard.checkDiagForWin(indexI, indexJ, turn);
                        newBoard.checkForWinner(indexI, indexJ, turn);
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
                newBoard.clearBoard();
                newBoard.print();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }
}
