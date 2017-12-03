package com.androiddev.brianrecuero.androidfinalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Rules extends AppCompatActivity {
    TextView Rules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        TextView rules= (TextView) findViewById(R.id.rules);

        rules.setText("1. On startup all user will get chance/turn to roll 1 dice. Highest dice roll wins bank." +
                " If more than 1 player have highest number, players " +
                "that have the highest number must roll again to get the " +
                "highest number. This must continue until it is established who has bank."





        );
    }
}
