package com.ima.wispro.kisah25nabi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

/**
 * Created by Win8 on 26/12/2015.
 */
public class Splash extends AppCompatActivity {
    private	long ms	=0;
    private	long splashTime=3000;
    private	boolean	splashActive = true;
    private	boolean	paused=	false;

    void startAnim(){
        findViewById(R.id.avloadingIndicatorView).setVisibility(View.VISIBLE);
    }

    void stopAnim(){
        findViewById(R.id.avloadingIndicatorView).setVisibility(View.GONE);
    }
    @Override

    protected void onCreate(Bundle savedInstanceState)	   {


        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //Hides	   the	   titlebar

        setContentView(R.layout.splash);

        Thread mythread = new	   Thread()	   {
            public	   void	   run()	   {
                try	{
                    while (splashActive	&& ms <	splashTime){
                        if (!paused)
                            ms = ms + 100;
                        sleep(100);
                    }
                } catch(Exception e) {
                } finally {
                    Intent intent =	new	Intent(Splash.this,
                            MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        mythread.start();

    }
}
