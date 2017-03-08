package com.mjx.qqchat.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;

import com.mjx.qqchat.Adapter.MainPagerADP;
import com.mjx.qqchat.Adapter.RecyclerViewLeftADP;
import com.mjx.qqchat.Bean.ActiveUserInformation;
import com.mjx.qqchat.Bean.LeftList;
import com.mjx.qqchat.Fragment.ManFgm;
import com.mjx.qqchat.Fragment.MsgFgm;
import com.mjx.qqchat.Fragment.TrendFgm;
import com.mjx.qqchat.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;


/**
 * Created by 马景祥 on 2017/3/1.
 *  一款模仿QQ的聊天软件
 */
public class MainActivity extends FragmentActivity {

    @BindView(R.id.viewpager_mainpage)
    ViewPager mainpager;
    @BindView(R.id.recyclerview_left)
    RecyclerView recyclerView_left;
    @BindView(R.id.btn_msg_bottomBar)
    RadioButton btn_msg_bottomBar;
    @BindView(R.id.btn_man_bottomBar)
    RadioButton btn_man_bottomBar;
    @BindView(R.id.btn_trend_bottomBar)
    RadioButton btn_trend_bottomBar;
    @BindView(R.id.drawerlayout_main)
    DrawerLayout drawerlayout_main;


    private List<RadioButton> botttombarRBlist;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                //设置左边抽屉打开
                case 0:
                    drawerlayout_main.openDrawer(Gravity.LEFT);
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        init();
        setMainPager();
        setDrawerLeft();

    }

    //初始化设置
    private void init() {

        btn_msg_bottomBar.setChecked(true);

        //这里设置clickable(true)  必须动态设置  静态设置没有效果
        //解决问题   侧滑菜单出来的时候 点击菜单上的区域会有点击穿透问题
        drawerlayout_main.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                drawerView.setClickable(true);
            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    //初始化数据
    private void initData() {

        //设置当前用户信息
        ActiveUserInformation activeUserInformation = new ActiveUserInformation();
        activeUserInformation.setImage(R.mipmap.yellowduck);
        activeUserInformation.setName(this.getString(R.string.activeUserName));


        botttombarRBlist = new ArrayList<RadioButton>();
        botttombarRBlist.add(btn_msg_bottomBar);
        botttombarRBlist.add(btn_man_bottomBar);
        botttombarRBlist.add(btn_trend_bottomBar);


    }

    //设置底部按钮监听页面切换
    @OnClick({R.id.btn_msg_bottomBar, R.id.btn_man_bottomBar, R.id.btn_trend_bottomBar})
    public void setBottomBar(RadioButton rb) {
        switch (rb.getId()) {
            case R.id.btn_msg_bottomBar:
                mainpager.setCurrentItem(0);
                break;
            case R.id.btn_man_bottomBar:
                mainpager.setCurrentItem(1);
                break;
            case R.id.btn_trend_bottomBar:
                mainpager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    //设置页面滑动后监听底部栏的切换
    @OnPageChange(R.id.viewpager_mainpage)
    public void setMainpager(int position) {
        botttombarRBlist.get(position).setChecked(true);
    }

    //设置左边的抽屉
    private void setDrawerLeft() {
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_left.setLayoutManager(lm);
        recyclerView_left.setAdapter(new RecyclerViewLeftADP(recyclerView_LeftData()));
    }

    //左边抽屉的菜单RecyclerView数据
    private List<LeftList> recyclerView_LeftData() {

        //设置mainpager的fragment数据
        List<LeftList> rv_list = new ArrayList<LeftList>();
        for (int i = 0; i < 5; i++) {
            rv_list.add(new LeftList(R.mipmap.icon_eye_green, "第　" + i + " 个选项"));
            rv_list.add(new LeftList(R.mipmap.icon_game_blue, "第　" + i + " 个选项"));
            rv_list.add(new LeftList(R.mipmap.icon_leaf_orange, "第　" + i + " 个选项"));
        }

        return rv_list;
    }

    //设置主页面的viewpager的fragment的数目
    private List<Fragment> mainpagerData() {

        //设置mainpager的fragment数据
        List<Fragment> mp_list = new ArrayList<Fragment>();
        mp_list.add(new MsgFgm());
        mp_list.add(new ManFgm());
        mp_list.add(new TrendFgm());

        return mp_list;
    }

    //设置主页面的viewpager的事件
    private void setMainPager() {

        mainpager.setOffscreenPageLimit(3);
        mainpager.setAdapter(new MainPagerADP(getSupportFragmentManager(), mainpagerData()));
    }

    public Handler getHandler(){
        return handler;
    }

}
