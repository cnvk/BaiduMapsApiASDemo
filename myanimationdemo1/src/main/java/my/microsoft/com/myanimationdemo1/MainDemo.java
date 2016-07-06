package my.microsoft.com.myanimationdemo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo);
    }
    //补间动画
    public void tweenAnimation(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    //帧动画,布局实现,网上教程的方法
    public void frame(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    //帧动画,布局实现,老师讲的方法,较简便
    public void frame2(View view){
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
    //帧动画,代码实现
    public void frameJava(View view){
        Intent intent=new Intent(this,FrameActivity_java.class);
        startActivity(intent);
    }
}
