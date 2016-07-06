package my.microsoft.com.gpsbaidumap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void btnclick(View view){
        switch (view.getId()){
            case R.id.MainActivity_btn1:
                intent=new Intent(this,CommonMapActivity.class);
                startActivity(intent);
                break;
            case R.id.MainActivity_btn2:
                intent=new Intent(this,GpsMapActivity.class);
                startActivity(intent);
                break;

        }
    }
}
