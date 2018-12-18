package news.biubiubiu.com.biubiubiunews;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;

import news.biubiubiu.com.biubiubiunews.model.MyAdapter;
import news.biubiubiu.com.biubiubiunews.view.FragmentFactory;
import news.biubiubiu.com.biubiubiunews.view.fragment.BaseFragment;
import news.biubiubiu.com.biubiubiunews.view.fragment.TopFragment;


/**
 * 自动生成的作者  换成你们的
 * @author WJB
 */
public class MainActivity extends AppCompatActivity {
    /**
     * 顶部导航栏
     */
    private PagerSlidingTabStrip mPagerTab;
    /**
     * 导航栏对应的新闻分类列表页面
     */
    private ViewPager mViewPager;
    /**
     * 新闻Adapter
     */
    private MyAdapter mAdapter;
    /**
     * fragment
     */
    public BaseFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fragment=new TopFragment();

        //拿到对应的控件
        mPagerTab = findViewById(R.id.ps_tab);
        mViewPager = findViewById(R.id.vp_news);

        mAdapter =new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        // 导航栏绑定ViewPager
        mPagerTab.setViewPager(mViewPager);
        // 对用户滑动界面的监听。根据滑动到的页面，去读取改页面对应的信息
        mPagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //监听到页面滑动了，就开始生产对应页面 ，比如滑动到了健康页面，就会加载健康类型的新闻信息，然后显示
                fragment= FragmentFactory.createFragment(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
