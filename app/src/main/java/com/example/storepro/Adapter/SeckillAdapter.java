package com.example.storepro.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.storepro.Fragments.bean.ResultBeanData;
import com.example.storepro.R;
import com.example.storepro.utils.Constants;

import java.util.List;

//秒杀适配器
public class SeckillAdapter extends RecyclerView.Adapter<SeckillAdapter.ViewHolder> {

    private final List<ResultBeanData.ResultBean.SeckillInfoBean.ListBean> list;
    private final Context mContext;

    public SeckillAdapter(Context mContext, List<ResultBeanData.ResultBean.SeckillInfoBean.ListBean> list) {
        this.list=list;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=View.inflate(mContext, R.layout.item_seckill,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //根据位置得到对应的数据
        ResultBeanData.ResultBean.SeckillInfoBean.ListBean listBean=list.get(position);
        //绑定数据
        Glide.with(mContext).load(Constants.BASE_URl_IMAGE+listBean.getFigure()).into(holder.iv_figure);
        holder.tv_cover_price.setText("￥"+listBean.getCover_price());
        holder.tv_origin_price.setText("￥"+listBean.getOrigin_price());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_figure;
        private TextView tv_cover_price;
        private TextView tv_origin_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_figure=itemView.findViewById(R.id.iv_figure);
            tv_cover_price=itemView.findViewById(R.id.tv_cover_price);
            tv_origin_price=itemView.findViewById(R.id.tv_origin_price);
            //点击监听
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击秒杀=="+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    if (onSeckillRecyclerView != null) {
                        onSeckillRecyclerView.onItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }
    //监听器
    public interface OnSeckillRecyclerView{
        //当某条被点击的时候回调
        public void onItemClick(int position);
    }
    private OnSeckillRecyclerView onSeckillRecyclerView;
    //设置监听
    public void setOnSeckillRecyclerView(OnSeckillRecyclerView onSeckillRecyclerView) {
        this.onSeckillRecyclerView = onSeckillRecyclerView;
    }
}
