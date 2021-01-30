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

public class XinzhuangActivity extends AppCompatActivity {

    private RestaurantRecViewAdapter adapter;

    int images[] = {R.drawable.xinzhuang1,R.drawable.xinzhuang2,R.drawable.xinzhuang3,R.drawable.xinzhuang4,R.drawable.xinzhuang5,R.drawable.xinzhuang6,R.drawable.xinzhuang7,R.drawable.xinzhuang8,R.drawable.xinzhuang9,R.drawable.xinzhuang10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xinzhuang);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.foodRecView);
        adapter = new RestaurantRecViewAdapter(this,images,"xinzhuang");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter.setFoods(Utils.getInstance(this).getXinzhuangFoods());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
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
                intent.putExtra(DISTRICT,"xinzhuang_food");
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}