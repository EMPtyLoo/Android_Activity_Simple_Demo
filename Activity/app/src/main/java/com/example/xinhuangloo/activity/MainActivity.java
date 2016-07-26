package com.example.xinhuangloo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //隐式跳转,
    public void dail(View v)
    {
        Log.d("d","开始拨号");
        //新建意图
        Intent intent = new Intent();
        //设置意图
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:110"));
        //启动
        startActivity(intent);
    }

    //显示跳转
    //同一应用中,指定目标Activity的字节码和当前上下文
    //不同应用中,指定目标Activity所在的应用的包名和目标Activity的包名加类名

    //隐式跳转
    //指定action和data



    //显示跳转到SecondActivity
    //这是在同一个应用里面的,所以不用指定包名
    public void jmp(View v)
    {
        Log.d("d","跳转到第二个界面");
        Intent intent = new Intent();
        //设置上下文和目标Activity的字节码
        intent.setClass(this,SecondActivity.class);
        startActivity(intent);
    }

    //显示跳转到打电话
    public void call(View v)
    {
        Log.d("d","显示跳转打电话");
        Intent intent = new Intent();
        //arg0:目标Activity所在应用的包名
        //arg1:目标Activity的类名,注意要带上包名
        intent.setClassName("com.android.dialer","com.android.dialer.DialtactsActivity");
        startActivity(intent);
    }

    //隐式跳转到第二个界面
    //隐式跳转会在所有清单文件中寻找与程序员创建的intent匹配的ointent-filter,找到则启动,找不到则异常
    //在清单文件的activity标签下,配置intent-filter字节点,其中再配置action和category
    //匹配就是intent-filter中定义了什么属性,程序员创建的intent也必须设置什么属性

    public void another(View v)
    {
        Log.d("d","隐式跳转第二个界面");
        Intent intent = new Intent();
        intent.setAction("a.b.c");

        //如果设置了data
//        //匹配scheme
//        intent.setData(Uri.parse("empty:12312"));
//        //匹配mimeType
//        intent.setType("text/name");
        //两个都要设置,要用下面这个方法
        intent.setDataAndType(Uri.parse("empty:123321"),"text/name");

        //如果没有设置category的匹配,那么自动默认default
        intent.addCategory(Intent.CATEGORY_DEFAULT);

        startActivity(intent);
    }

    public void send(View v)
    {
        EditText et_data1 = (EditText) findViewById(R.id.data1);
        EditText et_data2 = (EditText) findViewById(R.id.data2);

        String data1 = et_data1.getText().toString();
        String data2 = et_data2.getText().toString();
        //跳转到第二个视图 并展示出来
        Intent intent = new Intent();
//        intent.setAction("a.b.c");
//        intent.setDataAndType(Uri.parse("empty:123321"),"text/name");
        intent.setClass(this,SecondActivity.class);

        //把数据封装到intent中
        //intent中可以封装数据,数据有八大基本数据类型和字符串及它们的数据,还有实现了序列化接口对象,,还有bundle对象
        intent.putExtra("data1",data1);
        intent.putExtra("data2",data2);

//        //bundle中也可以用键值来封装数据,封装类型与intent一致
//        Bundle bundle = new Bundle();
//        bundle.putString("data1",data1);
//        intent.putExtra(bundle);

        startActivity(intent);
    }


}
