package com.example.storepro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.example.storepro.Adapter.SectionsPagerAdaper;
import com.example.storepro.Fragments.Fragment_Category;
import com.example.storepro.Fragments.Fragment_Home;
import com.example.storepro.Fragments.Fragment_Find;
import com.example.storepro.Fragments.Fragment_Cart;
import com.example.storepro.Fragments.Fragment_Me;
import com.example.storepro.Fragments.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


//public class StoreActivity extends AppCompatActivity{

//    private TabLayout myTab;
//    private ViewPager2 myPager2;
//    List<String> titles=new ArrayList<>();
//    List<Integer> icons=new ArrayList<>();
//    List<Fragment> fragments=new ArrayList<>();
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_store);
//
//        myTab = findViewById(R.id.tab);
//        myPager2 = findViewById(R.id.viewpager2);
//
//        //添加标题
//        titles.add("主页");
//        titles.add("分类");
//        titles.add("发现");
//        titles.add("购物车");
//        titles.add("我的");
//
//        icons.add(R.drawable.ic_bottom_home);
//        icons.add(R.drawable.ic_bottom_sort);
//        icons.add(R.drawable.ic_bottom_find);
//        icons.add(R.drawable.ic_bottom_cart);
//        icons.add(R.drawable.ic_bottom_me);
//
//        //添加Fragment进去
//        fragments.add(new Fragment_Home());
//        fragments.add(new Fragment_Sort());
//        fragments.add(new Fragment_Find());
//        fragments.add(new Fragment_Cart());
//        fragments.add(new Fragment_Me());
//
//
//
//        myTab.setTabMode(TabLayout.MODE_FIXED);
//
//        //实例化适配器
//        SectionsPagerAdaper sectionsPagerAdaper =new SectionsPagerAdaper(getSupportFragmentManager(),getLifecycle(),fragments);
//
//        //设置适配器
//        myPager2.setAdapter(sectionsPagerAdaper);
//
//        //TabLayout和Viewpager2进行关联
//        new TabLayoutMediator(myTab, myPager2, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                tab.setText(titles.get(position));
//                tab.setIcon(icons.get(position));
//            }
//        }).attach();
//
//    }

//}
//implements View.OnClickListener
public class StoreActivity extends FragmentActivity  {

//    private FrameLayout frameLayout;
//    private RadioButton rbHome;
//    private RadioButton rbType;
//    private RadioButton rbCommunity;
//    private RadioButton rbCart;
//    private RadioButton rbUser;
//    private RadioGroup rgMain;
    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_type)
    RadioButton rbType;
    @BindView(R.id.rb_community)
    RadioButton rbCommunity;
    @BindView(R.id.rb_cart)
    RadioButton rbCart;
    @BindView(R.id.rb_user)
    RadioButton rbUser;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    private ArrayList<BaseFragment> fragments;
    private int position;
    private Fragment tempFragemnt;
//    private Fragment_Home fragment_home;
//    private Fragment_Cart fragment_cart;
//
//    //跳转主页
//    public void gotoFragmentHome(){
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ButterKnife.bind(this);
        initFragment();
        initListener();
        //initView();
    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        position=0;
                        break;
                    case R.id.rb_type:
                        position=1;
                        break;
                    case R.id.rb_community:
                        position=2;
                        break;
                    case R.id.rb_cart:
                        position=3;
                        break;
                    case R.id.rb_user:
                        position=4;
                        break;
                }
                BaseFragment baseFragment = getFragment(position);
                switchFragment(tempFragemnt, baseFragment);
            }
        });
        rgMain.check(R.id.rb_home);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment_Home());
        fragments.add(new Fragment_Category());
        fragments.add(new Fragment_Find());
        fragments.add(new Fragment_Cart());
        fragments.add(new Fragment_Me());
    }

    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (tempFragemnt != nextFragment) {
            tempFragemnt = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }


//    private void initView() {
//        frameLayout=findViewById(R.id.frameLayout);
//        rbHome=findViewById(R.id.rb_home);
//        rbType=findViewById(R.id.rb_type);
//        rbCommunity=findViewById(R.id.rb_community);
//        rbCart=findViewById(R.id.rb_cart);
//        rbUser=findViewById(R.id.rb_user);
//        rgMain=findViewById(R.id.rg_main);
//        //设置点击事件监听器
//        frameLayout.setOnClickListener(this);
//        rbHome.setOnClickListener(this);
//        rbType.setOnClickListener(this);
//        rbCommunity.setOnClickListener(this);
//        rbCart.setOnClickListener(this);
//        rbUser.setOnClickListener(this);
//        rgMain.setOnClickListener(this);
//    }

//    @Override
//    public void onClick(View v) {
//        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId){
//                    case R.id.rb_home:
//                        position=0;
//                        break;
//                    case R.id.rb_type:
//                        position=1;
//                        break;
//                    case R.id.rb_community:
//                        position=2;
//                        break;
//                    case R.id.rb_cart:
//                        position=3;
//                        break;
//                    case R.id.rb_user:
//                        position=4;
//                        break;
//                }
//                BaseFragment baseFragment = getFragment(position);
//                switchFragment(tempFragemnt, baseFragment);
//            }
//        });
//        rgMain.check(R.id.rv_home);
//    }

}
