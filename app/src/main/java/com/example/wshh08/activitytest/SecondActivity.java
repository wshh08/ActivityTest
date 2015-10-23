package com.example.wshh08.activitytest;

//import android.content.Context;
import android.content.Intent;
//import android.opengl.GLES20;
//import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

//import java.util.jar.Attributes;

//import javax.microedition.khronos.egl.EGLConfig;
//import javax.microedition.khronos.opengles.GL10;
//import android.widget.Toast;
//import android.view.Window;

/**
 * Created by wshh08 on 15-10-15.
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello FirstActivity, BlaBlaBla...");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();
//        Log.d("SecondActivity", data);
//        MyGLSurfaceView glview = (MyGLSurfaceView)findViewById(R.id.gl_view);
//        MyGLSurfaceView glSurfaceView = (MyGLSurfaceView) findViewById(R.id.gl_view);
//        glSurfaceView = new MyGLSurfaceView(this);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Back Pressed");
        setResult(RESULT_OK, intent);
        finish();
    }
}
