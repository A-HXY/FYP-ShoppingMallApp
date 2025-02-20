package com.example.storepro.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.storepro.Fragments.bean.ProductBean;
import com.example.storepro.Fragments.bean.ResultBeanData;
import com.example.storepro.R;
import com.example.storepro.app.ProductListActivity;
import com.example.storepro.utils.Constants;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnLoadImageListener;
import com.zhy.magicviewpager.transformer.AlphaPageTransformer;
import com.zhy.magicviewpager.transformer.ScaleInTransformer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter {

    //广告
    public static final int BANNER = 0;
    //频道
    public static final int CHANNEL = 1;
    //活动
    public static final int ACT = 2;
    //秒杀
    public static final int SECKILL = 3;
    //推荐
    public static final int RECOMMEND = 4;
    //热门
    public static final int HOT = 5;
    private static final String PRODUCT_BEAN ="productBean" ;
    //初始化布局
    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    //数据
    private ResultBeanData.ResultBean resultBean;

    //当前类型
    private int currentType = BANNER;

    public HomeFragmentAdapter(Context mContext, ResultBeanData.ResultBean resultBean) {
        this.mContext = mContext;
        this.resultBean = resultBean;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    //广告
    class BannerViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private Banner banner;

        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            this.banner = itemView.findViewById(R.id.banner);
        }

        //设置banner数据
        public void setData(List<ResultBeanData.ResultBean.BannerInfoBean> banner_info) {
            //设置循环指标点
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //得到图片集合地址
            List<String> imagesUrl = new ArrayList<>();
            for (int i = 0; i < resultBean.getBanner_info().size(); i++) {
                String imageUrl = banner_info.get(i).getImage();
                imagesUrl.add(imageUrl);
            }
            //设置类似手风琴动画
            banner.setBannerAnimation(Transformer.Accordion);
            //设置加载图片
            banner.setImages(imagesUrl, new OnLoadImageListener() {
                @Override
                public void OnLoadImage(ImageView view, Object url) {
                    /**
                     * 这里你可以根据框架灵活设置
                     * 使用 Glide 请求网络
                     */
                    Glide.with(mContext)
                            .load(Constants.BASE_URl_IMAGE + url)
                            .into(view);
                }
            });
            //item点击事件
            banner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(mContext, "点击轮播图==" + position, Toast.LENGTH_SHORT).show();

//                    ProductBean productBean = new ProductBean();
//                    productBean.setCover_price(listBean.getCover_price());
//                    productBean.setFigure(listBean.getFigure());
//                    productBean.setName(listBean.getName());
//                    productBean.setProduct_id(listBean.getProduct_id());
                    //startProductListActivity(productBean);
                }
            });
        }
    }

    //启动商品信息列表详情页面
    private void startProductListActivity(ProductBean productBean) {
        Intent intent = new Intent(mContext, ProductListActivity.class);
        intent.putExtra(PRODUCT_BEAN,productBean);
        mContext.startActivity(intent);
    }

    class ChannelViewHolder extends RecyclerView.ViewHolder {

        private GridView gvChannel;
        private Context mContext;
        private ChannelAdapter adapter;

        public ChannelViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            gvChannel = itemView.findViewById(R.id.gv_channel);
        }

        //得到数据，设置Gridview的适配器
        public void setData(List<ResultBeanData.ResultBean.ChannelInfoBean> channel_info) {
            adapter = new ChannelAdapter(mContext, channel_info);
            gvChannel.setAdapter(adapter);
            //点击事件
            gvChannel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    if (position <= 8) {

                    }
                    Toast.makeText(mContext, "position==" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    class ActViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private ViewPager act_viewpager;

        public ActViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            act_viewpager = itemView.findViewById(R.id.act_viewpager);
        }

        public void setData(List<ResultBeanData.ResultBean.ActInfoBean> act_info) {
            //设置每个页面的间距
            act_viewpager.setPageMargin(20);
            //>=3
            act_viewpager.setOffscreenPageLimit(3);
            //设置动画
            act_viewpager.setPageTransformer(true, new AlphaPageTransformer(new ScaleInTransformer()));
            //有数据时启动适配器
            act_viewpager.setAdapter(new PagerAdapter() {
                @Override
                public int getCount() {
                    return act_info.size();
                }

                @Override
                public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                    return view == object;
                }

                @NonNull
                @Override
                public Object instantiateItem(@NonNull ViewGroup container, int position) {
                    ImageView imageView = new ImageView(mContext);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                    Glide.with(mContext).load(Constants.BASE_URl_IMAGE + act_info.get(position).getIcon_url()).into(imageView);
                    //添加到容器
                    container.addView(imageView);

                    //设置点击事件
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(mContext, "点击的页面==" + position, Toast.LENGTH_SHORT).show();
                        }
                    });
                    return imageView;
                }

                @Override
                public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                    container.removeView((View) object);
                }
            });
        }
    }

    //秒杀
    class SeckillViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        private TextView tv_time_seckill;
        private TextView tv_more_seckill;
        private RecyclerView rv_seckill;
        private SeckillAdapter adapter;

        private TextView tvTime;
        private boolean isFirst;
        private long dt;
        private Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                dt = dt - 1000;
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                String time = formatter.format(new Date(dt));
                tv_time_seckill.setText(time);

                handler.removeMessages(0);
                handler.sendEmptyMessageDelayed(0, 1000);
                if (dt <= 0) {
                    //把消息移除
                    handler.removeCallbacksAndMessages(null);
                }
            }
        };

        public SeckillViewHolder(Context mContext, View itemView) {
            super(itemView);
            tv_time_seckill = itemView.findViewById(R.id.tv_time_seckill);
            tv_more_seckill = itemView.findViewById(R.id.tv_more_seckill);
            rv_seckill = itemView.findViewById(R.id.rv_seckill);
            this.mContext = mContext;
        }

        public void setData(ResultBeanData.ResultBean.SeckillInfoBean seckill_info) {
            //设置数据 文本和RecyclerView的数据
            adapter = new SeckillAdapter(mContext, seckill_info.getList());
            rv_seckill.setAdapter(adapter);

            //设置布局管理器
            rv_seckill.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            //设置item的点击事件
            adapter.setOnSeckillRecyclerView(new SeckillAdapter.OnSeckillRecyclerView() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(mContext, "点击秒杀==" + position, Toast.LENGTH_SHORT).show();
                    ResultBeanData.ResultBean.SeckillInfoBean.ListBean listBean= seckill_info.getList().get(position);
                    //秒杀商品
                    ProductBean productBean = new ProductBean();
                    productBean.setCover_price(listBean.getCover_price());
                    productBean.setFigure(listBean.getFigure());
                    productBean.setName(listBean.getName());
                    productBean.setProduct_id(listBean.getProduct_id());
                    productBean.setDetails(listBean.getDetails());
                    startProductListActivity(productBean);
                }
            });
            //秒杀倒计时 毫秒
            dt = Integer.valueOf(seckill_info.getEnd_time()) - Integer.valueOf(seckill_info.getStart_time());

            handler.sendEmptyMessageDelayed(0, 1000);
        }
    }

    //首发
    class RecommendViewHolder extends RecyclerView.ViewHolder {

        private final Context mContext;
        private TextView tv_more_recommend;
        private GridView gv_recommend;
        private RecommendAdapter adapter;

        public RecommendViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            tv_more_recommend = itemView.findViewById(R.id.tv_more_recommend);
            gv_recommend = itemView.findViewById(R.id.gv_recommend);

        }

        public void setData(List<ResultBeanData.ResultBean.RecommendInfoBean> recommend_info) {
            //有数据 设置适配器
            adapter = new RecommendAdapter(mContext, recommend_info);
            gv_recommend.setAdapter(adapter);

            gv_recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "点击首发=" + position, Toast.LENGTH_SHORT).show();
                    ResultBeanData.ResultBean.RecommendInfoBean recommendInfoBean = recommend_info.get(position);
                    //推荐商品
                    ProductBean productBean = new ProductBean();
                    productBean.setCover_price(recommendInfoBean.getCover_price());
                    productBean.setFigure(recommendInfoBean.getFigure());
                    productBean.setName(recommendInfoBean.getName());
                    productBean.setProduct_id(recommendInfoBean.getProduct_id());
                    productBean.setDetails(recommendInfoBean.getDetails());
                    startProductListActivity(productBean);
                }
            });
        }
    }

    //热卖 推荐
    class HotViewHolder extends RecyclerView.ViewHolder{
        private final Context mContext;
        private TextView tv_more_hot;
        private GridView gv_hot;
        private HotAdapter adapter;

        public HotViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext=mContext;
            tv_more_hot=itemView.findViewById(R.id.tv_more_hot);
            gv_hot=itemView.findViewById(R.id.gv_hot);

        }

        public void setData(List<ResultBeanData.ResultBean.HotInfoBean> hot_info) {
            //有数据 设置是配置
            adapter = new HotAdapter(mContext,hot_info);
            gv_hot.setAdapter(adapter);

            //设置item的点击监听
            gv_hot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "点击热卖="+position, Toast.LENGTH_SHORT).show();
                    ResultBeanData.ResultBean.HotInfoBean hotInfoBean= hot_info.get(position);
                    //热卖商品信息类
                    ProductBean productBean = new ProductBean();
                    productBean.setCover_price(hotInfoBean.getCover_price());
                    productBean.setFigure(hotInfoBean.getFigure());
                    productBean.setName(hotInfoBean.getName());
                    productBean.setProduct_id(hotInfoBean.getProduct_id());
                    productBean.setDetails(hotInfoBean.getDetails());
                    startProductListActivity(productBean);
                }
            });
        }
    }

    /**
     * 创建ViewHolder 相当与getview
     *
     * @param parent
     * @param viewType 当前类型
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            return new BannerViewHolder(mContext, mLayoutInflater.inflate(R.layout.banner_viewpager, null));
        } else if (viewType == CHANNEL) {
            return new ChannelViewHolder(mContext, mLayoutInflater.inflate(R.layout.channel_item, null));
        } else if (viewType == ACT) {
            return new ActViewHolder(mContext, mLayoutInflater.inflate(R.layout.act_item, null));
        } else if (viewType == SECKILL) {
            return new SeckillViewHolder(mContext, mLayoutInflater.inflate(R.layout.seckill_item, null));
        } else if (viewType == RECOMMEND) {
            return new RecommendViewHolder(mContext, mLayoutInflater.inflate(R.layout.recommend_item, null));
        }else if (viewType == HOT) {
            return new HotViewHolder(mContext, mLayoutInflater.inflate(R.layout.hot_item, null));
        }

        return null;
    }

    /**
     * 创建ViewHolder 相当于getview  创建ViewHolder部分代码
     *
     * @param holder
     * @param position 当前类型
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.setData(resultBean.getBanner_info());
        } else if (getItemViewType(position) == CHANNEL) {
            ChannelViewHolder channelViewHolder = (ChannelViewHolder) holder;
            channelViewHolder.setData(resultBean.getChannel_info());
        } else if (getItemViewType(position) == ACT) {
            ActViewHolder actViewHolder = (ActViewHolder) holder;
            actViewHolder.setData(resultBean.getAct_info());
        } else if (getItemViewType(position) == SECKILL) {
            SeckillViewHolder seckillViewHolder = (SeckillViewHolder) holder;
            seckillViewHolder.setData(resultBean.getSeckill_info());
        } else if (getItemViewType(position) == RECOMMEND) {
            RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
            recommendViewHolder.setData(resultBean.getRecommend_info());
        }else if (getItemViewType(position) == HOT) {
            HotViewHolder hotViewHolder = (HotViewHolder) holder;
            hotViewHolder.setData(resultBean.getHot_info());
        }

    }

    /**
     * 得到类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case BANNER:
                currentType = BANNER;
                break;
            case CHANNEL:
                currentType = CHANNEL;
                break;
            case ACT:
                currentType = ACT;
                break;
            case SECKILL:
                currentType = SECKILL;
                break;
            case RECOMMEND:
                currentType = RECOMMEND;
                break;
            case HOT:
                currentType = HOT;
                break;
        }
        return currentType;
    }

    //总共有多少给item
    @Override
    public int getItemCount() {
        return 6;
    }

}
