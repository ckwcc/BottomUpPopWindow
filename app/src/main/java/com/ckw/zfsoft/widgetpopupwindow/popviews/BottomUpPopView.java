package com.ckw.zfsoft.widgetpopupwindow.popviews;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ckw.zfsoft.widgetpopupwindow.R;

import java.util.List;

/**
 * Created by ckw
 * on 2017/11/24.
 * 从屏幕底部滑出的popupwindow
 */

public class BottomUpPopView extends PopupWindow {

    private TextView mFirstItem;
    private TextView mSecondItem;
    private TextView mThirdItem;
    private Activity mActivity;
    private View mView;
    private List<String> mItemNames;
    private final LayoutInflater minflater;
    View.OnClickListener mItemClickListener;

    /**
     *
     * @param activity
     * @param mItemNames item的名字
     * @param itemClickListener view.onClickListener
     */
    public BottomUpPopView(Activity activity,List<String> mItemNames,View.OnClickListener itemClickListener) {
        this.mItemNames = mItemNames;
        this.mActivity = activity;
        mItemClickListener = itemClickListener;
        minflater = activity.getLayoutInflater();
        init();
    }

    private void init(){
        mView = minflater.inflate(R.layout.pop_bottom_up,null);
        mFirstItem = mView.findViewById(R.id.tv_bottom_up_first_item);
        mSecondItem = mView.findViewById(R.id.tv_bottom_up_second_item);
        mThirdItem = mView.findViewById(R.id.tv_bottom_up_third_item);

        mFirstItem.setText(mItemNames.get(0));
        mSecondItem.setText(mItemNames.get(1));
        mThirdItem.setText(mItemNames.get(2));

        mFirstItem.setOnClickListener(mItemClickListener);
        mSecondItem.setOnClickListener(mItemClickListener);
        mThirdItem.setOnClickListener(mItemClickListener);

        //设置pop的参数
        this.setContentView(mView);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.update();
        this.setAnimationStyle(R.style.Animation);

        //当pop消失的时候就不用再做处理了
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1.0f);
            }
        });



    }

    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager windowManager = mActivity.getWindowManager();
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        mActivity.getWindow().setAttributes(lp);
    }
}
