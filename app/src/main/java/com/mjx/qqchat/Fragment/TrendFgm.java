package com.mjx.qqchat.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjx.qqchat.Adapter.RVTrendADP;
import com.mjx.qqchat.Bean.TrendList;
import com.mjx.qqchat.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/28.
 */

public class TrendFgm extends Fragment {

    @BindView(R.id.rv_trend)
    RecyclerView rv_trend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trend, null);
        ButterKnife.bind(this,view);
        setRVtrend();

        return view;
    }

    private void setRVtrend() {

        List<TrendList> list = new ArrayList<TrendList>();

        String[] urls = new String[]{
                "http://data.163.com/17/0302/13/CEHBV37T000181IU.html",
                "http://news.163.com/17/0307/00/CESR8QHU00018AOQ.html",
                "http://news.163.com/17/0307/02/CET2IORJ000187VI.html"
        };

        int[] images = new int[]{
                R.mipmap.alcohol,
                R.mipmap.forest_background,
                R.mipmap.waterball
        };

        String[] titles = new String[]{
                "不用意外，未来15年中国将成劳动力缺口大国",
                "三大电信运营商提速降费 算算你能省多少钱",
                "私立小学招生要求家长本科学历"
        };

        String[] contents = new String[]{
                "“中国最不缺的就是人”，很少有人会把中国跟人力短缺联系到一起，几乎所有人都更习惯13亿人口大国这一固定搭配。当我们脱口而出中国人口总数世界第一，这是事实，但这一基数也意味着随着老龄化的加速进程，中国即将成为劳动力缺口第一大国，这也在逐渐成为事实。",
                "中新网北京3月7日电 6日，三大电信运营商公布新一轮提速降费措施。今年将取消国内漫游费；进一步降低国际长途资费；大幅降低中小企业专线资费。专家测算，若国际长途资降10%将惠及用户近2900万户，年降费总额将超6亿元；若互联网专线接入价格降10%，数千万企业用户年降费总额将近40亿元。对降低“双创”成本、推动产业转型升级、打造经济增长新动能具有重大意义。",
                "近日，广州一私立小学招生要求“学生家长的学历是本科以上”一事引发网友广泛讨论。3月6日下午，北京青年报记者致电该私立小学，工作人员称学校此前确实有这一规定，但目前已经取消了这一条件限制。该校所属教育局广州市番禺区教育局办公室工作人员表示，“要求学生家长的学历是本科以上”这一规定不合规，要求学校立即停止该宣传行为，并提出整改措施。"
        };

        for(int i = 0; i< titles.length;i++){
            list.add(new TrendList(urls[i],images[i],titles[i],contents[i]));
        }

        LinearLayoutManager lm  = new LinearLayoutManager(this.getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_trend.setLayoutManager(lm);
        rv_trend.setAdapter(new RVTrendADP(list));

    }


}
