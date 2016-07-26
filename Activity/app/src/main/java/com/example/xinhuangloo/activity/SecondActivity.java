package com.example.xinhuangloo.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by XinhuangLoo on 7/22/16.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        //获取启动该Activity的意图对象
//        Intent intent = getIntent();
//        Uri uri = intent.getData();
//        Log.d("d",uri.toString());

        Intent intent = getIntent();
        String data1 = intent.getStringExtra("data1");
        String data2 = intent.getStringExtra("data2");
        TextView tv_data1 = (TextView) findViewById(R.id.data1);
        TextView tv_data2 = (TextView) findViewById(R.id.data2);
        tv_data1.setText(data1);
        tv_data2.setText(data2);

//        Bundle bundle = intent.getExtras();
//        String Data1 = bundle.getString("dataa");

    }
}
