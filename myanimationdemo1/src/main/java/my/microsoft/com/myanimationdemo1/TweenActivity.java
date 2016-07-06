package my.microsoft.com.myanimationdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

//补间动画,xml文件实现方式,需要anim文件夹下的xml文件
public class TweenActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView iv;
    Button btn1,btn2,btn3,btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        iv= (ImageView) this.findViewById(R.id.TweenActivity_iv);
        btn1= (Button) this.findViewById(R.id.TweenActivity_btn1);
        btn1.setOnClickListener(this);
        btn2= (Button) this.findViewById(R.id.TweenActivity_btn2);
        btn2.setOnClickListener(this);
        btn3= (Button) this.findViewById(R.id.TweenActivity_btn3);
        btn3.setOnClickListener(this);
        btn4= (Button) this.findViewById(R.id.TweenActivity_btn4);
        btn4.setOnClickListener(this);
        btn5= (Button) this.findViewById(R.id.TweenActivity_btn5);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.TweenActivity_btn1:
                Animation animation=AnimationUtils.loadAnimation(this,R.anim.tween_xml);
                iv.startAnimation(animation);
                break;
            case R.id.TweenActivity_btn2:
                Animation animation1=AnimationUtils.loadAnimation(this,R.anim.tween_scal);
                iv.startAnimation(animation1);
                break;
            case R.id.TweenActivity_btn3:
                Animation animation2=AnimationUtils.loadAnimation(this,R.anim.tween_tran);
                iv.startAnimation(animation2);
                break;
            case R.id.TweenActivity_btn4:
                Animation animation3=AnimationUtils.loadAnimation(this,R.anim.tween_rotate);
                iv.startAnimation(animation3);
                break;
            case R.id.TweenActivity_btn5:
                Animation animation4=AnimationUtils.loadAnimation(this,R.anim.tween_set);
                iv.startAnimation(animation4);
                break;
        }

    }
}
