package com.example.helloworldpj1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.ViewGroup;
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
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Random;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageButton> helloWorldArray;

    private Random randomValGen;

    private int score = 0;

    private int justSpawned = 0;

//    private MainActivity thisObject;

//    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
 //       thisObject = this;
/*
        ImageButton newFab = new ImageButton(MainActivity.this);

        RelativeLayout.LayoutParams rel_btn = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        rel_btn.leftMargin = 100;
        rel_btn.topMargin =  200;
        rel_btn.width = 50;
        rel_btn.height = 50;

        newFab.setImageResource(R.drawable.red);
        newFab.setLayoutParams(rel_btn);

        helloWorldArray = new ArrayList<>();
        helloWorldArray.add(newFab);
*/

        randomValGen = new Random();

        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        final ImageButton imagebutton = new ImageButton(MainActivity.this);
                        RelativeLayout relativelayout = (RelativeLayout)findViewById(R.id.relativelayout);
                        LinearLayout.LayoutParams params = new LinearLayout
                                .LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                        params.topMargin = -500;
                        int randomVal = randomValGen.nextInt(800);
                        params.leftMargin = randomVal;
                        params.height = 300;
                        params.width = 300;

                        imagebutton.setBackground(null);
                        ObjectAnimator animation = ObjectAnimator.ofFloat(imagebutton, "translationY", 3000f);
                        animation.setDuration(7000);
                        animation.start();

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

                        imagebutton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                score++;
                                TextView textView = findViewById(R.id.score);
                                textView.setText("" + score);
                                imagebutton.setVisibility(View.INVISIBLE);
                            }
                        });

                        relativelayout.addView(imagebutton);

                    }
                });

            }
        };
        timer.scheduleAtFixedRate(timerTask, 2000, 800);

        Timer spawnCheck = new Timer();
        TimerTask spawnCheckTask = new TimerTask() {
            @Override
            public void run() {
                justSpawned = 0;
            }
        };


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Continue tapping 'Hello Worlds' to increase your score", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        /*
        helloWorldArray = new ArrayList<>();

        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ImageButton newFab = new ImageButton(thisObject);

                        RelativeLayout.LayoutParams rel_btn = new RelativeLayout.LayoutParams(
                                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                        rel_btn.leftMargin = 50;
                        rel_btn.topMargin =  50;
                        rel_btn.width = 20;
                        rel_btn.height = 20;

                        newFab.setImageResource(R.drawable.red);

                        helloWorldArray.add(newFab);
                    }
                });
            }

        };
        */

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
