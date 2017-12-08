package imonoko.androiddevfinalproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;


public class GameActivity extends Activity implements GestureDetector.OnGestureListener{

    private CeeLoModel clm;
    private GestureDetectorCompat gDetect;
    private TextView diceResults;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ceelo_main);

        clm = new CeeLoModel();
        gDetect = new GestureDetectorCompat(this,this);
        diceResults = (TextView) findViewById(R.id.results);

    }
    // TODO: displays results in the text view - SHOULD REPLACE WITH ANIMATION
    //TODO: ADD Player Objects from the database so we can decipher who one
    public void updateView()
    {
        String results = clm.displayResult();
        diceResults.setText(results);
    }


    // Gestures - should roll dice ONLY through onFling - other methods unintentionally change the results too quickly/easily
    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gDetect.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        return true;
    }

    // TODO: can possibly change the speed of the animation (if velocityX and velocityY are higher, may wish to reduce duration of animation)
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,  float velocityX, float velocityY) {
        updateView();

        /*
        if ( velocityX > someValueForSpeed(pixels/sec) || velocityY > someValueForSpeed(pixels/sec) )
         */

        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {;
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }
}