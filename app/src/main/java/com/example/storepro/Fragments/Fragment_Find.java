package com.example.storepro.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.storepro.Fragments.base.BaseFragment;
import com.example.storepro.Fragments.bean.ProductBean;
import com.example.storepro.R;


public class Fragment_Find extends BaseFragment {

//    private View findView;
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        findView = inflater.inflate(R.layout.module_fragment_find, container, false);
//        return findView;
//    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.module_fragment_find, null);

        WebView webView = view.findViewById(R.id.find_wb_);
        webView.loadUrl("http://www.baidu.com");
        //启用支持javascript
        WebSettings webSettings = webView.getSettings();
        //双击变大变小
        webSettings.setJavaScriptEnabled(true);
        //设置支持javascript
        webSettings.setUseWideViewPort(true);
        //优先使用缓存
        //webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        return view;
    }


}