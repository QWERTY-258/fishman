package com.example.fish_2;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Logo_Activity extends Activity {
    private Animation logoAnim;
    private Animation buttonLogoAnim;
    //private Button bAnim;

    private ImageView logoImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        init();
        startMainActivity();

    }
    private void init(){
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_anim);
        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_anim);


        logoImage = findViewById(R.id.profile_image);
        //bAnim = findViewById(R.id.button);

        logoImage.startAnimation(logoAnim);
        //bAnim.startAnimation(buttonLogoAnim);
    }

    public void onClickStart(View view) {
        Intent i = new Intent(Logo_Activity.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    private void startMainActivity(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(Logo_Activity.this,MainActivity.class);
                startActivity(i);
            }
        }).start();
    }
}
