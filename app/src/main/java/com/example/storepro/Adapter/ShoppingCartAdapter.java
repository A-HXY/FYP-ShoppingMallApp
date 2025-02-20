package com.example.storepro.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.storepro.Fragments.bean.ProductBean;
import com.example.storepro.Fragments.view.AddDeleteView;
import com.example.storepro.R;
import com.example.storepro.utils.CartStorage;
import com.example.storepro.utils.Constants;


import org.w3c.dom.Text;

import java.util.List;

//购物车适配器
public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    private final Context mContext;
    private final List<ProductBean> datas;
    private final TextView tvShopcartTotal;
    private final CheckBox checkboxAll;
    //完成状态下的删除CheckBox
    private final CheckBox cbAll;


    public ShoppingCartAdapter(Context mContext, List<ProductBean> productBeanList, TextView tvShopcartTotal, CheckBox checkboxAll, CheckBox cbAll) {
        this.mContext = mContext;
        this.datas = productBeanList;
        this.tvShopcartTotal = tvShopcartTotal;
        this.checkboxAll = checkboxAll;
        this.cbAll=cbAll;
        showTotalPrice();
        //设置点击事件
        setListener();
        //校验是否全选
        checkAll();
    }

    private void setListener() {
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //根据位置找到对应的bean对象
                ProductBean productBean = datas.get(position);
                //设置取反状态
                productBean.setSelected(!productBean.isSelected());
                //刷新状态
                notifyItemChanged(position);
                //校验是否全选
                checkAll();
                //重新计算总价格
                showTotalPrice();
            }
        });

        //checkbox的点击事件
        checkboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到状态
                boolean isCheck = checkboxAll.isChecked();
                //根据位置设置全选和非全选
                checkAll_none(isCheck);
                //计算总价
                showTotalPrice();
            }
        });

        cbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到状态
                boolean isCheck = cbAll.isChecked();
                //根据位置设置全选和非全选
                checkAll_none(isCheck);
            }
        });
    }

    //设置全选和非全选
    public void checkAll_none(boolean isCheck) {
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                ProductBean productBean = datas.get(i);
                productBean.setSelected(isCheck);
                notifyItemChanged(i);
            }
        }
    }

    public void checkAll() {
        if (datas != null && datas.size() > 0) {
            int number = 0;
            for (int i = 0; i < datas.size(); i++) {
                ProductBean productBean = datas.get(i);
                if (!productBean.isSelected()) {
                    //非全选
                    checkboxAll.setChecked(false);
                    cbAll.setChecked(false);
                } else {
                    //选中的
                    number++;
                }
            }

            if (number == datas.size()) {
                //全选
                checkboxAll.setChecked(true);
                cbAll.setChecked(true);
            }
        }else {
            checkboxAll.setChecked(false);
            cbAll.setChecked(false);
        }
    }

    public void showTotalPrice() {
        tvShopcartTotal.setText("合计：" + getTotalPrice());
    }

    //商品价格合计
    public double getTotalPrice() {
        double totalPrice = 0.0;
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                ProductBean productBean = datas.get(i);
                if (productBean.isSelected()) {
                    totalPrice = totalPrice + Double.valueOf(productBean.getNumber()) * Double.valueOf(productBean.getCover_price());
                }
            }
        }
        return totalPrice;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_shop_cart, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //根据位置等到Bean对象
        final ProductBean productBean = datas.get(position);
        //设置数据
        holder.cb_gov.setChecked(productBean.isSelected());
        Glide.with(mContext).load(Constants.BASE_URl_IMAGE + productBean.getFigure()).into(holder.iv_gov);
        holder.tv_desc_gov.setText(productBean.getName());
        holder.tv_price_gov.setText("￥" + productBean.getCover_price());
        holder.addDeleteView.setValue(productBean.getNumber());
        holder.addDeleteView.setMinValue(1);
        holder.addDeleteView.setMaxValue(50);

        //监听商品数量变化
        holder.addDeleteView.setOnNumberChangeListener(new AddDeleteView.OnNumberChangeListener() {
            @Override
            public void onNumberChange(int value) {
                //当前列表更新
                productBean.setNumber(value);
                //本地更新
                CartStorage.getInstance().updateDate(productBean);
                //刷新适配器
                notifyItemChanged(position);
                //再次计算合计
                showTotalPrice();
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void deleteData() {
        if (datas !=null && datas.size()>0){
            for (int i =0;i<datas.size();i++){
                //删除选中
                ProductBean productBean = datas.get(i);
                if (productBean.isSelected()){
                    //内存中移除
                    datas.remove(productBean);
                    //保存到本地
                    CartStorage.getInstance().deleteDate(productBean);
                    //刷新
                    notifyItemRemoved(i);
                    i--;
                }
            }
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox cb_gov;
        private ImageView iv_gov;
        private TextView tv_desc_gov;
        private TextView tv_price_gov;
        private AddDeleteView addDeleteView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb_gov = itemView.findViewById(R.id.cb_gov);
            iv_gov = itemView.findViewById(R.id.iv_gov);
            tv_desc_gov = itemView.findViewById(R.id.tv_desc_gov);
            tv_price_gov = itemView.findViewById(R.id.tv_price_gov);
            addDeleteView = itemView.findViewById(R.id.addDeleteView);
            //设置item的点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }

    //item监听者
    public interface OnItemClickListener {
        //点击时回调
        public void onItemClick(int position);
    }

    private OnItemClickListener onItemClickListener;

    //设置item监听
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
