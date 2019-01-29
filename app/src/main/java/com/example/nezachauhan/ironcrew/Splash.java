package com.example.nezachauhan.ironcrew;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        imageView=(ImageView)findViewById(R.id.imageView1);
        /*Animation myanim = AnimationUtils.loadAnimation(Splash.this,R.anim.bounce);
        imageView.startAnimation(myanim);
*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the login-Activity. */
                Intent mainIntent = new Intent(Splash.this,Loginactivity.class);
                Splash.this.startActivity(mainIntent);

                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


    }
}
