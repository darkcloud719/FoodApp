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

public class BeitouActivity extends AppCompatActivity {

    private RestaurantRecViewAdapter adapter;

    int images[] = {R.drawable.beitou1,R.drawable.beitou2,R.drawable.beitou3,R.drawable.beitou4,R.drawable.beitou5,R.drawable.beitou6,R.drawable.beitou7,R.drawable.beitou8,R.drawable.beitou9,R.drawable.beitou10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beitou);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.foodRecView);
        adapter = new RestaurantRecViewAdapter(this,images,"beitou");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setFoods(Utils.getInstance(this).getBeitouFoods());
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
                intent.putExtra(DISTRICT,"beitou_food");
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}