package news.biubiubiu.com.biubiubiunews.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import news.biubiubiu.com.biubiubiunews.R;

/**
 * @author WJB
 * @date 2018/11/23
 * 点击新闻后，跳转想详情页面的Activity，用的是网上的一个模板，
 */
public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTitle;
    private ImageButton ibMenu;
    private ImageButton ibBack;
    private ImageButton ibTextsize;
    private ImageButton ibShare;

    private WebView webview;
    private String url;
    private WebSettings webSettings;


    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-08-24 09:43:47 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        tvTitle = (TextView) findViewById(R.id.tv_titlel);
        ibMenu = (ImageButton) findViewById(R.id.ib_menu);
        ibBack = (ImageButton) findViewById(R.id.ib_back);
        ibTextsize = (ImageButton) findViewById(R.id.ib_textsize);
        ibShare = (ImageButton) findViewById(R.id.ib_share);
        webview = (WebView) findViewById(R.id.webview);

        tvTitle.setVisibility(View.GONE);
        ibMenu.setVisibility(View.GONE);
        ibBack.setVisibility(View.VISIBLE);
        ibTextsize.setVisibility(View.VISIBLE);
        ibShare.setVisibility(View.VISIBLE);

        ibBack.setOnClickListener(this);
        ibTextsize.setOnClickListener(this);
        ibShare.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2016-08-24 09:43:47 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == ibBack) {
            // Handle clicks for ibBack
            finish();
        } else if (v == ibTextsize) {
            // Handle clicks for ibTextsize
//            Toast.makeText(NewsDetailActivity.this, "设置文字大小", Toast.LENGTH_SHORT).show();
            showChangeTextSizeDialog();
        } else if (v == ibShare) {
            // Handle clicks for ibShare
//            Toast.makeText(NewsDetailActivity.this, "分享", Toast.LENGTH_SHORT).show();
            showShare();
        }
    }

    private int tempSize = 2;
    private int realSize = tempSize;

    private void showChangeTextSizeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置文字大小");
        String[] items = {"超大字体","大字体","正常字体","小字体","超小字体"};
        builder.setSingleChoiceItems(items, realSize, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tempSize = which;
            }
        });
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                realSize = tempSize;
                changeTextSize(realSize);
            }
        });
        builder.show();

    }

    private void changeTextSize(int realSize) {
        switch (realSize) {
            case 0:
                //超大字体
                webSettings.setTextZoom(200);
                break;
            case 1:
                //大字体
                webSettings.setTextZoom(150);
                break;
            case 2:
                //正常字体
                webSettings.setTextZoom(100);
                break;
            case 3:
                //小字体
                webSettings.setTextZoom(75);
                break;
            case 4:
                //超小字体
                webSettings.setTextZoom(50);
                break;

            default:
                break;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置没有标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_news_detail);
        findViews();
        getData();
    }

    private void showShare() {
//        ShareSDK.initSDK(this);
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//
//// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
//        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
//        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
//        oks.setTitle(getString(R.string.app_name));
//        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
//        oks.setTitleUrl("http://atguigu.com/teacher.shtml");
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText("儿子发烧了。我抱着他测体温。看着儿子烧到三十八度多了。我心疼的对儿子说:“宝宝,你想要什么呀?爸爸去给你买!”儿子眼睛一亮,灰常灰常高兴的说:“我想吃雪糕。”我说不行,换一个!儿子想了想接着说:“我想要妈妈给我生个哥哥...”你还是吃雪糕吧……");
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        // url仅在微信（包括好友和朋友圈）中使用
//        oks.setUrl("http://atguigu.com/teacher.shtml");
//        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("平生不识尚硅谷，阅尽Android也枉然");
//        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite(getString(R.string.app_name));
//        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://atguigu.com/teacher.shtml");
//
//// 启动分享GUI
//        oks.show(this);
    }

    private void getData() {
        url = getIntent().getStringExtra("url");

        //设置支持javaScript
        webSettings = webview.getSettings();
        //设置支持javaScript
        webSettings.setJavaScriptEnabled(true);
        //设置双击变大变小
        webSettings.setUseWideViewPort(true);
        //增加缩放按钮
        webSettings.setBuiltInZoomControls(true);
        //设置文字大小
//        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings.setTextZoom(100);
        //不让从当前网页跳转到系统的浏览器中
        webview.setWebViewClient(new WebViewClient() {
            //当加载页面完成的时候回调
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webview.loadUrl(url);
//        webview.loadUrl("http://www.atguigu.com/teacher.shtml");

    }

}
