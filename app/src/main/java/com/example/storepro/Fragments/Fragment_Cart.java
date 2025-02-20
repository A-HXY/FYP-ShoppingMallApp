package com.example.storepro.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storepro.Adapter.ShoppingCartAdapter;
import com.example.storepro.Fragments.base.BaseFragment;
import com.example.storepro.Fragments.bean.ProductBean;
import com.example.storepro.R;
import com.example.storepro.StoreActivity;
import com.example.storepro.app.ProductListActivity;
import com.example.storepro.utils.CartStorage;
import com.example.storepro.utils.Constants;

import java.util.List;


public class Fragment_Cart extends BaseFragment implements View.OnClickListener {
    private TextView tvShopcartEdit;
    private RecyclerView recyclerview;
    private LinearLayout llCheckAll;
    private CheckBox checkboxAll;
    private TextView tvShopcartTotal;
    private Button btnCheckOut;
    private LinearLayout llDelete;
    private CheckBox cbAll;
    private Button btnDelete;
    private Button btnCollection;
    //空购物车
    private ImageView ivEmpty;
    private TextView tvEmptyCartTobuy;
    private LinearLayout ll_empty_shopcart;

    private ShoppingCartAdapter adapter;

    private TextView tv_empty_cart_tobuy;


    //编辑状态
    private static final int ACTION_EDIT = 1;
    //完成状态
    private static final int ACTION_COMPLETE = 2;


//    private View cartView;
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        cartView = inflater.inflate(R.layout.module_fragment_cart, container, false);
//        return cartView;
//    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.module_fragment_cart, null);
        tvShopcartEdit = view.findViewById(R.id.tv_shopcart_edit);
        recyclerview = view.findViewById(R.id.recyclerview);
        llCheckAll = view.findViewById(R.id.ll_check_all);
        checkboxAll = view.findViewById(R.id.checkbox_all);
        tvShopcartTotal = view.findViewById(R.id.tv_shopcart_total);
        btnCheckOut = view.findViewById(R.id.btn_check_out);
        llDelete = view.findViewById(R.id.ll_delete);
        cbAll = view.findViewById(R.id.cb_all);
        btnDelete = view.findViewById(R.id.btn_delete);
        btnCollection = view.findViewById(R.id.btn_collection);
        tv_empty_cart_tobuy = view.findViewById(R.id.tv_empty_cart_tobuy);//跳转主页面


        //空购物车
        ivEmpty = view.findViewById(R.id.iv_empty);
        tvEmptyCartTobuy = view.findViewById(R.id.tv_empty_cart_tobuy);
        ll_empty_shopcart = view.findViewById(R.id.ll_empty_shopcart);


        btnCheckOut.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnCollection.setOnClickListener(this);
        tv_empty_cart_tobuy.setOnClickListener(this);


        initListener();

        return view;
    }

    private void initListener() {
        //设置默认的编辑状态
        tvShopcartEdit.setTag(ACTION_EDIT);
        tvShopcartEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int action = (int) v.getTag();
                if (action == ACTION_EDIT) {
                    //切换为完成状态
                    showDelete();
                } else {
                    //切换为编辑状态
                    hideDelete();
                }
            }
        });


    }

    private void hideDelete() {
        //设置状态和文本 编辑
        tvShopcartEdit.setTag(ACTION_EDIT);
        tvShopcartEdit.setText("编辑");
        //变成非勾选
        if (adapter != null) {
            adapter.checkAll_none(true);
            adapter.checkAll();
            adapter.showTotalPrice();
        }
        //删除视图显示
        llDelete.setVisibility(View.GONE);
        //结算视图隐藏
        llCheckAll.setVisibility(View.VISIBLE);
    }

    private void showDelete() {
        //设置状态和文本 完成
        tvShopcartEdit.setTag(ACTION_COMPLETE);
        tvShopcartEdit.setText("完成");
        //变成非勾选
        if (adapter != null) {
            adapter.checkAll_none(false);
            adapter.checkAll();
        }
        //删除视图显示
        llDelete.setVisibility(View.VISIBLE);
        //结算视图隐藏
        llCheckAll.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_check_out:

                break;
            case R.id.btn_delete:
                //删除选中状态
                adapter.deleteData();
                //校验状态
                adapter.checkAll();
                if (adapter.getItemCount() == 0) {
                    emptyShoppingCart();
                }
                break;
            case R.id.btn_collection:

                break;
            case R.id.tv_empty_cart_tobuy:
                Intent intent = new Intent(mContext, StoreActivity.class);
                startActivity(intent);
                //Constants.isBackHome=true;
                break;
        }
    }


    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        showData();
    }

    //显示数据
    @SuppressLint("WrongConstant")
    private void showData() {
        List<ProductBean> productBeanList = CartStorage.getInstance().getAllData();

        if (productBeanList != null && productBeanList.size() > 0) {
            tvShopcartEdit.setVisibility(View.VISIBLE);
            llCheckAll.setVisibility(View.VISIBLE);
            //有商品 隐藏空布局
            ll_empty_shopcart.setVisibility(View.GONE);
            //设置适配器
            adapter = new ShoppingCartAdapter(mContext, productBeanList, tvShopcartTotal, checkboxAll, cbAll);
            recyclerview.setAdapter(adapter);

            //设置布局管理
            recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        } else {
            //无商品 显示空布局
            emptyShoppingCart();
        }
    }

    private void emptyShoppingCart() {

        ll_empty_shopcart.setVisibility(View.VISIBLE);
        tvShopcartEdit.setVisibility(View.GONE);
        llDelete.setVisibility(View.GONE);
    }

}