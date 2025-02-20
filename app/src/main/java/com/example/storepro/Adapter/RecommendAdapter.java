package com.example.storepro.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.storepro.Fragments.bean.ResultBeanData;
import com.example.storepro.R;
import com.example.storepro.utils.Constants;

import java.util.List;

import butterknife.BindView;
//首发
public class RecommendAdapter extends BaseAdapter implements View.OnClickListener {
    private final Context mContext;
    private final List<ResultBeanData.ResultBean.RecommendInfoBean> datas;

    public RecommendAdapter(Context mContext, List<ResultBeanData.ResultBean.RecommendInfoBean> recommend_info) {
        this.mContext=mContext;
        this.datas=recommend_info;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_recommend_grid_view, null);
            viewHolder=new ViewHolder();
            viewHolder.iv_recommend=convertView.findViewById(R.id.iv_recommend);
            viewHolder.tv_name=convertView.findViewById(R.id.tv_name);
            viewHolder.tv_price=convertView.findViewById(R.id.tv_price);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //根据位置得到对应数据
        ResultBeanData.ResultBean.RecommendInfoBean recommendInfoBean = datas.get(position);
        Glide.with(mContext).load(Constants.BASE_URl_IMAGE+recommendInfoBean.getFigure()).into(viewHolder.iv_recommend);
        viewHolder.tv_name.setText(recommendInfoBean.getName());
        viewHolder.tv_price.setText("￥"+recommendInfoBean.getCover_price());


        return convertView;
    }

    @Override
    public void onClick(View v) {

    }

    static class ViewHolder {
        private ImageView iv_recommend;
        private TextView tv_name;
        private TextView tv_price;

    }


}
