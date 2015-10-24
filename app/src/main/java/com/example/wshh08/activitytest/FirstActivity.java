package com.example.wshh08.activitytest;

// import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import android.net.Uri;
// import android.view.Window;
import butterknife.Bind;
import butterknife.ButterKnife;
//import com.example.test_module.MyClass;

/**
 * Created by wshh08 on 15-10-13.
 */
public class FirstActivity extends AppCompatActivity {
    @Bind(R.id.id_toolbar)
    Toolbar idToolbar;
    @Bind(R.id.button_1)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_layout);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        // toolbar.setNavigationIcon(R.drawable.s3);

        setSupportActionBar(toolbar);

        // toolbar.setTitle("Fuck the Title");
        // first_layout中Toolbar有app:title="..."时
        // 此句才能生效否则toolbar的title为Manifest中注册的activity的label.
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setSubtitle("SubTitle");


        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "You clicked Button 1",
                        Toast.LENGTH_SHORT).show();
                //使用intent
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                //String data = "Fuck You Intent......";
                //Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //intent.putExtra("extra_data", data);
                //startActivity(intent);
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Toast.makeText(FirstActivity.this, returnedData, Toast.LENGTH_SHORT).show();
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You Clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second_item:
                Intent intent = new Intent("com.example.wshh08.activitytest.ACTION_START");
                intent.addCategory("com.example.wshh08.activitytest.MY_CATEGORY");
                startActivity(intent);
                break;
            case R.id.quit_item:
                finish();
                break;
            default:
        }
        return true;
    }
}
