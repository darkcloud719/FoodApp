package com.example.rafflefoods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import static com.example.rafflefoods.RestaurantActivity.DISTRICT;
import static com.example.rafflefoods.RestaurantActivity.RESTAURANT_ID_KEY;

public class LuzhouActivity extends AppCompatActivity{

    private RestaurantRecViewAdapter adapter;

    int images[] = {R.drawable.luzhou1,R.drawable.luzhou2,R.drawable.luzhou3,R.drawable.luzhou4,R.drawable.luzhou5,R.drawable.luzhou6,R.drawable.luzhou7,R.drawable.luzhou8,R.drawable.luzhou9,R.drawable.luzhou10,R.drawable.luzhou11,R.drawable.luzhou12,R.drawable.luzhou13,R.drawable.luzhou14,R.drawable.luzhou15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luzhou);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView  = findViewById(R.id.foodRecView);
        adapter = new RestaurantRecViewAdapter(this,images,"luzhou");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter.setFoods(Utils.getInstance(this).getLuzhouFoods());
        adapter.notifyDataSetChanged();
        //adapter.setFoods(Utils.getI)

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.dice:
                Intent intent = new Intent(this, LotteryActivity.class);
                intent.putExtra(DISTRICT,"luzhou_food");
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}