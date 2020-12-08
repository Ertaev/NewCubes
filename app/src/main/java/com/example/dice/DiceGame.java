package com.example.dice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DiceGame extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    private Button button2;
    private ImageView Dice1, Dice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamedice);

        button2 = (Button) findViewById(R.id.button2);
        Dice1 = (ImageView) findViewById(R.id.Dice1);
        Dice2 = (ImageView) findViewById(R.id.Dice2);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int value1 = randomDiceValue();
                int value2 = randomDiceValue();

                int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.dice");
                int res2 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.dice");

                Dice1.setImageResource(res1);
                Dice2.setImageResource(res2);
            }

        }
        );

        Button button_back = (Button)findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(DiceGame.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch(Exception e){

                }
            }
        });

    }
    public static int randomDiceValue(){
        Random r = new Random();
        return r.nextInt(6) + 1;
    }
}