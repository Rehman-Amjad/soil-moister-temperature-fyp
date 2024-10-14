package com.technogenis.soilmoiterhumidity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        textView=findViewById(R.id.textView);



        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.myanimation);
        textView.setAnimation(myanim);





        Thread mythread=new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(SplashScreen.this, LoginScreen.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        mythread.start();

    }
}