package com.example.rafflefoods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {

    public static final String RESTAURANT_ID_KEY = "restaurantId";
    public static final String DISTRICT = "district";
    private ImageView mImageIv;
    private TextView mRestaurantName, mRestaurantAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        //ActionBar actionBar = getSupportActionBar(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mImageIv = findViewById(R.id.imageView);
        mRestaurantName = findViewById(R.id.restaurantName);
        mRestaurantAddress = findViewById(R.id.restaurantAddress);

        Intent intent = getIntent();

        String district = intent.getStringExtra(DISTRICT);
        int restaurantId = intent.getIntExtra(RESTAURANT_ID_KEY,-1);

        if(restaurantId != -1){
            if(district.equals("luzhou")){
                Food incomingFood = Utils.getInstance(this).getLuzhouFoodsById(restaurantId);
                int images[] = {R.drawable.luzhou1,R.drawable.luzhou2,R.drawable.luzhou3,R.drawable.luzhou4,R.drawable.luzhou5,R.drawable.luzhou6,R.drawable.luzhou7,R.drawable.luzhou8,R.drawable.luzhou9,R.drawable.luzhou10,R.drawable.luzhou11,R.drawable.luzhou12,R.drawable.luzhou13,R.drawable.luzhou14,R.drawable.luzhou15};
                setData(incomingFood, images);
            }
            else if(district.equals("sanchong")){
                Food incomingFood = Utils.getInstance(this).getSanchongFoodsById(restaurantId);
                int images[] = {R.drawable.sanchong1,R.drawable.sanchong2,R.drawable.sanchong3,R.drawable.sanchong4,R.drawable.sanchong5,R.drawable.sanchong6,R.drawable.sanchong7,R.drawable.sanchong8,R.drawable.sanchong9,R.drawable.sanchong10};
                setData(incomingFood, images);
            }
            else if(district.equals("xinzhuang")){
                Food incomingFood = Utils.getInstance(this).getXinzhuangFoodsById(restaurantId);
                int images[] = {R.drawable.xinzhuang1,R.drawable.xinzhuang2,R.drawable.xinzhuang3,R.drawable.xinzhuang4,R.drawable.xinzhuang5,R.drawable.xinzhuang6,R.drawable.xinzhuang7,R.drawable.xinzhuang8,R.drawable.xinzhuang9,R.drawable.xinzhuang10};
                setData(incomingFood, images);
            }
            else if(district.equals("wugu")){
                Food incomingFood = Utils.getInstance(this).getWuguFoodsById(restaurantId);
                int images[] = {R.drawable.wugu1,R.drawable.wugu2,R.drawable.wugu3,R.drawable.wugu4,R.drawable.wugu5,R.drawable.wugu6,R.drawable.wugu7,R.drawable.wugu8,R.drawable.wugu9,R.drawable.wugu10};
                setData(incomingFood, images);
            }
            else if(district.equals("linkou")){
                Food incomingFood = Utils.getInstance(this).getLinkouFoodsById(restaurantId);
                int images[] = {R.drawable.linkou1,R.drawable.linkou2,R.drawable.linkou3,R.drawable.linkou4,R.drawable.linkou5,R.drawable.linkou6,R.drawable.linkou7,R.drawable.linkou8,R.drawable.linkou9,R.drawable.linkou10};
                setData(incomingFood, images);
            }
            else if(district.equals("beitou")){
                Food incomingFood = Utils.getInstance(this).getBeitouFoodsById(restaurantId);
                int images[] = {R.drawable.beitou1,R.drawable.beitou2,R.drawable.beitou3,R.drawable.beitou4,R.drawable.beitou5,R.drawable.beitou6,R.drawable.beitou7,R.drawable.beitou8,R.drawable.beitou9,R.drawable.beitou10};
                setData(incomingFood, images);
            }
            else{

            }

        }

    }

    private void setData(Food food, int images[]){
        mImageIv.setImageResource(images[food.getId()-1]);
        mRestaurantName.setText(food.getRestaurantName());
        mRestaurantAddress.setText(food.getRestaurantAddress());
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        //finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}