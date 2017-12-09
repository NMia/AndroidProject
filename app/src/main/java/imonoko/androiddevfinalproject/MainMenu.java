package imonoko.androiddevfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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
    public void gotoLeaderBoard(View v)
    {
        Intent leadBoard_intent = new Intent(this, LeaderBoardActivity.class);
        this.startActivity(leadBoard_intent);
    }
    public void startGame(View v)
    {
        Intent startGame_intent = new Intent(this, GameActivity.class);
        this.startActivity(startGame_intent);
    }
    public void IncrementWinScore()
    {
        Statistics stat = new Statistics();
        stat.setWins(stat.getWins()+1);
        DatabaseManager db = new DatabaseManager(this);
        db.updateScores(0,stat);
    }
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
            case R.id.action_modifyAccount:
                Intent modify_intent = new Intent(this, ModifyAccount.class);
                this.startActivity(modify_intent);
                // another startActivity, this is for item with id "menu_item2"
                break;
            case R.id.action_ClearDataBase:
                DatabaseManager dbm = new DatabaseManager(this);
                dbm.clearDataBase();
                // another startActivity, this is for item with id "menu_item2"
                break;
            case R.id.action_AddPoints:
                IncrementWinScore();
                // another startActivity, this is for item with id "menu_item2"
                break;
            case R.id.action_logout:
                // another startActivity, this is for item with id "menu_item2"
                Intent logout = new Intent(this, LoginActivity.class);
                this.startActivity(logout);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }


        return true;
    }//End onOptionItemSelected
}
