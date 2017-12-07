package com.androiddev.brianrecuero.androidfinalproject;

import java.util.Random;


public class CeeLoModel
{

    Random diceRoll = new Random();

    //Dice Roll

    private int singleRoll()
    {
        int rollValue = diceRoll.nextInt(6) + 1;// random number from 1 to 6
        return rollValue;
    }

    private int[] tripleRoll()
    {
        int[] rolls = new int[3];

        for (int r = 0; r < rolls.length; r++)
        {
            int roll = singleRoll();

            rolls[r] = roll;
        }

        return rolls;
    }


    // TODO: returns a string for the results to display in the in the textView in the game activity- SHOULD REPLACE WITH ANIMATION
    public String displayResult()
    {
        int[] rolls = tripleRoll();
        String values = "";

        for (int r = 0; r < rolls.length; r++)
        {
            values += rolls[r] + "     ";
        }

        return values;
    }
}