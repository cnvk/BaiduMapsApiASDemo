package my.microsoft.com.propertyanimation1;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void imganimation(View view){
        //rotationX  X轴水平旋转
        ObjectAnimator.ofFloat(view,"rotationY",0.0f,360.0f).setDuration(500).start();
    }
}
