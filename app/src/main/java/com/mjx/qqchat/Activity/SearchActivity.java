package com.mjx.qqchat.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mjx.qqchat.Adapter.RVLabelADP;
import com.mjx.qqchat.Bean.LabelList;
import com.mjx.qqchat.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mjx on 2017/3/3.
 */

public class SearchActivity extends Activity {

    @BindView(R.id.tv_back_search)
    TextView tv_back_search;
    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.search_btn)
    Button search_btn;
    @BindView(R.id.recyclerview_search)
    RecyclerView rl_search;
    @BindView(R.id.wv_search)
    WebView wv_search;

    //搜索格式 url0 + url1 + 你要搜索的内容 + url2
    private static final String URL0 = "https://www.sogou.com/";
    private static final String URL1 = "web?query=";
    private static final String URL2 = "&_asf=www.sogou.com&_ast=&w=01019900&p=40040100&ie=utf8&from=index-nologin&sut=1624&sst0=1488510847223&lkt=0%2C0%2C0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search);
        ButterKnife.bind(this);
        init();
        setRVSearch();
    }

    private void init() {
        wv_search.getSettings().setJavaScriptEnabled(true);
        wv_search.setWebViewClient(new WebViewClient());
        wv_search.loadUrl(URL0);
    }

    private void setRVSearch() {

        String[] goals = new String[]{
                "Java","C语言","C++","JavaScript","C#","CSS","HTML5","IOS","Android","Linux",
                "PHP","(Visual)Basic","Python","Ruby"
        };
        int[] bgcolors = new int[]{
                R.drawable.shape_backgroud_label_0,
                R.drawable.shape_backgroud_label_1,
                R.drawable.shape_backgroud_label_2,
                R.drawable.shape_backgroud_label_3,
                R.drawable.shape_backgroud_label_4,
                R.drawable.shape_backgroud_label_5,
                R.drawable.shape_backgroud_label_6
        };
        List<LabelList> rvlist = new ArrayList<LabelList>();

        for(int i = 0;i<goals.length;i++){
            rvlist.add(new LabelList( goals[i] , bgcolors[ (i % (bgcolors.length))]));
        }
        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        rl_search.setLayoutManager(lm);
        rl_search.setAdapter(new RVLabelADP(rvlist,wv_search,URL0+URL1,URL2));



    }

    @OnClick({R.id.tv_back_search,R.id.search_btn})
    public void setSearchLayoutView(View v){
        switch (v.getId()){
            case R.id.tv_back_search:
                this.finish();
                break;
            case R.id.search_btn:
                String goal = et_search.getText().toString().trim();
                wv_search.loadUrl(URL0 + URL1 + goal + URL2);
                break;
            default:
                break;
        }
    }

}
