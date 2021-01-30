package com.example.rafflefoods;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static com.example.rafflefoods.RestaurantActivity.DISTRICT;

public class MainActivity extends AppCompatActivity {

    private Button btnLuzhouDist, btnSanchongDist, btnXinzhuangDist, btnLinkouDist, btnWuguDist, btnBeitouDist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnLuzhouDist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,LuzhouActivity.class);
                startActivity(intent);
            }
        });

        btnSanchongDist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,SanchongActivity.class);
                startActivity(intent);
            }
        });

        btnXinzhuangDist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,XinzhuangActivity.class);
                startActivity(intent);
            }
        });

        btnLinkouDist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,LinkouActivity.class);
                startActivity(intent);
            }
        });

        btnWuguDist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,WuguActivity.class);
                startActivity(intent);
            }
        });

        btnBeitouDist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,BeitouActivity.class);
                startActivity(intent);
            }
        });
    }



    public void initViews(){
        btnLuzhouDist = findViewById(R.id.btn_luzhou_dist);
        btnSanchongDist = findViewById(R.id.btn_sanchong_dist);
        btnXinzhuangDist = findViewById(R.id.btn_xinzhuang_dist);
        btnLinkouDist = findViewById(R.id.btn_linkou_dist);
        btnWuguDist = findViewById(R.id.btn_wugu_dist);
        btnBeitouDist = findViewById(R.id.btn_beitou_dist);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        districtDialog();
        if(id==R.id.dice){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void districtDialog(){
        String[] options = {"蘆洲區","三重區","新莊區","林口區","五股區","北投區"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("區域");
        builder.setIcon(R.drawable.ic_action_location);

        builder.setItems(options, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                if(which == 0){
                    Intent intent = new Intent(MainActivity.this, LotteryActivity.class);
                    intent.putExtra(DISTRICT,"luzhou_food");
                    startActivity(intent);
                }
                else if(which == 1){
                    Intent intent = new Intent(MainActivity.this, LotteryActivity.class);
                    intent.putExtra(DISTRICT,"sanchong_food");
                    startActivity(intent);
                }
                else if(which == 2){
                    Intent intent = new Intent(MainActivity.this, LotteryActivity.class);
                    intent.putExtra(DISTRICT,"xinzhuang_food");
                    startActivity(intent);
                }
                else if(which == 3){
                    Intent intent = new Intent(MainActivity.this, LotteryActivity.class);
                    intent.putExtra(DISTRICT,"linkou_food");
                    startActivity(intent);
                }
                else if(which == 4){
                    Intent intent = new Intent(MainActivity.this, LotteryActivity.class);
                    intent.putExtra(DISTRICT,"wugu_food");
                    startActivity(intent);
                }
                else if(which == 5){
                    Intent intent = new Intent(MainActivity.this, LotteryActivity.class);
                    intent.putExtra(DISTRICT,"beitou_food");
                    startActivity(intent);
                }
            }

        });

        builder.create().show();
    }

}