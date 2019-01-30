package com.example.helloworldpj1;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.MotionEvent;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.animation.ObjectAnimator;
import android.view.ViewGroup.LayoutParams;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

import android.os.Handler;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private Random randomValGen;

    private int score = 0;
    private int addToScore = 1;
    private int level = 2;

    private Handler spawnHandler;
    private int spawnDelay = 900;
    private int startDelay = 2000;

    @SuppressLint("ClickableViewAccessibility")
    protected void createNewHelloWorld() {

        final ImageButton imagebutton = new ImageButton(MainActivity.this);
        RelativeLayout relativelayout = (RelativeLayout) findViewById(R.id.relativelayout);
        LinearLayout.LayoutParams params = new LinearLayout
                .LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.topMargin = -500;
        int randomVal = randomValGen.nextInt(800);
        params.leftMargin = randomVal;
        params.height = 300;
        params.width = 300;

        imagebutton.setBackground(null);
        final ObjectAnimator animation = ObjectAnimator.ofFloat(imagebutton, "translationY", 3000f);
        animation.setDuration(8000);
        animation.start();
        animation.addPauseListener(new Animator.AnimatorPauseListener() {
            private Animator myAnimation = null;

            public void endAnimation() {
                if (myAnimation != null) {
                    myAnimation.end();
                }
            }

            @Override
            public void onAnimationPause(Animator animation) {
                myAnimation = animation;
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        endAnimation();
                    }
                }, 200);

            }

            @Override
            public void onAnimationResume(Animator animation) {

            }
        });

        // Add image path for imagebutton from drawable folder.
        int randomColor = randomValGen.nextInt(4);
        if (randomColor == 0) {
            imagebutton.setImageResource(R.drawable.red);
        } else if (randomColor == 1) {
            imagebutton.setImageResource(R.drawable.yellow);
        } else if (randomColor == 2) {
            imagebutton.setImageResource(R.drawable.green);
        } else {
            imagebutton.setImageResource(R.drawable.blue);
        }
        imagebutton.setLayoutParams(params);

        imagebutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() != MotionEvent.ACTION_DOWN) {
                    return false;
                }
                score += addToScore;
                TextView textView = findViewById(R.id.score);
                textView.setText("" + score);
                imagebutton.setImageResource(R.drawable.goodbye);
                animation.pause();

                return true;

            }
        });

        relativelayout.addView(imagebutton);

    }

    private Runnable runMakeHelloWorld = new Runnable() {
        @Override
        public void run() {
            createNewHelloWorld();
            spawnHandler.postDelayed(runMakeHelloWorld, spawnDelay);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        randomValGen = new Random();

        spawnHandler = new Handler();
        spawnHandler.postDelayed(runMakeHelloWorld, startDelay);

        TextView levelView = findViewById(R.id.level);
        levelView.setText("Power: " + addToScore);
        TextView costView = findViewById(R.id.cost);
        costView.setText("Upgrade Cost: " + (Math.pow(level, 3)));

        FloatingActionButton upgrader = findViewById(R.id.upgrader);
        upgrader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (score >= Math.pow(level, 3)) {
                    score -= Math.pow(level, 3);
                    addToScore += 5 + level;
                    level += 1;
                    TextView textView = findViewById(R.id.score);
                    textView.setText("" + score);
                    TextView levelView = findViewById(R.id.level);
                    levelView.setText("Power: " + addToScore);
                    TextView costView = findViewById(R.id.cost);
                    costView.setText("Upgrade Cost: " + (Math.pow(level, 3)));
                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Continue tapping 'Hello Worlds' to increase your score\nSpend your points on upgrages to increase your power", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
