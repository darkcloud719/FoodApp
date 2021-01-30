package com.example.rafflefoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

import static com.example.rafflefoods.RestaurantActivity.DISTRICT;
import static com.example.rafflefoods.RestaurantActivity.RESTAURANT_ID_KEY;

public class LotteryActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 1300;


    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);

        Intent intent = getIntent();
        String district = intent.getStringExtra(DISTRICT);

        if(district.equals("luzhou_food")){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    int size = Utils.getInstance(LotteryActivity.this).getLuzhouFoodNumber();
                    int r = (int)(Math.random()*size);
                    r+=1;
                    Intent intent  = new Intent(LotteryActivity.this, RestaurantActivity.class);
                    intent.putExtra(DISTRICT,"luzhou");
                    intent.putExtra(RESTAURANT_ID_KEY,r);
                    startActivity(intent);
                }
            },SPLASH_SCREEN);
        }
        else if(district.equals("sanchong_food")){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    int size = Utils.getInstance(LotteryActivity.this).getSanchongFoodNumber();
                    int r = (int)(Math.random()*size);
                    r+=1;
                    Intent intent = new Intent(LotteryActivity.this, RestaurantActivity.class);
                    intent.putExtra(DISTRICT,"sanchong");
                    intent.putExtra(RESTAURANT_ID_KEY,r);
                    startActivity(intent);
                }
            },SPLASH_SCREEN);
        }
        else if(district.equals("xinzhuang_food")){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    int size = Utils.getInstance(LotteryActivity.this).getXinzhuangFoodNumber();
                    int r = (int)(Math.random()*size);
                    r+=1;
                    Intent intent = new Intent(LotteryActivity.this, RestaurantActivity.class);
                    intent.putExtra(DISTRICT,"xinzhuang");
                    intent.putExtra(RESTAURANT_ID_KEY,r);
                    startActivity(intent);
                }
            },SPLASH_SCREEN);
        }
        else if(district.equals("wugu_food")){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    int size = Utils.getInstance(LotteryActivity.this).getWuguFoodNumber();
                    int r = (int)(Math.random()*size);
                    r+=1;
                    Intent intent = new Intent(LotteryActivity.this, RestaurantActivity.class);
                    intent.putExtra(DISTRICT,"wugu");
                    intent.putExtra(RESTAURANT_ID_KEY,r);
                    startActivity(intent);
                }
            },SPLASH_SCREEN);
        }
        else if(district.equals("linkou_food")){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    int size = Utils.getInstance(LotteryActivity.this).getLinkouFoodNumber();
                    int r = (int)(Math.random()*size);
                    r+=1;
                    Intent intent = new Intent(LotteryActivity.this, RestaurantActivity.class);
                    intent.putExtra(DISTRICT,"linkou");
                    intent.putExtra(RESTAURANT_ID_KEY,r);
                    startActivity(intent);
                }
            },SPLASH_SCREEN);
        }
        else if(district.equals("beitou_food")){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    int size = Utils.getInstance(LotteryActivity.this).getBeitouFoodNumber();
                    int r = (int)(Math.random()*size);
                    r+=1;
                    Intent intent = new Intent(LotteryActivity.this, RestaurantActivity.class);
                    intent.putExtra(DISTRICT,"beitou");
                    intent.putExtra(RESTAURANT_ID_KEY,r);
                    startActivity(intent);
                }
            },SPLASH_SCREEN);
        }
        else{
            intent = new Intent(LotteryActivity.this,MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,LuzhouActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}