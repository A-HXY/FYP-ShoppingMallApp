package com.example.storepro.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.example.storepro.Fragments.bean.ProductBean;
import com.example.storepro.R;
import com.example.storepro.utils.CartStorage;
import com.example.storepro.utils.Constants;

//商品详情

public class ProductListActivity extends Activity implements View.OnClickListener {
    private ImageButton ibGoodInfoBack;
    private ImageButton ibGoodInfoMore;
    private ImageView ivGoodInfoImage;
    private ImageView ivDetailsImage;
    //private AppCompatImageView ivDetailsImage;
    private TextView tvGoodInfoName;
    private TextView tvGoodInfoDesc;
    private TextView tvGoodInfoPrice;
    private TextView tvGoodInfoStore;
    private TextView tvGoodInfoStyle;
    private WebView wbGoodInfoMore;
    private LinearLayout llGoodsRoot;
    private TextView tvGoodInfoCallcenter;
    private TextView tvGoodInfoCollection;
    private TextView tvGoodInfoCart;
    private Button btnGoodInfoAddcart;
    private TextView tv_more_share;
    private TextView tv_more_search;
    private TextView tv_more_home;
    private Button btn_more;
    private ProductBean productBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        initView();

        //接收数据
        productBean = (ProductBean) getIntent().getSerializableExtra("productBean");
        if (productBean !=null){
            //Toast.makeText(this, "productBean=="+productBean.toString(), Toast.LENGTH_SHORT).show();
            setDataForView(productBean);
        }

    }
    //设置数据
    private void setDataForView(ProductBean productBean) {
        //设置图片
        //iv_good_info_image
        Glide.with(this).load(Constants.BASE_URl_IMAGE+productBean.getFigure()).into(ivGoodInfoImage);
        //商品详情
        Glide.with(this).load(Constants.BASE_URl_IMAGE+productBean.getDetails()).into(ivDetailsImage);
        //设置名称
        tvGoodInfoName.setText(productBean.getName());
        //设置描述
        tvGoodInfoDesc.setText(productBean.getBrief());
        //设置价格
        tvGoodInfoPrice.setText("￥"+productBean.getCover_price());
        //网页
        //setWebViewData(productBean.getProduct_id());
    }

//    private void setWebViewData(String product_id) {
//        if (product_id !=null){
//            //https://www.mi.com/redminote11pro
//            wbGoodInfoMore.loadUrl("https://www.mi.com/redminote11pro");
//            //启用支持javascript
//            WebSettings webSettings = wbGoodInfoMore.getSettings();
//            //双击变大变小
//            webSettings.setJavaScriptEnabled(true);
//            //设置支持javascript
//            webSettings.setUseWideViewPort(true);
//            //优先使用缓存
//            wbGoodInfoMore.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//
//            wbGoodInfoMore.setWebViewClient(new WebViewClient(){
//                @Override
//                public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
//                    view.loadUrl(url);
//                    return true;
//                }
//            });
//        }
//    }

    private void initView() {
        ibGoodInfoBack = findViewById( R.id.ib_good_info_back );
        ibGoodInfoMore = findViewById( R.id.ib_good_info_more );
        ivGoodInfoImage = findViewById( R.id.iv_good_info_image );
        ivDetailsImage = findViewById(R.id.iv_details_image);
        tvGoodInfoName = findViewById( R.id.tv_good_info_name );
        tvGoodInfoDesc = findViewById( R.id.tv_good_info_desc );
        tvGoodInfoPrice = findViewById( R.id.tv_good_info_price );
        tvGoodInfoStore = findViewById( R.id.tv_good_info_store );
        tvGoodInfoStyle = findViewById( R.id.tv_good_info_style );
        //wbGoodInfoMore = findViewById( R.id.wb_good_info_more );

        llGoodsRoot = findViewById( R.id.ll_goods_root );
        tvGoodInfoCallcenter = findViewById( R.id.tv_good_info_callcenter );
        tvGoodInfoCollection = findViewById( R.id.tv_good_info_collection );
        tvGoodInfoCart = findViewById( R.id.tv_good_info_cart );
        btnGoodInfoAddcart = findViewById( R.id.btn_good_info_addcart );

        tv_more_share=findViewById(R.id.tv_more_share);//分享
        tv_more_search=findViewById(R.id.tv_more_search);//搜索
        tv_more_home=findViewById(R.id.tv_more_home);//跳转主页
        btn_more=findViewById(R.id.btn_more);//更多-

        ibGoodInfoBack.setOnClickListener( this );//返回
        ibGoodInfoMore.setOnClickListener( this );//更多
        btnGoodInfoAddcart.setOnClickListener( this );//添加到购物车

        tvGoodInfoCallcenter.setOnClickListener(this);//联系客服
        tvGoodInfoCollection.setOnClickListener(this);//收藏
        tvGoodInfoCart.setOnClickListener(this);//跳转购物车

        tv_more_share.setOnClickListener(this);//分享
        tv_more_search.setOnClickListener(this);//搜索
        tv_more_home.setOnClickListener(this);//跳转主页
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_good_info_back:
                //返回
                finish();
                break;
            case R.id.ib_good_info_more:
                //更多
                Toast.makeText(this, "点击了更多", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_good_info_addcart:
                //添加购物车
                Toast.makeText(this, "添加购物车成功", Toast.LENGTH_SHORT).show();
                CartStorage.getInstance().addDate(productBean);
                break;
            case R.id.tv_good_info_callcenter:
                //联系客服
                Toast.makeText(this, "点击了联系客服", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_good_info_collection:
                //收藏
                Toast.makeText(this, "点击了收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_good_info_cart:
                //跳转购物车
                Toast.makeText(this, "点击了跳转购物车", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(this, );
                //startActivity(intent);
                break;
            case R.id.tv_more_share:
                //分享
                Toast.makeText(this, "点击了分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_more_search:
                //搜索
                Toast.makeText(this, "点击了搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_more_home:
                //跳转主页面
                Toast.makeText(this, "点击了跳转主页面", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
