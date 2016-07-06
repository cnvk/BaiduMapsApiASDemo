package my.microsoft.com.myanimationdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * 补间动画,java代码实现
 * 几种基本的动画
 */
public class MainActivity extends AppCompatActivity {
    private Animation animation;
    private ImageView iv;
    private AlphaAnimation alphaAnimation;//透明度动画
    private ScaleAnimation scaleAnimation;//渐变动画
    private TranslateAnimation translateAnimation;//位移动画
    private RotateAnimation rotateAnimation;//旋转动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv= (ImageView) this.findViewById(R.id.iv);
    }
    public void flash(View v){
        switch (v.getId()){
            case R.id.btn1:
            animation=new AlphaAnimation(0.1f,1.0f);//透明度动画
                animation.setDuration(3000);
                iv.setAnimation(animation);
                break;
            case R.id.btn2:
            animation=new ScaleAnimation(0.1f,1.0f,0.1f,1.0f);//渐变(缩放)动画
                animation.setDuration(2000);
                iv.setAnimation(animation);
                break;
            case R.id.btn3:
                animation=new TranslateAnimation(0.1f,100.0f,0.1f,100.0f);//位移动画
                animation.setDuration(3000);
                iv.setAnimation(animation);

                break;
            case R.id.btn4:
                animation=new RotateAnimation(0,360);//旋转动画
                animation.setDuration(3000);
                iv.setAnimation(animation);
                break;
            case R.id.btn5:
                alphaAnimation=new AlphaAnimation(0.1f,1.0f);
                scaleAnimation=new ScaleAnimation(0.1f,1.0f,0.1f,1.0f);
                translateAnimation=new TranslateAnimation(0.1f,100.0f,0.1f,100.0f);
                rotateAnimation=new RotateAnimation(0,360);
                AnimationSet setfalsh=new AnimationSet(true);//ture是使用动画集的速率,false是使用各自的速率
                setfalsh.addAnimation(alphaAnimation);
                setfalsh.addAnimation(scaleAnimation);
                setfalsh.addAnimation(translateAnimation);
                setfalsh.addAnimation(rotateAnimation);
                setfalsh.setDuration(3000);
                iv.setAnimation(setfalsh);
                break;
        }
    }
}
