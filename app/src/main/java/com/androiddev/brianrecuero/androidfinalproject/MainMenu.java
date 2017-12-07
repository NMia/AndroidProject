package com.androiddev.brianrecuero.androidfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    /**
     * onOptionsItemSelected:
     * Is for the menu dropped down.
     * once an item is click it will
     * perform the action in the switch-
     * case.
     * **/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_howToPlay:
                Intent rules_intent = new Intent(this, Rules.class);
                this.startActivity(rules_intent);
                break;
            case R.id.action_stats:
                Intent stats_intent = new Intent(this, StatisticsActivity.class);
                this.startActivity(stats_intent);
                break;
            case R.id.action_logout:
                DatabaseManager d = new DatabaseManager(this);
                // another startActivity, this is for item with id "menu_item2"
                break;
            default:
                return super.onOptionsItemSelected(item);
        }


        return true;
    }//End onOptionItemSelected

    public void startGame(View v)
    {
        Intent gameStart = new Intent(this, GameActivity.class);
        this.startActivity(gameStart);
    }
}
