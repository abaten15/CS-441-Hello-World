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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageButton> helloWorldArray;

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

        Timer timer = new Timer(500, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();

        final ImageButton imagebutton = new ImageButton(MainActivity.this);
        RelativeLayout relativelayout = (RelativeLayout)findViewById(R.id.relativelayout);
        LinearLayout.LayoutParams params = new LinearLayout
                .LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.height = 300;
        params.width = 300;

        imagebutton.setBackground(null);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationY", 1000f);
                animation.setDuration(2000);
                animation.start();
                /*
                ViewGroup.LayoutParams params1 = view.getLayoutParams();
                params1. = params1.topMargin + 10;
                view.setLayoutParams(params1);
                */
            }
        });

        // Add image path for imagebutton from drawable folder.
        imagebutton.setImageResource(R.drawable.red);
        imagebutton.setLayoutParams(params);
        relativelayout.addView(imagebutton);

/*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.hello);
                textView.setText("Goodbye World");
                Snackbar.make(view, "Continue tapping 'Hello Worlds' to increase your score", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                ImageButton newFab = new ImageButton(v);

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

            }
        });
*/

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
