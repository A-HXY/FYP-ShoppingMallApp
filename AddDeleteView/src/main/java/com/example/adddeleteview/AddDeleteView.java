package com.example.adddeleteview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//增加删除按钮
public class AddDeleteView extends LinearLayout implements View.OnClickListener {
    private final Context mContext;
    private ImageView iv_delete;
    private ImageView iv_add;
    private TextView tv_value;
    private int value = 1;
    private int maxValue=5;
    private int minValue=1;

    public AddDeleteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        //把布局文件实例化，并且加载到AddDeleteView类中
        View.inflate(context,R.layout.add_delete_view,this);
        iv_delete=findViewById(R.id.iv_delete);
        iv_add=findViewById(R.id.iv_add);
        tv_value=findViewById(R.id.tv_value);

        int value=getValue();
        setValue(value);
        //点击事件
        iv_delete.setOnClickListener(this);
        iv_add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_add:
                addNumber();
                break;
            case R.id.iv_delete:
                DeleteNumber();
                break;
        }
        Toast.makeText(mContext, "当前产品数量=="+value, Toast.LENGTH_SHORT).show();
    }

    private void DeleteNumber() {
        if (value>minValue){
            value --;
        }
        setValue(value);

        if(onNumberChangeListener !=null){
            onNumberChangeListener.onNumberChange(value);
        }
    }

    private void addNumber() {
        if (value < maxValue){
            value ++;
        }
        setValue(value);

        if(onNumberChangeListener !=null){
            onNumberChangeListener.onNumberChange(value);
        }
    }

    public int getValue() {
        String valueStr = tv_value.getText().toString().trim();
        if (!TextUtils.isEmpty(valueStr)){
            value = Integer.parseInt(valueStr);
        }
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        tv_value.setText(value+"");
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }



    public interface OnNumberChangeListener{
        //当数据发生变化的时候回调
        public void onNumberChange(int value);
    }

    private  OnNumberChangeListener onNumberChangeListener;

    //设置数量变化的监听
    public void setOnNumberChangeListener(OnNumberChangeListener onNumberChangeListener) {
        this.onNumberChangeListener = onNumberChangeListener;
    }

}
