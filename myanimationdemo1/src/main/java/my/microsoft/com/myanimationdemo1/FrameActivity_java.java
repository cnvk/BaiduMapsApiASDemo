package my.microsoft.com.myanimationdemo1;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 帧动画,用代码实现
 */
public class FrameActivity_java extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2;
    ImageView iv;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_activity_java);
        btn1= (Button) this.findViewById(R.id.FrameActivity_java_btn1);
        btn2= (Button) this.findViewById(R.id.FrameActivity_java_btn2);
        iv= (ImageView) this.findViewById(R.id.FrameActivity_java_iv);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        animationDrawable=new AnimationDrawable();
        for (int i=1;i<7;i++){
            //根据包名，类名，文件名从R文件获得资源ID
            int rsID=getResources().getIdentifier("icon"+i,"drawable","my.microsoft.com.myanimationdemo1");
            //根据资源ID获得资源对象
            Drawable drawable=getResources().getDrawable(rsID);
            //给动画添加图片
            animationDrawable.addFrame(drawable,200);
            animationDrawable.setOneShot(false);
        }
        //让我们的动画与ImageView产生关联关系
        iv.setImageDrawable(animationDrawable);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.FrameActivity_java_btn1:
                animationDrawable.start();
                break;
            case R.id.FrameActivity_java_btn2:
                animationDrawable.stop();
                break;
        }

    }
}
