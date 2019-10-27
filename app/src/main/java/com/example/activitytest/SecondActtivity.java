package com.example.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActtivity extends BaseActivity {

        public static void actionStart(Context context, String data1,String data2) {
            Intent intent = new Intent(context, SecondActtivity.class);
            intent.putExtra("extra_data", data1);
            intent.putExtra("param2", data2);
            context.startActivity(intent);
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //下面是按钮的点击事件，弹出提示框
        final Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//              =================接受上一个活动传来的数据=====================
                Intent intent = getIntent();
                String data1 = intent.getStringExtra("extra_data");
                String data2 = intent.getStringExtra("param2");
                // 如果传来的数据是 int 则 getIntExtra ，如果是 Boolean 则 getBooleanExtra
                Log.d("SecondActtivity",data1);
                Toast.makeText(SecondActtivity.this,data2,Toast.LENGTH_SHORT).show();
//              =================向上一个活动传传递数据=====================
//                Intent intent = new Intent();
//                intent.putExtra("data_return","你好 第一个活动");  //向意图中加入要返回的 键和值
//                setResult(RESULT_OK,intent);    //设置返回数据给上一个活动，数据的处理结果 RESULT_OK = -1  或 RESULT_CANCELED = 0
//                ActivityCollector.finishAll();
                finish();
            }
        });
    }
//=================向上一个活动传传递数据 重写 按下返回键的事件=====================
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","你好 第一个活动");  //向意图中加入要返回的 键和值
        setResult(RESULT_OK,intent);    //设置返回数据给上一个活动，数据的处理结果 RESULT_OK = -1  或 RESULT_CANCELED = 0
        finish();
    }
}
