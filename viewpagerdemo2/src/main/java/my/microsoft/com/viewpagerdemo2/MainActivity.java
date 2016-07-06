package my.microsoft.com.viewpagerdemo2;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager=null;
    private PagerTabStrip pagerTabStrip=null;
    List<View> viewlist=new ArrayList<>();
    List<String> titlelist=new ArrayList<>();
    LayoutInflater layoutInflater=null;
    Myadapter myadapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) this.findViewById(R.id.viewpager);
        pagerTabStrip= (PagerTabStrip) this.findViewById(R.id.tabstrip);
        //标签背景色
        pagerTabStrip.setBackgroundColor(Color.YELLOW);
        //标签下划线颜色
        pagerTabStrip.setTabIndicatorColor(Color.BLUE);
        layoutInflater=LayoutInflater.from(this);
        View view1= layoutInflater.inflate(R.layout.tab1,null);
        viewlist.add(view1);
        titlelist.add("title");
        myadapter=new Myadapter();
        viewPager.setAdapter(myadapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //页面被滑动,或者被触碰的时候被调用
            @Override
            public void onPageScrolled(int a, float b, int c) {
                Log.i("aaa","--a->>"+a);
                Log.i("aaa","--b->>"+b);
                Log.i("aaa","--c->>"+c);
                Log.i("aaa","---------------------------------------------");
            }

            //一个新的页面被选中时调用
            @Override
            public void onPageSelected(int position) {
                Log.i("aaa","--position->>"+position);
            }

            //滚动状态更改时调用
            @Override
            public void onPageScrollStateChanged(int d) {
                //在这个方法中加载下一页网络数据比较合理,因为这个方法如果执行了,那一定是开启了一个新的页面
                View view2=layoutInflater.inflate(R.layout.tab1,null);
                viewlist.add(view2);
                titlelist.add("new title");
                myadapter.notifyDataSetChanged();
                Log.i("aaa","*****-d-****"+d);
                Log.i("aaa","******************");
            }
        });

    }
    class Myadapter extends PagerAdapter{

        //标签的个数
        @Override
        public int getCount() {
            return viewlist.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(viewlist.get(position));
            return viewlist.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView(viewlist.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titlelist.get(position);
        }
    }
}
