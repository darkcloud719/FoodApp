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

public class WuguActivity extends AppCompatActivity {

    private RestaurantRecViewAdapter adapter;

    int images[] = {R.drawable.wugu1,R.drawable.wugu2,R.drawable.wugu3,R.drawable.wugu4,R.drawable.wugu5,R.drawable.wugu6,R.drawable.wugu7,R.drawable.wugu8,R.drawable.wugu9,R.drawable.wugu10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wugu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.foodRecView);
        adapter = new RestaurantRecViewAdapter(this,images,"wugu");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setFoods(Utils.getInstance(this).getWuguFoods()) ;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
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
                intent.putExtra(DISTRICT,"wugu_food");
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}