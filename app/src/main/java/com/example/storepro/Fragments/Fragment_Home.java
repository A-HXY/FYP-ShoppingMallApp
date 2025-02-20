package com.example.storepro.Fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.alibaba.fastjson.JSON;
import com.example.storepro.Adapter.HomeFragmentAdapter;
import com.example.storepro.Fragments.base.BaseFragment;
import com.example.storepro.Fragments.bean.ResultBeanData;
import com.example.storepro.R;
import com.example.storepro.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


public class Fragment_Home extends BaseFragment implements View.OnClickListener {
    private View homeView;
    private TextView tv_search_home;
    private TextView tv_messge_hpme;
    private ImageView ib_top;
    private RecyclerView rv_Home;
    private HomeFragmentAdapter adapter;
    private ResultBeanData.ResultBean resultBean; //返回的数据

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.module_fragment_home, container, false);
        tv_search_home=homeView.findViewById(R.id.tv_search_home);
        tv_messge_hpme=homeView.findViewById(R.id.tv_message_home);
        ib_top=homeView.findViewById(R.id.ib_top);
        rv_Home=homeView.findViewById(R.id.rv_home);

        tv_search_home.setOnClickListener(this);
        tv_messge_hpme.setOnClickListener(this);
        ib_top.setOnClickListener(this);

        //initData();
        return homeView;
    }

    @Override
    public View initView() {
        return null;
    }

    public void initData() {
        //
        getDateFromNet();
    }

    private void getDateFromNet() {
        String url = Constants.HOME_URL;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    /**
                     * 请求失败
                     * @param call
                     * @param e
                     * @param id
                     */
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    /**
                     * 请求成功
                     * @param response
                     * @param id
                     */
                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("成功", "onResponse: "+response );
                        processData(response);
                    }

                });
    }

    private void processData(String json) {
        ResultBeanData resultBeanData = JSON.parseObject(json,ResultBeanData.class);
        resultBean = resultBeanData.getResult();
        if (resultBean !=null){
            //有数据 设置适配器
            adapter=new HomeFragmentAdapter(homeView.getContext(),resultBean);
            rv_Home.setAdapter(adapter);
            rv_Home.setLayoutManager(new GridLayoutManager(mContext,1));
//            adapter = new HomeFragmentAdapter(mContext, resultBean);
//            rv_Home.setAdapter(adapter);
//            GridLayoutManager manager = new GridLayoutManager(mContext, 1);
//            //设置滑动到哪个位置了的监听
//            manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                @Override
//                public int getSpanSize(int position) {
//                    if (position <= 3) {
//                        //隐藏
//                        ib_top.setVisibility(View.GONE);
//                    } else  {
//                        //显示
//                        ib_top.setVisibility(View.VISIBLE);
//                    }
//                    //只能返回 1
//                    return 1;
//                }
//            });
//            //设置网格布局
//            rv_Home.setLayoutManager(manager);
        }else {
            //没有数据
        }
        Log.e("解析成功", "processData: "+resultBean.getHot_info().get(0).getName() );;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_search_home:
                Toast.makeText(mContext, "点击搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_message_home:
                Toast.makeText(mContext, "点击消息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_top:
                //回到顶部
                rv_Home.scrollToPosition(0);
                break;
        }
    }
}