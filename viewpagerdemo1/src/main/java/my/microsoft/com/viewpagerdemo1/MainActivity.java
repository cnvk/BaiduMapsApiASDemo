package my.microsoft.com.viewpagerdemo1;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager=null;
    PagerTabStrip tabStrip=null;
    List<View> viewlist =new ArrayList<>();
    List<String> titlelist =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) this.findViewById(R.id.viewpager);
        tabStrip= (PagerTabStrip) this.findViewById(R.id.tabstrip);
        //取消tab的下面的横线显示,可以不设置,因为加背景色之后会把这条线覆盖
        //tabStrip.setDrawFullUnderline(false);
        //设置tab的背景色
        tabStrip.setBackgroundColor(Color.YELLOW);
        //设置当前tab页签的下划线颜色
        tabStrip.setTabIndicatorColor(Color.BLUE);
        //标签文字之间的距离
        tabStrip.setTextSpacing(200);
        View view1= LayoutInflater.from(this).inflate(R.layout.tab1,null);
        View view2= LayoutInflater.from(this).inflate(R.layout.tab2,null);
        View view3= LayoutInflater.from(this).inflate(R.layout.tab3,null);
        viewlist.add(view1);
        viewlist.add(view2);
        viewlist.add(view3);
        titlelist.add("网易新闻");
        titlelist.add("网易体育");
        titlelist.add("网易游戏");
        viewPager.setAdapter(new Myadater());

    }
    class Myadater extends PagerAdapter{

        //viewpager中的组件数量,就是布局的个数
        @Override
        public int getCount() {
            return viewlist.size();
        }

        //滑动切换的时候销毁当前的组件
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //以下两句话,可以合并为一句((ViewPager) container).removeView(viewlist.get(position))
            ViewPager viewPager1= (ViewPager) container;
            viewPager1.removeView(viewlist.get(position));
            // super.destroyItem(container, position, object);
        }

        //每次滑动的时候生成的组件
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ViewPager viewPager1= (ViewPager) container;
            viewPager1.addView(viewlist.get(position));
            return viewlist.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        //显示标签文字,没有这个方法,标签不显示文字
        @Override
        public CharSequence getPageTitle(int position) {
            return titlelist.get(position);
        }
    }
}
