package my.microsoft.com.myanimationdemo1;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
/**
 * 帧动画,用布局实现,老师讲的,比网上的代码简单
 */

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    private Button btn1,btn2;
    private ImageView iv;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn1= (Button) this.findViewById(R.id.Main3Activity_btn1);
        btn2= (Button) this.findViewById(R.id.Main3Activity_btn2);
        iv= (ImageView) this.findViewById(R.id.Main3Activity_iv);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        animationDrawable= (AnimationDrawable) iv.getBackground();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Main3Activity_btn1:
                animationDrawable.start();
                break;
            case R.id.Main3Activity_btn2:
                animationDrawable.stop();
                break;
        }
    }
}
