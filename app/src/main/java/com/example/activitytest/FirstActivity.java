package com.example.activitytest;   //右键com.example.activitytest -- New -- Activity --- Empty Activity 手动创建Activity

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "保存的数据去";
        outState.putString("data_key",tempData);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        if (savedInstanceState != null){
            String tempData = savedInstanceState.getString("data_key");
            Log.d("123",tempData);

        }
        //调用 setContentView 给 activity 加载 一个布局，参数 布局文件的 ID，项目中任何资源都会在R文件中生成一个相应的资源Id
        //加载了布局，还需要在 AndroidManifest 文件中注册 文件在 app/src/main/android-Manifest.xml 里

        //下面是按钮的点击事件，弹出提示框
        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(FirstActivity.this,"传送数据给第二个活动",Toast.LENGTH_SHORT).show();
//                //创建一个 intent 对象，在第一个活动的基础上打开第二个活动
//                Intent intent = new Intent(FirstActivity.this,SecondActtivity.class);
//                //启动 intent 对象，打开第二个活动
//                startActivity(intent);
                // 隐式 启动活动 intent 指定注册文件里被注册过的某个活动
//                Intent intent = new Intent("com.example.activitytest.ACTION_START");
//                // 在 AndroidManifest 页中，定义了的category，可以直接添加指定需要调用的活动 必须和 action 在一个活动中匹配
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                startActivity(intent);
                //更多的隐式 调用，可以调用其他程序的 活动，例如：浏览器
//                Intent intent = new Intent(Intent.ACTION_VIEW);         // Intent.ACTION_VIEW android 系统的内置动作 可打开网页
//                intent.setData(Uri.parse("http://www.baidu.com"));      // setData 调用 把 一个 URI 对象传递进去后，打开浏览器 浏览百度

//                Intent intent = new Intent(Intent.ACTION_DIAL);         // Intent.ACTION_DIAL android 系统的内置动作 可 调出拨号器 打电话
//                intent.setData(Uri.parse("tel:10086"));      // setData 调用 把 一个 URI 对象传递进去后，打电话 10086 "tel:10086" geo
//                //Intent 的 内置动作 很多 ，可以查 帮助文档 例如：定位了什么的
//                startActivity(intent);
                //finish();
////              ==================数据传递给下一个活动===================
//                String data = "你好，第二个活动";
//                Intent intent = new Intent(FirstActivity.this,SecondActtivity.class);
//                //启动 intent 对象，打开第二个活动
//                intent.putExtra("extra_data",data); // 传送的数据为字符串，需要使用 getStringExtra接收
//                startActivity(intent);
//              ==================从下一个活动中返回数据===================
//                Intent intent = new Intent(FirstActivity.this,SecondActtivity.class);
//                startActivityForResult(intent,1);   //第二个参数为 请求码 必须是唯一值
////              使用 startActivityForResult 启动 SecondActtivity 并且当关闭 SecondActtivity 时 返回一个数据

                SecondActtivity.actionStart( FirstActivity.this,"数据1","数据2");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建一个 intent 对象，在第一个活动的基础上打开第二个活动
                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
                //启动 intent 对象，打开第二个活动
                startActivity(intent);
            }
        });

    }
//              ==================从下一个活动中返回数据,需要重写 onActivityResult===================
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){       // 启动活动时 的 请求码
            case 1:
                if (resultCode == RESULT_OK) {      // 返回数据时传入的处理结果
                    String returnedData = data.getStringExtra("data_return");   //使用键 来接收 值
                    Toast.makeText(FirstActivity.this,returnedData,Toast.LENGTH_SHORT).show();
                    Button button1 = (Button) findViewById(R.id.button_1);
                    button1.setText(returnedData);
                }

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"点击了添加",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"点击了删除",Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_item:
                Toast.makeText(this,"点击了退出",Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
        }
        return true;
    }
}
