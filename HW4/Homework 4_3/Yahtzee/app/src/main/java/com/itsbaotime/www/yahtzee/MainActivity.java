package com.itsbaotime.www.yahtzee;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Handler;

/**
 * This Program creats Dice in the UI and Randomly changes each Dice's value for a random time when the user clicks start
 * The Sum of the Dice is then calculated and displayed
 * @author Bao Tran
 * @version 1.00, 23 January 2017
 */
public class MainActivity extends AppCompatActivity {
    private ImageView[] Dice = new ImageView[5];
    private Button roll;
    private TextView s;
    private Thread th;
    private int diceSelection,v;
    private int sum = 0;
    private Random rnd = new Random();

    /**
     * Creates the Dice Objects as ImageViews
     * Randomizes their image when start is click
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dice[0] = (ImageView) findViewById(R.id.Dice_1);
        Dice[1] = (ImageView) findViewById(R.id.Dice_2);
        Dice[2] = (ImageView) findViewById(R.id.Dice_3);
        Dice[3] = (ImageView) findViewById(R.id.Dice_4);
        Dice[4] = (ImageView) findViewById(R.id.Dice_5);
        roll = (Button) findViewById(R.id.Roll);
        th = new Thread() {
            @Override
            public void run() {
                try {
                    int duration = 100 + rnd.nextInt(200);
                    for (int i = 0; i < duration; i++) {
                        Thread.sleep(10);
                        // Changes the dice images
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                                diceSelection = rnd.nextInt(5);
                                v = rnd.nextInt(6) + 1;

                                if ( v == 1)
                                    Dice[diceSelection].setImageResource(R.drawable.dice_1);
                                else if( v==2)
                                    Dice[diceSelection].setImageResource(R.drawable.dice_2);
                                else if( v==3)
                                    Dice[diceSelection].setImageResource(R.drawable.dice_3);
                                else if( v==4)
                                    Dice[diceSelection].setImageResource(R.drawable.dice_4);
                                else if( v==5)
                                    Dice[diceSelection].setImageResource(R.drawable.dice_5);
                                else if( v==6)
                                    Dice[diceSelection].setImageResource(R.drawable.dice_6);
                            }

                        });
                    }
                } catch (InterruptedException e) {System.out.printf("Error!");
                }
                MainActivity.this.threadComplete();
            }
        };

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roll.isClickable()) {
                    th.start();
                }

            }

            ;

        });
    }

    /**
     * Calculates the sum of the final Dice based on their image after the thread is finished
     */
    private void threadComplete() {

        sum = 0;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i <5;i++) {
                    Drawable.ConstantState d = Dice[i].getDrawable().getConstantState();
                    if (d.equals(getResources().getDrawable(R.drawable.dice_1).getConstantState()))
                        sum += 1;
                    else if( d.equals(getResources().getDrawable(R.drawable.dice_2).getConstantState()))
                        sum += 2;
                    else if( d.equals(getResources().getDrawable(R.drawable.dice_3).getConstantState()))
                        sum += 3;
                    else if( d.equals(getResources().getDrawable(R.drawable.dice_4).getConstantState()))
                        sum += 4;
                    else if(d.equals(getResources().getDrawable(R.drawable.dice_5).getConstantState()))
                        sum += 5;
                    else if(d.equals(getResources().getDrawable(R.drawable.dice_6).getConstantState()))
                        sum += 6;
                }
                s = (TextView) findViewById(R.id.sum);
                s.setText(String.format("Sum: %d", sum));

            }

        });

    }
}