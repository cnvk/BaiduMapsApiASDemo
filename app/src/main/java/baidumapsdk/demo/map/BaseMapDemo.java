package baidumapsdk.demo.map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 演示MapView的基本用法
 */
public class BaseMapDemo extends Activity {

    @SuppressWarnings("unused")
    private static final String LTAG = BaseMapDemo.class.getSimpleName();
    //定义一个mapview(mapview这个类在jar包里写好的)对象
    private MapView mMapView;
    //帧布局
    FrameLayout layout;
    //两个单选按钮的id
    private static final int OPEN_ID = 0;
    private static final int CLOSE_ID = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //设置是否开启个性化地图
        MapView.setMapCustomEnable(true);
        super.onCreate(savedInstanceState);
        //加载个性化地图文件
        setMapCustomFile(this);
        mMapView = new MapView(this, new BaiduMapOptions());
        initView(this);
        setContentView(layout);
    }

    // 初始化View
    private void initView(Context context) {
        layout = new FrameLayout(this);
        //把mMapView填充到帧布局
        layout.addView(mMapView);
        //设置单选按钮Group
        RadioGroup group = new RadioGroup(context);
        group.setBackgroundColor(Color.BLACK);
        //第一个单选按钮
        final RadioButton openBtn = new RadioButton(context);
        openBtn.setText("开启个性化地图");
        openBtn.setId(OPEN_ID);
        openBtn.setTextColor(Color.WHITE);
        //设置包裹内容
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        //默认选中状态
        openBtn.setChecked(true);

        group.addView(openBtn, params);
        //第二个单选按钮
        final RadioButton closeBtn = new RadioButton(context);
        closeBtn.setText("关闭个性化地图");
        closeBtn.setTextColor(Color.WHITE);
        closeBtn.setId(CLOSE_ID);
        group.addView(closeBtn, params);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.addView(group, layoutParams);
        //判断按钮id,切换普通和个性化视图
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == OPEN_ID) {
                    MapView.setMapCustomEnable(true);
                } else if (checkedId == CLOSE_ID) {
                    MapView.setMapCustomEnable(false);
                }
            }
        });
    }

    // 设置个性化地图config文件路径
    private void setMapCustomFile(Context context) {
        FileOutputStream out = null;
        InputStream inputStream = null;
        String moduleName = null;
        try {
            //从customConfigdir/custom_config.txt获取输入流
            inputStream = context.getAssets()
                    .open("customConfigdir/custom_config.txt");
            //inputStream.available()获取流中可读取的数据大小
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            ///moduleName=data/data/包名路径
            moduleName = context.getFilesDir().getAbsolutePath();
            File f = new File(moduleName + "/" + "custom_config.txt");
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            out = new FileOutputStream(f);
            out.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MapView.setCustomMapStylePath(moduleName + "/custom_config.txt");

    }

    @Override
    protected void onPause() {
        super.onPause();
        // activity 暂停时同时暂停地图控件
        mMapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // activity 恢复时同时恢复地图控件
        mMapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // activity 销毁时同时销毁地图控件
        mMapView.onDestroy();
        MapView.setMapCustomEnable(false);
    }

}
